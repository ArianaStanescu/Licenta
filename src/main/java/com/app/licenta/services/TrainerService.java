package com.app.licenta.services;

import com.app.licenta.entities.Trainer;
import com.app.licenta.repositories.TrainerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

    public Trainer createTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    public Trainer getById(Integer id) {
        return trainerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Trainer with id " + id + " not found"));
    }

    public List<Trainer> findAll() {
        return trainerRepository.findAll();
    }

    // update

    public void deleteById(Integer id) {
        if (trainerRepository.existsById(id)) {
            trainerRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Trainer with id " + id + " not found");
        }

    }
}
