package com.app.licenta.dtos;

import java.time.LocalDateTime;

public class SessionCommentDto {
    private Integer id;
    private String content;
    private LocalDateTime createdAt;
    private ParentDto authorParent;
    private TrainerDto authorTrainer;
    private boolean read;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ParentDto getAuthorParent() {
        return authorParent;
    }

    public void setAuthorParent(ParentDto authorParent) {
        this.authorParent = authorParent;
    }

    public TrainerDto getAuthorTrainer() {
        return authorTrainer;
    }

    public void setAuthorTrainer(TrainerDto authorTrainer) {
        this.authorTrainer = authorTrainer;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }
}
