package com.app.licenta.services;

import com.app.licenta.entities.*;
import com.app.licenta.repositories.ActivityRepository;
import com.app.licenta.repositories.AdRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AdService {

    @Autowired
    private AdRepository adRepository;

    @Autowired
    private ActivityRepository activityRepository;

    public Ad createAd(Ad ad, Integer activityId, byte[] imageData) {
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new EntityNotFoundException("Activity with id " + activityId + " not found"));

        AdImage adImage = new AdImage();
        adImage.setImageData(imageData);
        ad.addAdImage(adImage);
        ad.setTitle(activity.getTitle());
        ad.setCategory(activity.getCategory());
        ad.setDescription(activity.getDescription());
        ad.setGender(activity.getGender());
        ad.setStatus(AdStatus.ACTIVE);
        activity.addAd(ad);

        return adRepository.save(ad);
    }

    public Ad getById(Integer id) {
        return adRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ad with id " + id + " not found"));
    }

    public List<Ad> searchAds(String title,
                              ActivityCategory category,
                              Integer minAge,
                              Integer maxAge,
                              Gender gender,
                              Double minPrice,
                              Double maxPrice,
                              AdStatus status,
                              int pageNumber,
                              int pageSize,
                              String sortBy,
                              String sortDirection) {
        String lowerCaseTitle = Optional.ofNullable(title)
                .map(t -> "%" + t.toLowerCase() + "%")
                .orElse(null);
        Sort.Direction direction = Optional.ofNullable(sortDirection)
                .map(Sort.Direction::fromString)
                .orElse(Sort.Direction.DESC);
        Sort sort = Optional.ofNullable(sortBy)
                .map(s -> Sort.by(direction, s))
                .orElse(Sort.by(direction, "id"));
        AdStatus effectiveStatus = Optional.ofNullable(status).orElse(AdStatus.ACTIVE);
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return adRepository.searchAds(lowerCaseTitle, category, minAge, maxAge, gender, minPrice, maxPrice, effectiveStatus, pageable).getContent();
    }

    public List<Ad> searchAdsByTrainerId(
            Integer trainerId,
            String title,
            ActivityCategory category,
            Integer minAge,
            Integer maxAge,
            Gender gender,
            Double minPrice,
            Double maxPrice,
            AdStatus status,
            int pageNumber,
            int pageSize,
            String sortBy,
            String sortDirection) {

        String lowerCaseTitle = Optional.ofNullable(title)
                .map(t -> "%" + t.toLowerCase() + "%")
                .orElse(null);
        Sort.Direction direction = Optional.ofNullable(sortDirection)
                .map(Sort.Direction::fromString)
                .orElse(Sort.Direction.DESC);
        Sort sort = Optional.ofNullable(sortBy)
                .map(s -> Sort.by(direction, s))
                .orElse(Sort.by(direction, "id"));
        AdStatus effectiveStatus = Optional.ofNullable(status).orElse(AdStatus.ACTIVE);
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        return adRepository.searchAdsByTrainerId(trainerId, lowerCaseTitle, category, minAge, maxAge, gender, minPrice, maxPrice, effectiveStatus, pageable).getContent();
    }


    public Set<Ad> findAllByActivityId(Integer activityId) {
        return adRepository.findAllByActivityId(activityId);
    }

    public Set<Ad> findAllByTrainerId(Integer trainerId) {
        return adRepository.findAllByTrainerId(trainerId);
    }

    public Ad update(Integer id, Ad ad) {
        Ad adToUpdate = adRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ad with id " + id + " not found"));
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
        adToUpdate.setLocation(ad.getLocation());

        adRepository.save(adToUpdate);
        return adToUpdate;

    }

    public void deleteById(Integer id) {
        adRepository.deleteById(id);
    }
}
