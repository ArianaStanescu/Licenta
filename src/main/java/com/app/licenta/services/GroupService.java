package com.app.licenta.services;

import com.app.licenta.entities.Group;
import com.app.licenta.repositories.GroupRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }

    public Group getById(Integer id) {
        return groupRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Group with id " + id + " not found"));
    }

//    public List<Activity> findAll() {
//        return activityRepository.findAll();
//    }

    public Set<Group> findAllByActivityId(Integer activityId) {
        return groupRepository.findAllByActivityId(activityId);
    }

    public Set<Group> findAllByChildId(Integer childId) {
        return groupRepository.findAllByChildId(childId);
    }

    // update

//    public void deleteById(Integer id) {
//        if (activityRepository.existsById(id)) {
//            activityRepository.deleteById(id);
//        } else {
//            throw new EntityNotFoundException("Activity with id " + id + " not found");
//        }
//
//    }
}
