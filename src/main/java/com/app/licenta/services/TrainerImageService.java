package com.app.licenta.services;

import com.app.licenta.entities.TrainerImage;
import com.app.licenta.repositories.TrainerImageRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainerImageService {

    @Autowired
    private TrainerImageRepository trainerImageRepository;

    public TrainerImage getByTrainerId(Integer trainerImageId) {
        return trainerImageRepository.findByTrainerId(trainerImageId)
                .orElseThrow(() -> new EntityNotFoundException("Image not found"));
    }

    public void deleteByTrainerId(Integer trainerId) {
        trainerImageRepository.deleteByTrainerId(trainerId);
    }
}