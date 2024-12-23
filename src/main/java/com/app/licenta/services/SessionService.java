package com.app.licenta.services;

import com.app.licenta.entities.Session;
import com.app.licenta.repositories.SessionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    public Session createSession(Session session) {
        return sessionRepository.save(session);
    }

    public Session getById(Integer id) {
        return sessionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Session with id " + id + " not found"));
    }


    public Set<Session> findAllByGroupId(Integer groupId) {
        return sessionRepository.findAllByGroupId(groupId);
    }

    // update
}
