package com.app.licenta.services;

import com.app.licenta.entities.Parent;
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

    public Trainer getByEmail(String email) {
        return trainerRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Trainer with email " + email + " not found"));
    }

    public List<Trainer> findAll() {
        return trainerRepository.findAll();
    }

    public Trainer update(Integer id, Trainer trainer) {
        Trainer trainerToUpdate = trainerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Trainer with id " + id + " not found"));
        trainerToUpdate.setFirstName(trainer.getFirstName());
        trainerToUpdate.setLastName(trainer.getLastName());
        trainerToUpdate.setGender(trainer.getGender());
        trainerToUpdate.setBirthDate(trainer.getBirthDate());
        trainerToUpdate.setPhoneNumber(trainer.getPhoneNumber());
        trainerToUpdate.setEmail(trainer.getEmail());
        trainerToUpdate.setActivities(trainer.getActivities());

        trainerRepository.save(trainerToUpdate);
        return trainerToUpdate;
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
}
