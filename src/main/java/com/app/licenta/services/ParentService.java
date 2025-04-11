package com.app.licenta.services;


import com.app.licenta.entities.Parent;
import com.app.licenta.entities.Trainer;
import com.app.licenta.repositories.ParentRepository;
import com.app.licenta.repositories.TrainerRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentService {

    @Autowired
    private ParentRepository parentRepository;
    @Autowired
    private TrainerRepository trainerRepository;

    public Parent createParent(Parent parent) {
        return parentRepository.save(parent);
    }

    @Transactional
    public void addFavoriteTrainer(Integer parentId, Integer trainerId) {
        Parent parent = parentRepository.findById(parentId)
                .orElseThrow(() -> new EntityNotFoundException("Parent with id " + parentId + " not found"));
        Trainer trainer = trainerRepository.findById(trainerId)
                .orElseThrow(() -> new EntityNotFoundException("Trainer with id " + trainerId + " not found"));
        parent.getFavoriteTrainers().add(trainer);
        trainer.getFollowersParents().add(parent);
        parentRepository.save(parent);
    }

    @Transactional
    public List<Trainer> getFavoriteTrainers(Integer parentId, int pageNumber, int pageSize) {
        parentRepository.findById(parentId)
                .orElseThrow(() -> new EntityNotFoundException("Parent with id " + parentId + " not found"));

        Pageable page = PageRequest.of(pageNumber, pageSize);
        return trainerRepository.findAllByFollowersParentsId(parentId, page);
    }

    public boolean hasFavoriteTrainer(Integer parentId, Integer trainerId) {
        return parentRepository.existsByIdAndFavoriteTrainersId(parentId, trainerId);
    }

    @Transactional
    public void removeFavoriteTrainer(Integer parentId, Integer trainerId) {
        Parent parent = parentRepository.findById(parentId)
                .orElseThrow(() -> new EntityNotFoundException("Parent with id " + parentId + " not found"));
        Trainer trainer = trainerRepository.findById(trainerId)
                .orElseThrow(() -> new EntityNotFoundException("Trainer with id " + trainerId + " not found"));
        parent.getFavoriteTrainers().remove(trainer);
        trainer.getFollowersParents().remove(parent);
        parentRepository.save(parent);
    }

    public Parent getById(Integer id) {
        return parentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Parent with id " + id + " not found"));
    }

    public Parent getByEmail(String email) {
        return parentRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Psrent with email " + email + " not found"));
    }

    public List<Parent> findAll() {
        return parentRepository.findAll();
    }

    public Parent update(Integer id, Parent parent) {
        Parent parentToUpdate = parentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Parent with id " + id + " not found"));
        parentToUpdate.setFirstName(parent.getFirstName());
        parentToUpdate.setLastName(parent.getLastName());
        parentToUpdate.setEmail(parent.getEmail());
        parentToUpdate.setPhoneNumber(parent.getPhoneNumber());

        parentRepository.save(parentToUpdate);
        return parentToUpdate;
    }

    public void updateFcmToken(Integer parentId, String fcmToken) {
        Parent parent = parentRepository.findById(parentId)
                .orElseThrow(() -> new EntityNotFoundException("Parent with id " + parentId + " not found"));
        parent.setFcmToken(fcmToken);
        parentRepository.save(parent);
    }

    public void deleteById(Integer id) {
        parentRepository.deleteById(id);
    }
}
