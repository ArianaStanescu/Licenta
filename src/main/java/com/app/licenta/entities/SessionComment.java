package com.app.licenta.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "session_comment")
@Table(name = "session_comment", schema = "public")
public class SessionComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "author_parent_id", nullable = true)
    private Parent authorParent;

    @ManyToOne
    @JoinColumn(name = "author_trainer_id", nullable = true)
    private Trainer authorTrainer;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "session_comment_read_by_parent", schema = "public",
            joinColumns = @JoinColumn(name = "session_comment_id"),
            inverseJoinColumns = @JoinColumn(name = "parent_id", nullable = true)
    )
    private Set<Parent> readByParents = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "read_by_trainer", nullable = true)
    private Trainer readByTrainer;

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

    public Parent getAuthorParent() {
        return authorParent;
    }

    public void setAuthorParent(Parent authorParent) {
        this.authorParent = authorParent;
    }

    public Trainer getAuthorTrainer() {
        return authorTrainer;
    }

    public void setAuthorTrainer(Trainer authorTrainer) {
        this.authorTrainer = authorTrainer;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Set<Parent> getReadByParents() {
        return readByParents;
    }

    public void setReadByParents(Set<Parent> readByParents) {
        this.readByParents = readByParents;
    }

    public Trainer getReadByTrainer() {
        return readByTrainer;
    }

    public void setReadByTrainer(Trainer readByTrainer) {
        this.readByTrainer = readByTrainer;
    }
}
