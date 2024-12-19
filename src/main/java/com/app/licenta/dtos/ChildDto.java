package com.app.licenta.dtos;

import com.app.licenta.entities.Activity;
import com.app.licenta.entities.Gender;
import com.app.licenta.entities.Parent;

import java.time.LocalDate;
import java.util.Set;

public class ChildDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate birthDate;
    private ParentDto parent;
    private Set<ActivityDto> activities;

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

    public ParentDto getParent() {
        return parent;
    }

    public void setParent(ParentDto parent) {
        this.parent = parent;
    }

    public Set<ActivityDto> getActivities() {
        return activities;
    }

    public void setActivities(Set<ActivityDto> activities) {
        this.activities = activities;
    }
}
