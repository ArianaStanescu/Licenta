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

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;

    @Column(name = "fcm_token")
    private String fcmToken;

    @Column(name = "reviews_grade")
    private Double reviewsGrade;

    @OneToMany(mappedBy = "trainer", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private Set<Activity> activities = new HashSet<>();

    @ManyToMany(mappedBy = "favoriteTrainers", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Parent> followersParents = new HashSet<>();

    @OneToMany(mappedBy = "trainer", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private Set<TrainerReview> trainerReviews = new HashSet<>();

    @OneToOne(mappedBy = "trainer", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private TrainerImage image;

//    @OneToMany(mappedBy = "authorTrainer", cascade = {})
//    private Set<SessionComment> sessionComments = new HashSet<>();
//
//    @OneToMany(mappedBy = "readByTrainer", cascade = {})
//    private Set<SessionComment> readSessionComments = new HashSet<>();

//    @OneToMany(mappedBy = "trainer", cascade = {})
//    private Set<Ad> ads = new HashSet<>();

//    @OneToMany(mappedBy = "trainer", cascade = {})
//    private Set<Group> groups = new HashSet<>();


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }

    public Set<Activity> getActivities() {
        return activities;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }

    public Set<Parent> getFollowersParents() {
        return followersParents;
    }

    public void setFollowersParents(Set<Parent> followersParents) {
        this.followersParents = followersParents;
    }

    public Set<TrainerReview> getTrainerReviews() {
        return trainerReviews;
    }

    public void setTrainerReviews(Set<TrainerReview> trainerReviews) {
        this.trainerReviews = trainerReviews;
    }

    public Double getReviewsGrade() {
        return reviewsGrade;
    }

    public void setReviewsGrade(Double reviewsGrade) {
        this.reviewsGrade = reviewsGrade;
    }

    public TrainerImage getImage() {
        return image;
    }

    public void setImage(TrainerImage image) {
        this.image = image;
    }
}