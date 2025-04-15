package com.app.licenta.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "trainer_review")
@Table(name = "trainer_review", schema = "public")
public class TrainerReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    private Parent parent;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    @Enumerated(EnumType.STRING)
    private TrainerReviewGrade trainerReviewGrade;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "comment", columnDefinition = "TEXT")
    private String comment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public TrainerReviewGrade getTrainerReviewGrade() {
        return trainerReviewGrade;
    }

    public void setTrainerReviewGrade(TrainerReviewGrade trainerReviewGrade) {
        this.trainerReviewGrade = trainerReviewGrade;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
