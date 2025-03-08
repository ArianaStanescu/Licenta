package com.app.licenta.repositories;

import com.app.licenta.entities.AdImage;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdImageRepository extends JpaRepository<AdImage, Integer> {
    Optional<AdImage> findByAdId(Integer adId);

    @Modifying
    @Transactional
    @Query("DELETE FROM ad_image  ai WHERE ai.ad.id = :adId")
    void deleteByAdId(@Param("adId") Integer adId);
}
