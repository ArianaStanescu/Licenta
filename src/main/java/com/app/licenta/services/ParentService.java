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

    // update

    public void deleteById(Integer id) {
        if (parentRepository.existsById(id)) {
            parentRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Parent with id " + id + " not found");
        }

    }
}
