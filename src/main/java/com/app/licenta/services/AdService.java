package com.app.licenta.services;

import com.app.licenta.entities.ActivityCategory;
import com.app.licenta.entities.Ad;
import com.app.licenta.entities.Gender;
import com.app.licenta.repositories.AdRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    public List<Ad> searchAds(String title,
                              ActivityCategory category,
                              Integer minAge,
                              Integer maxAge,
                              Gender gender,
                              Double minPrice,
                              Double maxPrice,
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
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return adRepository.searchAds(lowerCaseTitle, category, minAge, maxAge, gender, minPrice, maxPrice, pageable).getContent();
    }

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

    public void deleteById(Integer id) {
        adRepository.deleteById(id);
    }
}
