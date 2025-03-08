package com.app.licenta.services;

import com.app.licenta.entities.Child;
import com.app.licenta.entities.Group;
import com.app.licenta.repositories.ChildRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ChildService {

    @Autowired
    private ChildRepository childRepository;

    public Child createChild(Child child) {
        return childRepository.save(child);
    }

    public Child getById(Integer id) {
        return childRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Child with id " + id + " not found"));
    }

    public Set<Child> findAllByParentId(Integer parentId) {
        return childRepository.findAllByParentId(parentId);
    }

    public Child update(Integer id, Child child) {
        Child childToUpdate = childRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Child with id " + id + " not found"));
        childToUpdate.setFirstName(child.getFirstName());
        childToUpdate.setLastName(child.getLastName());
        childToUpdate.setGender(child.getGender());
        childToUpdate.setBirthDate(child.getBirthDate());

        childRepository.save(childToUpdate);
        return childToUpdate;

    }

    public void deleteById(Integer id) {
        Child childToDelete = childRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Child with id " + id + " not found"));
        for (Group group : childToDelete.getGroups()) {
            group.getChildren().remove(childToDelete);
        }
        childRepository.deleteById(id);
    }
}
