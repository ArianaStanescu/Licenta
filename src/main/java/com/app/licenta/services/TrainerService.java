package com.app.licenta.services;

import com.app.licenta.entities.*;
import com.app.licenta.repositories.TrainerRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

    public Trainer createTrainer(Trainer trainer, byte[] imageData) {
        TrainerImage trainerImage = new TrainerImage();
        trainerImage.setImageData(imageData);
        trainer.setImage(trainerImage);
        trainerImage.setTrainer(trainer);
        return trainerRepository.save(trainer);
    }

    public Trainer getById(Integer id) {
        return trainerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Trainer with id " + id + " not found"));
    }

    public Trainer getByEmail(String email) {
        return trainerRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Trainer with email " + email + " not found"));
    }

    public List<Trainer> findAll() {
        return trainerRepository.findAll();
    }

    @Transactional
    public Trainer editTrainer(Integer trainerId, Trainer trainer, byte[] imageData) {
        Trainer trainerToUpdate = trainerRepository.findById(trainerId)
                .orElseThrow(() -> new EntityNotFoundException("Trainer with id " + trainerId + " not found"));
        trainerToUpdate.setFirstName(trainer.getFirstName());
        trainerToUpdate.setLastName(trainer.getLastName());
        trainerToUpdate.setGender(trainer.getGender());
        trainerToUpdate.setBirthDate(trainer.getBirthDate());
        trainerToUpdate.setPhoneNumber(trainer.getPhoneNumber());
        trainerToUpdate.setEmail(trainer.getEmail());
        trainerToUpdate.setActivities(trainer.getActivities());
        trainerToUpdate.setDescription(trainer.getDescription());

        if(imageData != null) {
            TrainerImage trainerImage = Optional.ofNullable(trainerToUpdate.getImage())
                    .orElseGet(TrainerImage::new);

            trainerImage.setImageData(imageData);
            trainerToUpdate.setImage(trainerImage);
            trainerImage.setTrainer(trainerToUpdate);
        }

        return trainerRepository.save(trainerToUpdate);
    }

    public void updateFcmToken(Integer trainerId, String fcmToken) {
        Trainer trainer = trainerRepository.findById(trainerId)
                .orElseThrow(() -> new EntityNotFoundException("Trainer with id " + trainerId + " not found"));
        trainer.setFcmToken(fcmToken);
        trainerRepository.save(trainer);
    }

    public void deleteById(Integer id) {
        if (trainerRepository.existsById(id)) {
            trainerRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Trainer with id " + id + " not found");
        }
    }

    @Async
    @Transactional
    public void updateTrainerReviews(Integer trainerId) {
        Trainer trainer = trainerRepository.findById(trainerId)
                .orElseThrow(() -> new EntityNotFoundException("Trainer with id " + trainerId + " not found"));

        double sum = trainer.getTrainerReviews().stream().map(TrainerReview::getTrainerReviewGrade)
                .mapToInt(TrainerReviewGrade::getGrade)
                .sum();
        trainer.setReviewsGrade(sum / trainer.getTrainerReviews().size());
        trainerRepository.save(trainer);
    }
}
