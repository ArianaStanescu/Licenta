package com.app.licenta.controllers;

import com.app.licenta.dtos.SessionDto;
import com.app.licenta.dtos.SessionGetDto;
import com.app.licenta.dtos.SessionUpdateDto;
import com.app.licenta.entities.Session;
import com.app.licenta.mappers.SessionMapper;
import com.app.licenta.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sessions")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @Autowired
    private SessionMapper sessionMapper;

    @PostMapping("/create/{groupId}")
    public List<SessionDto> create(@PathVariable Integer groupId) {

        List<Session> sessions = sessionService.createSessions(groupId);

        return sessions.stream()
                .map(sessionMapper::sessionToSessionDto)
                .toList();
    }

    @GetMapping("/{id}")
    public SessionGetDto get(@PathVariable Integer id) {
        Session session = sessionService.getById(id);
        return sessionMapper.sessionToSessionGetDto(session);
    }

    @GetMapping("/list/{groupId}")
    public List<SessionGetDto> findAllByGroupId(@PathVariable Integer groupId,
                                                @RequestParam Integer pageNumber,
                                                @RequestParam Integer pageSize,
                                                @RequestParam(required = false) String sortBy,
                                                @RequestParam(required = false) String sortDirection) {
        List<Session> sessions = sessionService.findAllByGroupId(groupId, pageNumber, pageSize, sortBy, sortDirection);
        return sessions.stream()
                .map(sessionMapper::sessionToSessionGetDto)
                .toList();
    }

    @PutMapping("/update-note/{id}")
    public SessionGetDto updateNote(@PathVariable Integer id, @RequestBody SessionUpdateDto noteDto) {
        Session updated = sessionService.updateNote(id, noteDto);
        return sessionMapper.sessionToSessionGetDto(updated);
    }

    @PutMapping("/update-date/{id}")
    public SessionGetDto updateDate(@PathVariable Integer id, @RequestBody SessionUpdateDto dateDto) {
        Session updated = sessionService.updateDate(id, dateDto);
        return sessionMapper.sessionToSessionGetDto(updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        sessionService.deleteById(id);
    }
}
