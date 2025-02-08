package com.app.licenta.dtos;

import com.app.licenta.entities.EnrollmentStatus;

public class EnrollmentRequestDto {
    private Integer id;
    private EnrollmentStatus status;
    private AdDto ad;
    private ChildDto child;

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

    public AdDto getAd() {
        return ad;
    }

    public void setAd(AdDto ad) {
        this.ad = ad;
    }

    public ChildDto getChild() {
        return child;
    }

    public void setChild(ChildDto child) {
        this.child = child;
    }
}
