package com.app.licenta.repositories;

import com.app.licenta.entities.EnrollmentRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface EnrollmentRequestRepository extends JpaRepository<EnrollmentRequest, Integer> {
    Set<EnrollmentRequest> findAllByAdId(Integer adId);

    Set<EnrollmentRequest> findAllByChildId(Integer childId);

    @Query("SELECT er FROM enrollment_request er WHERE er.child.parent.id = :parentId AND er.ad.status = 'ACTIVE'")
    Page<EnrollmentRequest> findAllByParentId(@Param("parentId") Integer parentId, Pageable pageable);
}