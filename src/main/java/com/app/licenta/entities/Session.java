package com.app.licenta.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "session")
@Table(name = "session", schema = "public")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

}
