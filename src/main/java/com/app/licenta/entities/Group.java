package com.app.licenta.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.util.HashSet;
import java.util.Set;

import static org.hibernate.type.SqlTypes.JSON;

@Entity(name = "group")
@Table(name = "group", schema = "public")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    //are sens?
    @Column(name = "children_count")
    private Integer childrenCount;

    @Column(name = "min_age")
    private Integer minAge;

    @Column(name = "max_age")
    private Integer maxAge;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ChildrenGroupStatus status;

//    @ManyToOne
//    @JoinColumn(name = "ad_id")
//    private Ad ad;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;

    @Column(name = "meeting_days")
    @JdbcTypeCode(JSON)
    private Set<Day> activityDays = new HashSet<>();

//    @ManyToOne
//    @JoinColumn(name = "trainer_id")
//    private Trainer trainer;

    @ManyToMany(cascade={})
    @JoinTable(
            name = "group_children", schema = "public",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "child_id")
    )
    private Set<Child> children = new HashSet<>();

    @OneToMany(mappedBy = "group", cascade = {})
    private Set<Session> sessions = new HashSet<>();
}
