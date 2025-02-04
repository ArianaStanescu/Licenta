package com.app.licenta.repositories;

import com.app.licenta.entities.SessionComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface SessionCommentRepository extends JpaRepository<SessionComment, Integer> {
    Set<SessionComment> findAllBySessionId(Integer sessionId);
}
