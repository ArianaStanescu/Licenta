package com.app.licenta.repositories;

import com.app.licenta.entities.EnrollmentRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface EnrollmentRequestRepository extends JpaRepository<EnrollmentRequest, Integer> {
    Set<EnrollmentRequest> findAllByAdId(Integer adId);

    Set<EnrollmentRequest> findAllByChildId(Integer childId);
}