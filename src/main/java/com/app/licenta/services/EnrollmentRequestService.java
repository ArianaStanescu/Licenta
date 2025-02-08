package com.app.licenta.services;


import com.app.licenta.entities.EnrollmentRequest;
import com.app.licenta.repositories.EnrollmentRequestRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class EnrollmentRequestService {

    @Autowired
    private EnrollmentRequestRepository enrollmentRequestRepository;

    public EnrollmentRequest createEnrollmentRequest(EnrollmentRequest enrollmentRequest) {
        return enrollmentRequestRepository.save(enrollmentRequest);
    }

    public EnrollmentRequest getById(Integer id) {
        return enrollmentRequestRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Enrollment request with id " + id + " not found"));
    }

    public Set<EnrollmentRequest> findAllByAdId(Integer adId) {
        return enrollmentRequestRepository.findAllByAdId(adId);
    }

    public Set<EnrollmentRequest> findAllByChildId(Integer childId) {
        return enrollmentRequestRepository.findAllByChildId(childId);
    }

    public EnrollmentRequest update (Integer id, EnrollmentRequest enrollmentRequest) {
        if (enrollmentRequestRepository.existsById(id)) {
            EnrollmentRequest enrollmentRequestToUpdate = enrollmentRequestRepository.getById(id);
            enrollmentRequestToUpdate.setStatus(enrollmentRequest.getStatus());
            enrollmentRequestRepository.save(enrollmentRequestToUpdate);
            return enrollmentRequestToUpdate;
        } else {
            throw new EntityNotFoundException("Enrollment request with id " + id + " not found");
        }
    }
}
