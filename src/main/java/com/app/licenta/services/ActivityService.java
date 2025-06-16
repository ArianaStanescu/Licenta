package com.app.licenta.services;

import com.app.licenta.entities.Activity;
import com.app.licenta.repositories.ActivityRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public Activity createActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    public Activity getById(Integer id) {
        return activityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Activity with id " + id + " not found"));
    }

    public List<Activity> findAll() {
        return activityRepository.findAll();
    }

    public Set<Activity> findAllByTrainerId(Integer trainerId) {
        return activityRepository.findAllByTrainerId(trainerId);
    }

    public Set<String> findActiveActivitiesNames() {
        return activityRepository.findActiveActivityNames();
    }

    public Activity update(Integer id, Activity activity) {
        Activity activityToUpdate = activityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Activity with id " + id + " not found"));
        activityToUpdate.setTitle(activity.getTitle());
        activityToUpdate.setDescription(activity.getDescription());
        activityToUpdate.setCategory(activity.getCategory());
        activityToUpdate.setGender(activity.getGender());

        activityRepository.save(activityToUpdate);
        return activityToUpdate;
    }

    public void deleteById(Integer id) {
        activityRepository.deleteById(id);
    }
}
