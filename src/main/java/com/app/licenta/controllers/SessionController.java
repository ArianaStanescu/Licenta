package com.app.licenta.controllers;

import com.app.licenta.dtos.SessionDto;
import com.app.licenta.dtos.SessionGetDto;
import com.app.licenta.entities.Group;
import com.app.licenta.entities.Session;
import com.app.licenta.mappers.GroupMapper;
import com.app.licenta.mappers.SessionMapper;
import com.app.licenta.services.GroupService;
import com.app.licenta.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/sessions")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @Autowired
    private SessionMapper sessionMapper;

    @Autowired
    private GroupService groupService;

    @Autowired
    private GroupMapper groupMapper;

    @GetMapping("/{id}")
    public SessionGetDto get(@PathVariable Integer id) {
        Session session = sessionService.getById(id);
        return sessionMapper.sessionToSessionGetDto(session);
    }

    @GetMapping("/list/{groupId}")
    public Set<SessionGetDto> findAllByGroupId(@PathVariable Integer groupId) {
        return sessionMapper.sessionListToSessionDtoList(sessionService.findAllByGroupId(groupId));
    }

    @PostMapping("/create/{groupId}")
    public SessionDto create(@PathVariable Integer groupId, @RequestBody SessionDto sessionDto) {
        Group group = groupService.getById(groupId);
        sessionDto.setGroup(groupMapper.groupToGroupDto(group));
        Session sessionToCreate = sessionMapper.sessionDtoToSession(sessionDto);
        sessionToCreate.setGroup(group);
        group.getSessions().add(sessionToCreate);
        Session createdSession = sessionService.createSession(sessionToCreate);

        return sessionMapper.sessionToSessionDto(createdSession);
    }
}
