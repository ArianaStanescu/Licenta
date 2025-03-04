package com.app.licenta.repositories;

import com.app.licenta.entities.AdImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdImageRepository extends JpaRepository<AdImage, Integer> {
    Optional<AdImage> findByAdId(Integer adId);
}
