package com.app.licenta.repositories;

import com.app.licenta.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {
    Set<Session> findAllByGroupId(Integer sessionId);
}
