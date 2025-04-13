package com.app.licenta.repositories;

import com.app.licenta.entities.SessionComment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionCommentRepository extends JpaRepository<SessionComment, Integer> {
    List<SessionComment> findAllBySessionId(Integer sessionId, Pageable pageable);
}
