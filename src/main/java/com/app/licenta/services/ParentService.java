package com.app.licenta.services;

import com.app.licenta.entities.Parent;
import com.app.licenta.repositories.ParentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentService {

    @Autowired
    private ParentRepository parentRepository;

    public Parent createParent(Parent parent) {
        return parentRepository.save(parent);
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
        if (parentRepository.existsById(id)) {
            Parent parentToUpdate = parentRepository.getById(id);
            parentToUpdate.setFirstName(parent.getFirstName());
            parentToUpdate.setLastName(parent.getLastName());
            parentToUpdate.setEmail(parent.getEmail());
            parentToUpdate.setPhoneNumber(parent.getPhoneNumber());

            parentRepository.save(parentToUpdate);
            return parentToUpdate;
        } else {
            throw new EntityNotFoundException("Parent with id " + id + " not found");
        }
    }

    public void deleteById(Integer id) {
        parentRepository.deleteById(id);
    }
}
