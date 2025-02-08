package com.app.licenta.mappers;

import com.app.licenta.dtos.EnrollmentRequestDto;
import com.app.licenta.dtos.EnrollmentRequestUpdateDto;
import com.app.licenta.entities.EnrollmentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EnrollmentRequestMapper {

    @Autowired
    private AdMapper adMapper;

    @Autowired
    private ChildMapper childMapper;

//    public EnrollmentRequestCreateDto enrollmentRequestToEnrollmentRequestCreateDto(EnrollmentRequest enrollmentRequest) {
//        EnrollmentRequestCreateDto dto = new EnrollmentRequestCreateDto();
//        dto.setId(enrollmentRequest.getId());
//        dto.setStatus(enrollmentRequest.getStatus());
//        return dto;
//    }
//
//    public EnrollmentRequest enrollmentRequestDtoToEnrollmentRequest(EnrollmentRequestCreateDto enrollmentRequestCreateDto) {
//        EnrollmentRequest enrollmentRequest = new EnrollmentRequest();
//        //enrollmentRequest.setId(dto.getId());
//        enrollmentRequest.setStatus(enrollmentRequestCreateDto.getStatus());
//        return enrollmentRequest;
//    }

    public EnrollmentRequestDto enrollmentRequestToEnrollmentRequestDto(EnrollmentRequest enrollmentRequest) {
        EnrollmentRequestDto enrollmentRequestDto = new EnrollmentRequestDto();
        enrollmentRequestDto.setId(enrollmentRequest.getId());
        enrollmentRequestDto.setStatus(enrollmentRequest.getStatus());
        enrollmentRequestDto.setAd(adMapper.adToAdDto(enrollmentRequest.getAd()));
        enrollmentRequestDto.setChild(childMapper.childToChildDto(enrollmentRequest.getChild()));
        return enrollmentRequestDto;
    }

    public Set<EnrollmentRequestDto> enrollmentRequestListToEnrollmentRequestDtoList (Set<EnrollmentRequest> enrollmentRequestList) {
        return enrollmentRequestList.stream().map(this::enrollmentRequestToEnrollmentRequestDto).collect(Collectors.toSet());
    }

    public EnrollmentRequest enrollemntRequestUpdateDtoToEnrollmentRequest(EnrollmentRequestUpdateDto enrollmentRequestUpdateDto) {
        EnrollmentRequest enrollmentRequest = new EnrollmentRequest();
        enrollmentRequest.setStatus(enrollmentRequestUpdateDto.getStatus());
        return enrollmentRequest;
    }

    public EnrollmentRequestUpdateDto enrollmentRequestToEnrollmentRequestUpdateDto(EnrollmentRequest enrollmentRequest) {
        EnrollmentRequestUpdateDto enrollmentRequestUpdateDto = new EnrollmentRequestUpdateDto();
        enrollmentRequestUpdateDto.setId(enrollmentRequest.getId());
        enrollmentRequestUpdateDto.setStatus(enrollmentRequest.getStatus());
        return enrollmentRequestUpdateDto;
    }

}
