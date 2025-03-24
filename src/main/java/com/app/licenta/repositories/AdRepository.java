package com.app.licenta.repositories;

import com.app.licenta.entities.ActivityCategory;
import com.app.licenta.entities.Ad;
import com.app.licenta.entities.AdStatus;
import com.app.licenta.entities.Gender;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AdRepository extends JpaRepository<Ad, Integer> {
    Set<Ad> findAllByActivityId(Integer activityId);

    @Query("SELECT a FROM ad a WHERE " +
            "(:title IS NULL OR LOWER(a.title) LIKE :title) AND " +
            "(:category IS NULL OR a.category = :category) AND " +
            "(:minAge IS NULL OR a.minAge >= :minAge) AND " +
            "(:maxAge IS NULL OR a.maxAge <= :maxAge) AND " +
            "(:gender IS NULL OR a.gender = :gender) AND " +
            "(:minPrice IS NULL OR a.price >= :minPrice) AND " +
            "(:status IS NULL OR a.status = :status) AND " +
            "(:maxPrice IS NULL OR a.price <= :maxPrice)")
    Page<Ad> searchAds(
            String title,
            ActivityCategory category,
            Integer minAge,
            Integer maxAge,
            Gender gender,
            Double minPrice,
            Double maxPrice,
            AdStatus status,
            Pageable pageable);

    @Query("SELECT a FROM ad a JOIN a.activity act JOIN act.trainer t WHERE t.id = :trainerId " +
            "AND (:title IS NULL OR LOWER(a.title) LIKE :title) " +
            "AND (:category IS NULL OR a.category = :category) " +
            "AND (:minAge IS NULL OR a.minAge >= :minAge) " +
            "AND (:maxAge IS NULL OR a.maxAge <= :maxAge) " +
            "AND (:gender IS NULL OR a.gender = :gender) " +
            "AND (:minPrice IS NULL OR a.price >= :minPrice) " +
            "AND (:status IS NULL OR a.status = :status) " +
            "AND (:maxPrice IS NULL OR a.price <= :maxPrice)")
    Page<Ad> searchAdsByTrainerId(
            Integer trainerId,
            String title,
            ActivityCategory category,
            Integer minAge,
            Integer maxAge,
            Gender gender,
            Double minPrice,
            Double maxPrice,
            AdStatus status,
            Pageable pageable);

    @Query("SELECT a FROM ad a JOIN a.activity act JOIN act.trainer t WHERE t.id = :trainerId")
    Set<Ad> findAllByTrainerId(@Param("trainerId") Integer trainerId);
}
