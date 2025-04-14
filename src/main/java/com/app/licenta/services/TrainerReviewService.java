package com.app.licenta.services;

import com.app.licenta.entities.Parent;
import com.app.licenta.entities.Trainer;
import com.app.licenta.entities.TrainerReview;
import com.app.licenta.repositories.ParentRepository;
import com.app.licenta.repositories.TrainerRepository;
import com.app.licenta.repositories.TrainerReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TrainerReviewService {

    private final TrainerReviewRepository trainerReviewRepository;
    private final TrainerRepository trainerRepository;
    private final ParentRepository parentRepository;

    public TrainerReviewService(TrainerReviewRepository trainerReviewRepository,
                                TrainerRepository trainerRepository,
                                ParentRepository parentRepository) {
        this.trainerReviewRepository = trainerReviewRepository;
        this.trainerRepository = trainerRepository;
        this.parentRepository = parentRepository;
    }

    @Transactional
    public TrainerReview create(Integer trainerId, Integer parentId, TrainerReview trainerReviewToCreate) {
        Trainer trainer = trainerRepository.findById(trainerId)
                .orElseThrow(() -> new EntityNotFoundException("Trainer with id %s not found".formatted(trainerId)));

        Parent parent = parentRepository.findById(parentId)
                .orElseThrow(() -> new EntityNotFoundException("Parent with id %s not found".formatted(parentId)));

        TrainerReview trainerReview = new TrainerReview();
        trainerReview.setTrainerReviewGrade(trainerReviewToCreate.getTrainerReviewGrade());
        trainerReview.setComment(trainerReviewToCreate.getComment());
        trainerReview.setTrainer(trainer);
        trainerReview.setParent(parent);
        trainerReview.setCreatedAt(LocalDateTime.now());

        return trainerReviewRepository.save(trainerReview);
    }

    public TrainerReview update(Integer trainerReviewId, Integer parentId, TrainerReview trainerReviewToUpdate) {
        Parent parent = parentRepository.findById(parentId)
                .orElseThrow(() -> new EntityNotFoundException("Parent with id %s not found".formatted(parentId)));
        TrainerReview trainerReview = trainerReviewRepository.findById(trainerReviewId)
                .orElseThrow(() -> new EntityNotFoundException("Trainer review with id %s not found".formatted(trainerReviewId)));

        if (!trainerReview.getParent().getId().equals(parent.getId())) {
            throw new IllegalStateException("Parent with id %s is not the owner of the trainer review with id %s".formatted(parentId, trainerReviewId));
        }

        trainerReview.setComment(trainerReviewToUpdate.getComment());
        trainerReview.setTrainerReviewGrade(trainerReviewToUpdate.getTrainerReviewGrade());

        return trainerReviewRepository.save(trainerReview);
    }

    public List<TrainerReview> findForTrainer(Integer trainerId,
                                              Integer pageNumber,
                                              Integer pageSize,
                                              String sortBy,
                                              String sortDirection) {
        Sort.Direction direction = Optional.ofNullable(sortDirection)
                .map(Sort.Direction::fromString)
                .orElse(Sort.Direction.DESC);
        Sort sort = Optional.ofNullable(sortBy)
                .map(s -> Sort.by(direction, s))
                .orElse(Sort.by(direction, "id"));

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return trainerReviewRepository.findAllByTrainerId(trainerId, pageable);
    }

    public Integer delete(Integer trainerReviewId, Integer parentId) {
        Parent parent = parentRepository.findById(parentId)
                .orElseThrow(() -> new EntityNotFoundException("Parent with id %s not found".formatted(parentId)));
        TrainerReview trainerReview = trainerReviewRepository.findById(trainerReviewId)
                .orElseThrow(() -> new EntityNotFoundException("Trainer review with id %s not found".formatted(trainerReviewId)));
        Integer trainerId = trainerReview.getTrainer().getId();
        if (!trainerReview.getParent().getId().equals(parent.getId())) {
            throw new IllegalStateException("Parent with id %s is not the owner of the trainer review with id %s".formatted(parentId, trainerReviewId));
        }

        trainerReviewRepository.delete(trainerReview);
        return trainerId;
    }
}
