package com.app.licenta.repositories;

import com.app.licenta.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {
    Set<Activity> findAllByTrainerId(Integer trainerId);

    @Query("SELECT DISTINCT a.title FROM activity a JOIN a.ads ad WHERE ad.status = 'ACTIVE'")
    Set<String> findActiveActivityNames();
}