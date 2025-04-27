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

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
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

    @Column(name = "duration_rules")
    @JdbcTypeCode(JSON)
    private Set<DurationRule> durationRules = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;

    @OneToMany(mappedBy = "ad", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private Set<EnrollmentRequest> enrollmentRequests = new HashSet<>();

    @OneToOne(mappedBy = "ad", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private AdImage image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ActivityCategory getCategory() {
        return category;
    }

    public void setCategory(ActivityCategory category) {
        this.category = category;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public AdStatus getStatus() {
        return status;
    }

    public void setStatus(AdStatus status) {
        this.status = status;
    }

    public Integer getTotalSpots() {
        return totalSpots;
    }

    public void setTotalSpots(Integer totalSpots) {
        this.totalSpots = totalSpots;
    }

    public Set<DurationRule> getDurationRules() {
        return durationRules;
    }

    public void setDurationRules(Set<DurationRule> durationRules) {
        this.durationRules = durationRules;
    }

    public AdImage getImage() {
        return image;
    }

    public void setImage(AdImage image) {
        this.image = image;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Set<EnrollmentRequest> getEnrollmentRequests() {
        return enrollmentRequests;
    }

    public void setEnrollmentRequests(Set<EnrollmentRequest> enrollmentRequests) {
        this.enrollmentRequests = enrollmentRequests;
    }

    public void addAdImage(AdImage image) {
        this.image = image;
        image.setAd(this);
    }

}
