package com.app.licenta.services;

import com.app.licenta.entities.Ad;
import com.app.licenta.repositories.AdRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AdService {

    @Autowired
    private AdRepository adRepository;

    public Ad createAd(Ad ad) {
        return adRepository.save(ad);
    }

    public Ad getById(Integer id) {
        return adRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ad with id " + id + " not found"));
    }

//    public List<Activity> findAll() {
//        return activityRepository.findAll();
//    }

    public Set<Ad> findAllByActivityId(Integer activityId) {
        return adRepository.findAllByActivityId(activityId);
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
