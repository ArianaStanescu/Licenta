package com.app.licenta.dtos;

import com.app.licenta.entities.TrainerReviewGrade;

import java.time.LocalDateTime;

public class TrainerReviewDTO {
    private Integer id;
    private TrainerReviewGrade trainerReviewGrade;
    private String comment;
    private LocalDateTime createdAt;
    private TrainerDto trainerDto;
    private ParentDto parentDto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TrainerReviewGrade getTrainerReviewGrade() {
        return trainerReviewGrade;
    }

    public void setTrainerReviewGrade(TrainerReviewGrade trainerReviewGrade) {
        this.trainerReviewGrade = trainerReviewGrade;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public TrainerDto getTrainerDto() {
        return trainerDto;
    }

    public void setTrainerDto(TrainerDto trainerDto) {
        this.trainerDto = trainerDto;
    }

    public ParentDto getParentDto() {
        return parentDto;
    }

    public void setParentDto(ParentDto parentDto) {
        this.parentDto = parentDto;
    }
}
