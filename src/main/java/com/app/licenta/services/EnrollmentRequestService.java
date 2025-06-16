package com.app.licenta.services;


import com.app.licenta.entities.*;
import com.app.licenta.repositories.EnrollmentRequestRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EnrollmentRequestService {

    @Autowired
    private EnrollmentRequestRepository enrollmentRequestRepository;
    @Autowired
    private AdService adService;
    @Autowired
    private ChildService childService;

    @Transactional
    public EnrollmentRequest createEnrollmentRequest(Integer adId, Integer childId) {
        Ad ad = adService.getById(adId);
        Child child = childService.getById(childId);
        ad.setLastEnrollmentRequestUpdated(LocalDateTime.now());

        boolean alreadyRequested = ad.getEnrollmentRequests().stream()
                .anyMatch(er -> er.getChild().getId().equals(childId));

        if (alreadyRequested) {
            throw new IllegalStateException("Copilul este deja înscris la acest anunț.");
        }

        long validEnrollmentRequests = ad.getEnrollmentRequests().stream()
                .filter(er -> er.getStatus() == EnrollmentStatus.PENDING || er.getStatus() == EnrollmentStatus.APPROVED)
                .count();
        if (validEnrollmentRequests == ad.getTotalSpots()) {
            throw new IllegalStateException("Nu mai există locuri disponibile.");
        }

        EnrollmentRequest enrollmentRequest = new EnrollmentRequest();
        enrollmentRequest.setAd(ad);
        enrollmentRequest.setChild(child);
        enrollmentRequest.setStatus(EnrollmentStatus.PENDING);

        ad.getEnrollmentRequests().add(enrollmentRequest);
        child.getEnrollmentRequests().add(enrollmentRequest);

        if (validEnrollmentRequests + 1 == ad.getTotalSpots()) {
            ad.setStatus(AdStatus.PENDING);
        }
        enrollmentRequestRepository.save(enrollmentRequest);

        return enrollmentRequest;
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

    public List<EnrollmentRequest> findAllByParentIdForActiveAds(Integer parentId, int pageNumber, int pageSize, String sortBy, String sortDirection) {
        Sort.Direction direction = Optional.ofNullable(sortDirection)
                .map(Sort.Direction::fromString)
                .orElse(Sort.Direction.DESC);
        Sort sort = Optional.ofNullable(sortBy)
                .map(s -> Sort.by(direction, s))
                .orElse(Sort.by(direction, "id"));
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return enrollmentRequestRepository.findAllByParentId(parentId, pageable).getContent();
    }

    @Transactional
    public EnrollmentRequest update(Integer id, EnrollmentRequest enrollmentRequest) {
        EnrollmentRequest enrollmentRequestToUpdate = enrollmentRequestRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Enrollment request with id " + id + " not found"));
        enrollmentRequestToUpdate.setStatus(enrollmentRequest.getStatus());
        enrollmentRequestRepository.save(enrollmentRequestToUpdate);
        if (enrollmentRequest.getStatus() == EnrollmentStatus.REJECTED ||
                enrollmentRequest.getStatus() == EnrollmentStatus.CANCELED) {
            enrollmentRequestToUpdate.getAd().setStatus(AdStatus.ACTIVE);
        }
        return enrollmentRequestToUpdate;
    }
}
