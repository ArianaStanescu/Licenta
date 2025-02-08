package com.app.licenta.repositories;

import com.app.licenta.entities.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AdRepository extends JpaRepository<Ad, Integer> {
    Set<Ad> findAllByActivityId(Integer activityId);
}
