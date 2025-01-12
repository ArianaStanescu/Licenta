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

    public Ad update(Integer id, Ad ad) {
        if (adRepository.existsById(id)) {
            Ad adToUpdate = adRepository.getById(id);
            adToUpdate.setTitle(ad.getTitle());
            adToUpdate.setDescription(ad.getDescription());
            adToUpdate.setPrice(ad.getPrice());
            adToUpdate.setCategory(ad.getCategory());
            adToUpdate.setMinAge(ad.getMinAge());
            adToUpdate.setMaxAge(ad.getMaxAge());
            adToUpdate.setGender(ad.getGender());
            adToUpdate.setStartDate(ad.getStartDate());
            adToUpdate.setEndDate(ad.getEndDate());
            adToUpdate.setStatus(ad.getStatus());
            adToUpdate.setTotalSpots(ad.getTotalSpots());

            adRepository.save(adToUpdate);
            return adToUpdate;
        } else {
            throw new EntityNotFoundException("Ad with id " + id + " not found");
        }
    }

//    public void deleteById(Integer id) {
//        if (activityRepository.existsById(id)) {
//            activityRepository.deleteById(id);
//        } else {
//            throw new EntityNotFoundException("Activity with id " + id + " not found");
//        }
//
//    }
}
