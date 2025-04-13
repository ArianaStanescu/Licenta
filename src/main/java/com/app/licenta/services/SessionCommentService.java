package com.app.licenta.services;

import com.app.licenta.entities.SessionComment;
import com.app.licenta.repositories.SessionCommentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SessionCommentService {

    @Autowired
    private SessionCommentRepository sessionCommentRepository;

    public SessionComment save(SessionComment sessionComment) {
        return sessionCommentRepository.save(sessionComment);
    }

    public SessionComment createSessionComment(SessionComment sessionComment) {
        return sessionCommentRepository.save(sessionComment);
    }

    public SessionComment update(Integer sessionCommentId, SessionComment sessionComment) {
        SessionComment sessionCommentToUpdate = sessionCommentRepository.findById(sessionCommentId)
                .orElseThrow(() -> new EntityNotFoundException("Session comment with id %s not found".formatted(sessionCommentId)));
        sessionCommentToUpdate.setContent(sessionComment.getContent());
        return sessionCommentRepository.save(sessionCommentToUpdate);
    }


    public SessionComment getById(Integer id) {
        return sessionCommentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Session comment with id " + id + " not found"));
    }

    public List<SessionComment> findBySessionId(Integer sessionId, Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, "createdAt"));
        return sessionCommentRepository.findAllBySessionId(sessionId, pageable);
    }

    public void deleteById(Integer id) {
        sessionCommentRepository.deleteById(id);
    }
}
