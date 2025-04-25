package com.app.licenta.controllers;

import com.app.licenta.dtos.*;
import com.app.licenta.entities.EnrollmentRequest;
import com.app.licenta.entities.EnrollmentStatus;
import com.app.licenta.mappers.EnrollmentRequestMapper;
import com.app.licenta.notifications.FirebaseNotificationSender;
import com.app.licenta.services.EnrollmentRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/enrollment-requests")
public class EnrollmentRequestController {
    @Autowired
    private EnrollmentRequestService enrollmentRequestService;
    @Autowired
    private EnrollmentRequestMapper enrollmentRequestMapper;
    @Autowired
    private FirebaseNotificationSender firebaseNotificationSender;

    @PostMapping("/create/{adId}/{childId}")
    public EnrollmentRequestDto create(@PathVariable Integer adId, @PathVariable Integer childId) {
        EnrollmentRequest enrollmentRequest = enrollmentRequestService.createEnrollmentRequest(adId, childId);
        return enrollmentRequestMapper.enrollmentRequestToEnrollmentRequestDto(enrollmentRequest);
    }

    @GetMapping("/{id}")
    public EnrollmentRequestDto get(@PathVariable Integer id) {
        EnrollmentRequest enrollmentRequest = enrollmentRequestService.getById(id);
        return enrollmentRequestMapper.enrollmentRequestToEnrollmentRequestDto(enrollmentRequest);
    }

    @GetMapping("/list-by-ad/{adId}")
    public Set<EnrollmentRequestDto> findAllByAdId(@PathVariable Integer adId) {
        return enrollmentRequestMapper.enrollmentRequestListToEnrollmentRequestDtoList(enrollmentRequestService.findAllByAdId(adId));
    }

    @GetMapping("/list-by-child/{childId}")
    public Set<EnrollmentRequestDto> findAllByChildId(@PathVariable Integer childId) {
        return enrollmentRequestMapper.enrollmentRequestListToEnrollmentRequestDtoList(enrollmentRequestService.findAllByChildId(childId));
    }


    @PutMapping("/{id}")
    public EnrollmentRequestUpdateDto update(@RequestBody EnrollmentRequestUpdateDto enrollmentRequestUpdateDto, @PathVariable Integer id) {
        EnrollmentRequest updateER = enrollmentRequestService.update(id, enrollmentRequestMapper.enrollemntRequestUpdateDtoToEnrollmentRequest(enrollmentRequestUpdateDto));

        if (updateER.getStatus() == EnrollmentStatus.APPROVED) {
            firebaseNotificationSender.sendNotificationForApprovedEnReq(updateER.getChild().getParent().getId(), updateER.getChild().getFullName(), updateER.getAd().getTitle());
        } else if (updateER.getStatus() == EnrollmentStatus.REJECTED) {
            firebaseNotificationSender.sendNotificationForRejectedEnReq(updateER.getChild().getParent().getId(), updateER.getChild().getFullName(), updateER.getAd().getTitle());
        }
        return enrollmentRequestMapper.enrollmentRequestToEnrollmentRequestUpdateDto(updateER);
    }


}
