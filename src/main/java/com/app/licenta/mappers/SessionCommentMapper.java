package com.app.licenta.mappers;

import com.app.licenta.dtos.SessionCommentDto;
import com.app.licenta.entities.SessionComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SessionCommentMapper {

    @Autowired
    private ParentMapper parentMapper;

    @Autowired
    private TrainerMapper trainerMapper;

    @Autowired
    private SessionMapper sessionMapper;

    public SessionComment sessionCommentDtoToSessionComment(SessionCommentDto sessionCommentDto) {
        SessionComment sessionComment = new SessionComment();
        sessionComment.setContent(sessionCommentDto.getContent());
        sessionComment.setCreatedAt(LocalDateTime.now());
        return sessionComment;
    }

    public SessionCommentDto sessionCommentToSessionCommentDto(SessionComment sessionComment, boolean isTrainer, Integer userId) {
        SessionCommentDto sessionCommentDto = new SessionCommentDto();
        sessionCommentDto.setId(sessionComment.getId());
        sessionCommentDto.setContent(sessionComment.getContent());
        sessionCommentDto.setCreatedAt(sessionComment.getCreatedAt());
        if (sessionComment.getAuthorParent() != null) {
            sessionCommentDto.setAuthorParent(parentMapper.parentToParentWithChildrenDto(sessionComment.getAuthorParent(), sessionComment.getSession().getGroup().getChildren().stream().toList()));
        } else {
            sessionCommentDto.setAuthorTrainer(trainerMapper.trainerToTrainerDto(sessionComment.getAuthorTrainer()));
        }
        sessionCommentDto.setRead(false);
        if (sessionComment.getReadByTrainer() != null && isTrainer && sessionComment.getReadByTrainer().getId().equals(userId)) {
            sessionCommentDto.setRead(true);
        }
        if (!sessionComment.getReadByParents().isEmpty() && !isTrainer) {
            sessionCommentDto.setRead(sessionComment.getReadByParents().stream().anyMatch(parent -> parent.getId().equals(userId)));
        }
        return sessionCommentDto;
    }

    public List<SessionCommentDto> sessionCommentListToSessionCommentDtoList(List<SessionComment> sessionComments, boolean isTrainer, Integer userId) {
        return sessionComments.stream()
                .map(comment -> sessionCommentToSessionCommentDto(comment, isTrainer, userId))
                .toList();
    }


}
