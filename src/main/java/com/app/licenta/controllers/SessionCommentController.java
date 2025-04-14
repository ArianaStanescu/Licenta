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
import java.util.List;
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

    @GetMapping("/list-by-trainer/{sessionId}/{trainerId}")
    public List<SessionCommentDto> findAllBySessionIdForTrainer(@PathVariable Integer sessionId,
                                                                @PathVariable Integer trainerId,
                                                                @RequestParam Integer pageNumber,
                                                                @RequestParam Integer pageSize) {
        List<SessionComment> sessionComments = sessionCommentService.findBySessionId(sessionId, pageNumber, pageSize);
        List<SessionCommentDto> sessionCommentDtos = sessionCommentMapper.sessionCommentListToSessionCommentDtoList(sessionComments, true, trainerId);

        Trainer trainer = trainerService.getById(trainerId);
        sessionComments.forEach(comment -> {
            comment.setReadByTrainer(trainer);
            sessionCommentService.save(comment);
        });
        return sessionCommentDtos;
    }

    @PostMapping("/create-by-trainer/{sessionId}/{trainerId}")
    public SessionCommentDto createByTrainer(@PathVariable Integer sessionId, @PathVariable Integer trainerId, @RequestBody SessionCommentDto sessionCommentDto) {
        Session session = sessionService.getById(sessionId);
        Trainer trainer = trainerService.getById(trainerId);
        sessionCommentDto.setAuthorTrainer(trainerMapper.trainerToTrainerDto(trainer));
        sessionCommentDto.setCreatedAt(LocalDateTime.now());
        SessionComment sessionCommentToCreate = sessionCommentMapper.sessionCommentDtoToSessionComment(sessionCommentDto);
        sessionCommentToCreate.setSession(session);
        sessionCommentToCreate.setAuthorTrainer(trainer);
        session.getComments().add(sessionCommentToCreate);
        sessionCommentToCreate.setReadByTrainer(trainer);
        SessionComment createdSessionComment = sessionCommentService.createSessionComment(sessionCommentToCreate);

        return sessionCommentMapper.sessionCommentToSessionCommentDto(createdSessionComment, true, trainerId);
    }

    @GetMapping("/list-by-parent/{sessionId}/{parentId}")
    public List<SessionCommentDto> findAllBySessionIdForParent(@PathVariable Integer sessionId,
                                                               @PathVariable Integer parentId,
                                                               @RequestParam Integer pageNumber,
                                                               @RequestParam Integer pageSize) {
        List<SessionComment> sessionComments = sessionCommentService.findBySessionId(sessionId, pageNumber, pageSize);
        List<SessionCommentDto> sessionCommentDtos = sessionCommentMapper.sessionCommentListToSessionCommentDtoList(sessionComments, false, parentId);

        Parent parent = parentService.getById(parentId);
        sessionComments.forEach(comment -> {
            comment.getReadByParents().add(parent);
            sessionCommentService.save(comment);
        });
        return sessionCommentDtos;
    }

    @PostMapping("/create-by-parent/{sessionId}/{parentId}")
    public SessionCommentDto createByParent(@PathVariable Integer sessionId, @PathVariable Integer parentId, @RequestBody SessionCommentDto sessionCommentDto) {
        Session session = sessionService.getById(sessionId);
        Parent parent = parentService.getById(parentId);
        sessionCommentDto.setAuthorParent(parentMapper.parentToParentWithChildrenDto(parent, session.getGroup().getChildren().stream().toList()));
        sessionCommentDto.setCreatedAt(LocalDateTime.now());
        SessionComment sessionCommentToCreate = sessionCommentMapper.sessionCommentDtoToSessionComment(sessionCommentDto);
        sessionCommentToCreate.setSession(session);
        sessionCommentToCreate.setAuthorParent(parent);
        session.getComments().add(sessionCommentToCreate);
        sessionCommentToCreate.setReadByParents(Set.of(parent));
        SessionComment createdSessionComment = sessionCommentService.createSessionComment(sessionCommentToCreate);

        return sessionCommentMapper.sessionCommentToSessionCommentDto(createdSessionComment, false, parentId);
    }

    @PutMapping("/trainer/{sessionCommentId}/{trainerId}")
    public SessionCommentDto editAsTrainer(@PathVariable Integer sessionCommentId,
                                           @PathVariable Integer trainerId,
                                           @RequestBody SessionCommentDto sessionCommentDto) {
        SessionComment updatedComment = sessionCommentService.update(sessionCommentId, sessionCommentMapper.sessionCommentDtoToSessionComment(sessionCommentDto));
        return sessionCommentMapper.sessionCommentToSessionCommentDto(updatedComment, true, trainerId);
    }

    @PutMapping("/parent/{sessionCommentId}/{parentId}")
    public SessionCommentDto editAsParent(@PathVariable Integer sessionCommentId,
                                          @PathVariable Integer parentId,
                                          @RequestBody SessionCommentDto sessionCommentDto) {
        SessionComment updatedComment = sessionCommentService.update(sessionCommentId, sessionCommentMapper.sessionCommentDtoToSessionComment(sessionCommentDto));
        return sessionCommentMapper.sessionCommentToSessionCommentDto(updatedComment, false, parentId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        sessionCommentService.deleteById(id);
    }

}
