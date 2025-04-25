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

    @ManyToMany(mappedBy = "children", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Group> groups = new HashSet<>();

    @OneToMany(mappedBy = "child", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private Set<EnrollmentRequest> enrollmentRequests = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Transient
    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public Set<EnrollmentRequest> getEnrollmentRequests() {
        return enrollmentRequests;
    }

    public void setEnrollmentRequests(Set<EnrollmentRequest> enrollmentRequests) {
        this.enrollmentRequests = enrollmentRequests;
    }
}
