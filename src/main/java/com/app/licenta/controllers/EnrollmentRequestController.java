package com.app.licenta.controllers;

import com.app.licenta.dtos.*;
import com.app.licenta.entities.Ad;
import com.app.licenta.entities.Child;
import com.app.licenta.entities.EnrollmentRequest;
import com.app.licenta.entities.EnrollmentStatus;
import com.app.licenta.mappers.EnrollmentRequestMapper;
import com.app.licenta.services.AdService;
import com.app.licenta.services.ChildService;
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

//    @PostMapping("/create/{adId}/{childId}")
//    public EnrollmentRequestCreateDto create(@PathVariable Integer adId, @PathVariable Integer childId) {
//        Ad ad = adService.getById(adId);
//        Child child = childService.getById(childId);
//        EnrollmentRequest enrollmentRequestToCreate = new EnrollmentRequest();
//        enrollmentRequestToCreate.setAd(ad);
//        enrollmentRequestToCreate.setChild(child);
//        enrollmentRequestToCreate.setStatus(EnrollmentStatus.PENDING);
//        ad.getEnrollmentRequests().add(enrollmentRequestToCreate);
//        child.getEnrollmentRequests().add(enrollmentRequestToCreate);
//        EnrollmentRequest createdEnrollmentRequest = enrollmentRequestService.createEnrollmentRequest(enrollmentRequestToCreate);
//
//        return enrollmentRequestMapper.enrollmentRequestToEnrollmentRequestCreateDto(createdEnrollmentRequest);
//    }

    @PutMapping("/{id}")
    public EnrollmentRequestUpdateDto update(@RequestBody EnrollmentRequestUpdateDto enrollmentRequestUpdateDto, @PathVariable Integer id) {
        return enrollmentRequestMapper.enrollmentRequestToEnrollmentRequestUpdateDto(enrollmentRequestService.update(id, enrollmentRequestMapper.enrollemntRequestUpdateDtoToEnrollmentRequest(enrollmentRequestUpdateDto)));
    }


}
