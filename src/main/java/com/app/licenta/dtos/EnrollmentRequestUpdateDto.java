package com.app.licenta.dtos;

import com.app.licenta.entities.EnrollmentStatus;

public class EnrollmentRequestUpdateDto {
    private Integer id;
    private EnrollmentStatus status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EnrollmentStatus getStatus() {
        return status;
    }

    public void setStatus(EnrollmentStatus status) {
        this.status = status;
    }
}
