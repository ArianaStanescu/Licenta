package com.app.licenta.entities;

import jakarta.persistence.*;

@Entity(name = "enrollment_request")
@Table(name = "enrollment_request", schema = "public")
public class EnrollmentRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ad_id")
    private Ad ad;

    @ManyToOne
    @JoinColumn(name = "child_id")
    private Child child;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private EnrollmentStatus status;

}