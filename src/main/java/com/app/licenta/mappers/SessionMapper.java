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

    public Session sessionDtoToSession(SessionDto sessionDto){
        Session session = new Session();
        //session.setId(sessionDto.getId());
        session.setDateTime(sessionDto.getDateTime());
        return session;
    }

    public SessionGetDto sessionToSessionGetDto(Session session){
        SessionGetDto sessionGetDto = new SessionGetDto();
        sessionGetDto.setId(session.getId());
        sessionGetDto.setDateTime(session.getDateTime());
        return sessionGetDto;
    }

    public Set<SessionGetDto> sessionListToSessionDtoList(Set<Session> sessionList){
        return sessionList.stream().map(this::sessionToSessionGetDto).collect(Collectors.toSet());
    }

    public SessionDto sessionToSessionDto(Session session){
        SessionDto sessionDto = new SessionDto();
        sessionDto.setId(session.getId());
        sessionDto.setDateTime(session.getDateTime());
        sessionDto.setGroup(groupMapper.groupToGroupDto(session.getGroup()));
        return sessionDto;
    }
}
