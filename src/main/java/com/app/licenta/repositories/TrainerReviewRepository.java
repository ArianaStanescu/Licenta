package com.app.licenta.repositories;

import com.app.licenta.entities.TrainerReview;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainerReviewRepository extends JpaRepository<TrainerReview, Integer> {
    List<TrainerReview> findAllByTrainerId(Integer trainerId, Pageable pageable);
}
