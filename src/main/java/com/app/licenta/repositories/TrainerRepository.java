package com.app.licenta.repositories;

import com.app.licenta.entities.Parent;
import com.app.licenta.entities.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Integer> {
    Optional<Trainer> findByEmail(String email);
}