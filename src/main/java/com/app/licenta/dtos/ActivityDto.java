package com.app.licenta.dtos;

import com.app.licenta.entities.Child;
import com.app.licenta.entities.Gender;

import java.util.Set;

public class ActivityDto {
    private Integer id;
    private String title;
    private String description;
    private Double price;
    private String category;
    private String ageRange;
    private Gender gender;
    private Integer spotsAvailable;
    private TrainerDto trainer;
    private Set<ChildDto> children;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getSpotsAvailable() {
        return spotsAvailable;
    }

    public void setSpotsAvailable(Integer spotsAvailable) {
        this.spotsAvailable = spotsAvailable;
    }

    public TrainerDto getTrainer() {
        return trainer;
    }

    public void setTrainer(TrainerDto trainer) {
        this.trainer = trainer;
    }

    public Set<ChildDto> getChildren() {
        return children;
    }

    public void setChildren(Set<ChildDto> children) {
        this.children = children;
    }
}
