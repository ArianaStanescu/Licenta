package com.app.licenta.dtos;

import com.app.licenta.entities.*;

import java.util.HashSet;
import java.util.Set;

public class GroupGetDto {
    private Integer id;
    private String title;
    private String description;
    private Integer childrenCount;
    private Integer minAge;
    private Integer maxAge;
    private Gender gender;
    private ChildrenGroupStatus status;
    private String location;
    private Set<DurationRule> durationRules = new HashSet<>();
    private Set<ChildDto> children = new HashSet<>();
    private ActivityDto activity;

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

    public Integer getChildrenCount() {
        return childrenCount;
    }

    public void setChildrenCount(Integer childrenCount) {
        this.childrenCount = childrenCount;
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

    public ChildrenGroupStatus getStatus() {
        return status;
    }

    public void setStatus(ChildrenGroupStatus status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<DurationRule> getDurationRules() {
        return durationRules;
    }

    public void setDurationRules(Set<DurationRule> durationRules) {
        this.durationRules = durationRules;
    }

    public Set<ChildDto> getChildren() {
        return children;
    }

    public void setChildren(Set<ChildDto> children) {
        this.children = children;
    }

    public ActivityDto getActivity() {
        return activity;
    }

    public void setActivity(ActivityDto activity) {
        this.activity = activity;
    }
}
