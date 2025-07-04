package com.app.licenta.mappers;

import com.app.licenta.dtos.SessionDto;
import com.app.licenta.dtos.SessionGetDto;
import com.app.licenta.entities.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SessionMapper {

    @Autowired
    private GroupMapper groupMapper;

    public Session sessionDtoToSession(SessionDto sessionDto) {
        Session session = new Session();
        session.setStartDateTime(sessionDto.getStartDateTime());
        session.setEndDateTime(sessionDto.getEndDateTime());
        session.setNote(sessionDto.getNote());
        return session;
    }

    public SessionGetDto sessionToSessionGetDto(Session session, boolean isTrainer, Integer userId) {
        SessionGetDto sessionGetDto = sessionToSessionGetDto(session);
        sessionGetDto.setNewComments(false);
        if (isTrainer) {
            sessionGetDto.setNewComments(session.getComments().stream()
                    .anyMatch(comment -> comment.getReadByTrainer() == null ||
                            !comment.getReadByTrainer().getId().equals(userId)));
        } else {
            sessionGetDto.setNewComments(session.getComments().stream()
                    .anyMatch(comment -> comment.getReadByParents().isEmpty() ||
                            comment.getReadByParents().stream().noneMatch(parent -> parent.getId().equals(userId))));
        }
        return sessionGetDto;

    }

    public SessionGetDto sessionToSessionGetDto(Session session) {
        SessionGetDto sessionGetDto = new SessionGetDto();
        sessionGetDto.setId(session.getId());
        sessionGetDto.setStartDateTime(session.getStartDateTime());
        sessionGetDto.setEndDateTime(session.getEndDateTime());
        sessionGetDto.setNote(session.getNote());
        return sessionGetDto;
    }

    public Set<SessionGetDto> sessionListToSessionDtoList(Set<Session> sessionList) {
        return sessionList.stream().map(this::sessionToSessionGetDto).collect(Collectors.toSet());
    }

    public SessionDto sessionToSessionDto(Session session) {
        SessionDto sessionDto = new SessionDto();
        sessionDto.setId(session.getId());
        sessionDto.setStartDateTime(session.getStartDateTime());
        sessionDto.setEndDateTime(session.getEndDateTime());
        sessionDto.setNote(session.getNote());
        sessionDto.setGroup(groupMapper.groupToGroupDto(session.getGroup()));
        return sessionDto;
    }
}
