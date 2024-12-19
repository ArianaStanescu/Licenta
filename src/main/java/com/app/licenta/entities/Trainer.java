package com.app.licenta.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "trainer")
@Table(name = "trainer", schema = "public")
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;

    @OneToMany(mappedBy = "trainer", cascade = {})
    private Set<Activity> activities = new HashSet<>();

//    @OneToMany(mappedBy = "trainer", cascade = {})
//    private Set<Ad> ads = new HashSet<>();

//    @OneToMany(mappedBy = "trainer", cascade = {})
//    private Set<Group> groups = new HashSet<>();

}