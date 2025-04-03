package com.app.licenta.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "notification")
@Table(name = "notification", schema = "public")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;

    @Column(name = "seen")
    private boolean seen;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    private Parent parent;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
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
}
