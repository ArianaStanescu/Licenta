package com.app.licenta.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "activity")
@Table(name = "activity", schema = "public")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private ActivityCategory category;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    @OneToMany(mappedBy = "activity", cascade = {})
    private Set<Group> groups = new HashSet<>();

    @OneToMany(mappedBy = "activity", cascade = {})
    private Set<Ad> ads = new HashSet<>();

}
