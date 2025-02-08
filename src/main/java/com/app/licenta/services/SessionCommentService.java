package com.app.licenta.services;

import com.app.licenta.entities.SessionComment;
import com.app.licenta.repositories.SessionCommentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

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

    public SessionComment getById(Integer id) {
        return sessionCommentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Session comment with id " + id + " not found"));
    }


    public Set<SessionComment> findAllBySessionId(Integer sessionId) {
        return sessionCommentRepository.findAllBySessionId(sessionId);
    }

    public void deleteById(Integer id) {
        sessionCommentRepository.deleteById(id);
    }
}
