package com.app.licenta.controllers;

import com.app.licenta.dtos.SessionCommentDto;
import com.app.licenta.entities.*;
import com.app.licenta.mappers.ParentMapper;
import com.app.licenta.mappers.SessionCommentMapper;
import com.app.licenta.mappers.SessionMapper;
import com.app.licenta.mappers.TrainerMapper;
import com.app.licenta.services.ParentService;
import com.app.licenta.services.SessionCommentService;
import com.app.licenta.services.SessionService;
import com.app.licenta.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Set;

@RestController
@RequestMapping("/session-comments")
public class SessionCommentController {

    @Autowired
    private SessionCommentService sessionCommentService;
    @Autowired
    private SessionCommentMapper sessionCommentMapper;
    @Autowired
    private SessionService sessionService;
    @Autowired
    private SessionMapper sessionMapper;
    @Autowired
    private TrainerService trainerService;
    @Autowired
    private TrainerMapper trainerMapper;
    @Autowired
    private ParentService parentService;
    @Autowired
    private ParentMapper parentMapper;

    @GetMapping("/{id}")
    public SessionCommentDto get(@PathVariable Integer id) {
        SessionComment sessionComment = sessionCommentService.getById(id);
        return sessionCommentMapper.sessionCommentToSessionCommentDto(sessionComment);
    }

    @GetMapping("/list-by-trainer/{sessionId}/{trainerId}")
    public Set<SessionCommentDto> findAllBySessionIdForTrainer (@PathVariable Integer sessionId, @PathVariable Integer trainerId) {
        Trainer trainer = trainerService.getById(trainerId);
        Set<SessionComment> sessionComments = sessionCommentService.findAllBySessionId(sessionId);
        sessionComments.forEach(comment -> {
            comment.setReadByTrainer(trainer);
            sessionCommentService.save(comment);
        });
        return sessionCommentMapper.sessionCommentListToSessionCommentDtoList(sessionComments);
    }

    @PostMapping("/create-by-trainer/{sessionId}/{trainerId}")
    public SessionCommentDto createByTrainer(@PathVariable Integer sessionId, @PathVariable Integer trainerId, @RequestBody SessionCommentDto sessionCommentDto) {
        Session session = sessionService.getById(sessionId);
        Trainer trainer = trainerService.getById(trainerId);
        sessionCommentDto.setSession(sessionMapper.sessionToSessionDto(session));
        sessionCommentDto.setAuthorTrainer(trainerMapper.trainerToTrainerDto(trainer));
        sessionCommentDto.setCreatedAt(LocalDateTime.now());
        SessionComment sessionCommentToCreate = sessionCommentMapper.sessionCommentDtoToSessionComment(sessionCommentDto);
        sessionCommentToCreate.setSession(session);
        sessionCommentToCreate.setAuthorTrainer(trainer);
        session.getComments().add(sessionCommentToCreate);
        SessionComment createdSessionComment = sessionCommentService.createSessionComment(sessionCommentToCreate);

        return sessionCommentMapper.sessionCommentToSessionCommentDto(createdSessionComment);
    }

    @GetMapping("/list-by-parent/{sessionId}/{parentId}")
    public Set<SessionCommentDto> findAllBySessionIdForParent (@PathVariable Integer sessionId, @PathVariable Integer parentId) {
        Parent parent = parentService.getById(parentId);
        Set<SessionComment> sessionComments = sessionCommentService.findAllBySessionId(sessionId);
        sessionComments.forEach(comment -> {
            comment.getReadByParents().add(parent);
            sessionCommentService.save(comment);
        });
        return sessionCommentMapper.sessionCommentListToSessionCommentDtoList(sessionComments);
    }

    @PostMapping("/create-by-parent/{sessionId}/{parentId}")
    public SessionCommentDto createByParent(@PathVariable Integer sessionId, @PathVariable Integer parentId, @RequestBody SessionCommentDto sessionCommentDto) {
        Session session = sessionService.getById(sessionId);
        Parent parent = parentService.getById(parentId);
        sessionCommentDto.setSession(sessionMapper.sessionToSessionDto(session));
        sessionCommentDto.setAuthorParent(parentMapper.parentToParentDto(parent));
        sessionCommentDto.setCreatedAt(LocalDateTime.now());
        SessionComment sessionCommentToCreate = sessionCommentMapper.sessionCommentDtoToSessionComment(sessionCommentDto);
        sessionCommentToCreate.setSession(session);
        sessionCommentToCreate.setAuthorParent(parent);
        session.getComments().add(sessionCommentToCreate);
        SessionComment createdSessionComment = sessionCommentService.createSessionComment(sessionCommentToCreate);

        return sessionCommentMapper.sessionCommentToSessionCommentDto(createdSessionComment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        sessionCommentService.deleteById(id);
    }

}
