package com.app.licenta.repositories;

import com.app.licenta.entities.Session;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {
    List<Session> findAllByGroupId(Integer sessionId, Pageable pageable);
}
