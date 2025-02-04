package com.app.licenta.dtos;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class SessionCommentDto {
    private Integer id;
    private String content;
    private LocalDateTime createdAt;
    private ParentDto authorParent;
    private TrainerDto authorTrainer;
    private SessionDto session;
    private Set<ParentDto> readByParents = new HashSet<>();
    private TrainerDto readByTrainer;


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

    public SessionDto getSession() {
        return session;
    }

    public void setSession(SessionDto session) {
        this.session = session;
    }

    public Set<ParentDto> getReadByParents() {
        return readByParents;
    }

    public void setReadByParents(Set<ParentDto> readByParents) {
        this.readByParents = readByParents;
    }

    public TrainerDto getReadByTrainer() {
        return readByTrainer;
    }

    public void setReadByTrainer(TrainerDto readByTrainer) {
        this.readByTrainer = readByTrainer;
    }
}
