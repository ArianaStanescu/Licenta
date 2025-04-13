package com.app.licenta.repositories;

import com.app.licenta.entities.SessionDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessionDocumentRepository extends JpaRepository<SessionDocument, Integer> {
    Optional<SessionDocument> findBySessionId(Integer sessionId);
    void deleteBySessionId(Integer sessionId);
}
