package com.app.licenta.dtos;

import com.app.licenta.entities.Gender;

import java.time.LocalDate;

public class TrainerDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String description;
    private Gender gender;
    private LocalDate birthDate;
    private Double reviewGrade;

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

    public Double getReviewGrade() {
        return reviewGrade;
    }

    public void setReviewGrade(Double reviewGrade) {
        this.reviewGrade = reviewGrade;
    }
}
