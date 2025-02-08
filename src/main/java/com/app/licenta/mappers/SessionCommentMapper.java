package com.app.licenta.mappers;

import com.app.licenta.dtos.SessionCommentDto;
import com.app.licenta.entities.SessionComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SessionCommentMapper {

    @Autowired
    private ParentMapper parentMapper;

    @Autowired
    private TrainerMapper trainerMapper;

    @Autowired
    private SessionMapper sessionMapper;

    public SessionComment sessionCommentDtoToSessionComment(SessionCommentDto sessionCommentDto){
        SessionComment sessionComment = new SessionComment();
        //sessionComment.setId(sessionCommentDto.getId());
        sessionComment.setContent(sessionCommentDto.getContent());
        sessionComment.setCreatedAt(sessionCommentDto.getCreatedAt());
        if(sessionCommentDto.getAuthorParent() != null)
            sessionComment.setAuthorParent(parentMapper.parentDtoToParent(sessionCommentDto.getAuthorParent()));
        else
            sessionComment.setAuthorTrainer(trainerMapper.trainerDtoToTrainer(sessionCommentDto.getAuthorTrainer()));
        sessionComment.setSession(sessionMapper.sessionDtoToSession(sessionCommentDto.getSession()));
        if(sessionCommentDto.getReadByParents() != null)
            sessionComment.setReadByParents(sessionCommentDto.getReadByParents().stream().map(parentMapper::parentDtoToParent).collect(Collectors.toSet()));
        if(sessionCommentDto.getReadByTrainer() != null)
            sessionComment.setReadByTrainer(trainerMapper.trainerDtoToTrainer(sessionCommentDto.getReadByTrainer()));
        return sessionComment;
    }

    public SessionCommentDto sessionCommentToSessionCommentDto(SessionComment sessionComment){
        SessionCommentDto sessionCommentDto = new SessionCommentDto();
        sessionCommentDto.setId(sessionComment.getId());
        sessionCommentDto.setContent(sessionComment.getContent());
        sessionCommentDto.setCreatedAt(sessionComment.getCreatedAt());
        if(sessionComment.getAuthorParent() != null)
            sessionCommentDto.setAuthorParent(parentMapper.parentToParentDto(sessionComment.getAuthorParent()));
        else
            sessionCommentDto.setAuthorTrainer(trainerMapper.trainerToTrainerDto(sessionComment.getAuthorTrainer()));
        if(sessionComment.getSession() != null)
            sessionCommentDto.setSession(sessionMapper.sessionToSessionDto(sessionComment.getSession()));
        if(sessionComment.getReadByParents() != null)
            sessionCommentDto.setReadByParents(sessionComment.getReadByParents().stream().map(parentMapper::parentToParentDto).collect(Collectors.toSet()));
        if(sessionComment.getReadByTrainer() != null)
            sessionCommentDto.setReadByTrainer(trainerMapper.trainerToTrainerDto(sessionComment.getReadByTrainer()));
        return sessionCommentDto;
    }

    public Set<SessionCommentDto> sessionCommentListToSessionCommentDtoList(Set<SessionComment> sessionComments){
        return sessionComments.stream().map(this::sessionCommentToSessionCommentDto).collect(Collectors.toSet());
    }


}
