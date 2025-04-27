package com.app.licenta.mappers;

import com.app.licenta.dtos.EnrollmentRequestDto;
import com.app.licenta.dtos.EnrollmentRequestUpdateDto;
import com.app.licenta.entities.EnrollmentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EnrollmentRequestMapper {
    @Autowired
    private AdMapper adMapper;
    @Autowired
    private ChildMapper childMapper;

    public EnrollmentRequestDto enrollmentRequestToEnrollmentRequestDto(EnrollmentRequest enrollmentRequest) {
        EnrollmentRequestDto enrollmentRequestDto = new EnrollmentRequestDto();
        enrollmentRequestDto.setId(enrollmentRequest.getId());
        enrollmentRequestDto.setStatus(enrollmentRequest.getStatus());
        enrollmentRequestDto.setAd(adMapper.adToAdDto(enrollmentRequest.getAd()));
        enrollmentRequestDto.setChild(childMapper.childToChildDto(enrollmentRequest.getChild()));
        return enrollmentRequestDto;
    }

    public Set<EnrollmentRequestDto> enrollmentRequestSetToEnrollmentRequestDtoSet(Set<EnrollmentRequest> enrollmentRequestList) {
        return enrollmentRequestList.stream().map(this::enrollmentRequestToEnrollmentRequestDto).collect(Collectors.toSet());
    }

    public List<EnrollmentRequestDto> enrollmentRequestListToEnrollmentRequestDtoList(List<EnrollmentRequest> enrollmentRequestList) {
        return enrollmentRequestList.stream().map(this::enrollmentRequestToEnrollmentRequestDto).collect(Collectors.toList());
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
