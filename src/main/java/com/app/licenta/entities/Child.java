package com.app.licenta.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "child")
@Table(name = "child", schema = "public")
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;

//    @ManyToMany(mappedBy = "children")
//    private Set<Activity> activities = new HashSet<>();
//
//    @ManyToMany(mappedBy = "children")
//    private Set<Ad> ads = new HashSet<>();

    @ManyToMany(mappedBy = "children")
    private Set<Group> groups = new HashSet<>();

    @OneToMany(mappedBy = "child", cascade = {})
    private Set<EnrollmentRequest> enrollmentRequests = new HashSet<>();
}
