package com.app.licenta.services;


import com.app.licenta.entities.*;
import com.app.licenta.repositories.EnrollmentRequestRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class EnrollmentRequestService {

    @Autowired
    private EnrollmentRequestRepository enrollmentRequestRepository;
    @Autowired
    private AdService adService;
    @Autowired
    private ChildService childService;

    public EnrollmentRequest createEnrollmentRequest(Integer adId, Integer childId) {

        Ad ad = adService.getById(adId);
        Child child = childService.getById(childId);

        boolean alreadyRequested = ad.getEnrollmentRequests().stream()
                .anyMatch(er -> er.getChild().getId().equals(childId));

        if (alreadyRequested) {
            throw new IllegalStateException("Copilul este deja înscris la acest anunț.");
        }

        if(ad.getEnrollmentRequests().size() > ad.getTotalSpots()) {
            throw new IllegalStateException("Nu mai există locuri disponibile.");
        }

        EnrollmentRequest enrollmentRequest = new EnrollmentRequest();
        enrollmentRequest.setAd(ad);
        enrollmentRequest.setChild(child);
        enrollmentRequest.setStatus(EnrollmentStatus.PENDING);

        ad.getEnrollmentRequests().add(enrollmentRequest);
        child.getEnrollmentRequests().add(enrollmentRequest);

        if(ad.getEnrollmentRequests().size() == ad.getTotalSpots()) {
            ad.setStatus(AdStatus.PENDING);
            adService.update(ad.getId(), ad);
        }

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

    public EnrollmentRequest update(Integer id, EnrollmentRequest enrollmentRequest) {
        EnrollmentRequest enrollmentRequestToUpdate = enrollmentRequestRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Enrollment request with id " + id + " not found"));
        enrollmentRequestToUpdate.setStatus(enrollmentRequest.getStatus());
        enrollmentRequestRepository.save(enrollmentRequestToUpdate);
        return enrollmentRequestToUpdate;
    }
}
