package com.app.licenta.dtos;

import com.app.licenta.entities.ActivityCategory;
import com.app.licenta.entities.AdStatus;
import com.app.licenta.entities.Day;
import com.app.licenta.entities.Gender;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class AdUpdateDto {
    private Integer id;
    private String title;
    private String description;
    private Double price;
    private ActivityCategory category;
    private Integer minAge;
    private Integer maxAge;
    private Gender gender;
    private LocalDate startDate;
    private LocalDate endDate;
    private AdStatus status;
    private Integer totalSpots;
    private Set<Day> activityDays = new HashSet<>();

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

    public Set<Day> getActivityDays() {
        return activityDays;
    }

    public void setActivityDays(Set<Day> activityDays) {
        this.activityDays = activityDays;
    }
}
