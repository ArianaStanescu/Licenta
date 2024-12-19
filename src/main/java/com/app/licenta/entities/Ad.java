package com.app.licenta.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.hibernate.type.SqlTypes.JSON;

@Entity(name = "ad")
@Table(name = "ad", schema = "public")
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "category")
    private ActivityCategory category;

    @Column(name = "min_age")
    private Integer minAge;

    @Column(name = "max_age")
    private Integer maxAge;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private AdStatus status;

    @Column(name = "total_spots")
    private Integer totalSpots;

    @Column(name = "meeting_days")
    @JdbcTypeCode(JSON)
    private Set<Day> activityDays = new HashSet<>();

//    @ManyToOne
//    @JoinColumn(name = "trainer_id")
//    private Trainer trainer;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;

//    @ManyToMany(cascade={})
//    @JoinTable(name="ad_children", schema = "public",
//            joinColumns = @JoinColumn(name="ad_id"),
//            inverseJoinColumns = @JoinColumn(name="child_id"))
//    private Set<Child> children = new HashSet<>();

    @OneToMany(mappedBy = "ad", cascade = {})
    private Set<EnrollmentRequest> enrollmentRequests = new HashSet<>();

}
