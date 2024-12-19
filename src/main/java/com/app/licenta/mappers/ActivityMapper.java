package com.app.licenta.mappers;

import com.app.licenta.dtos.ActivityDto;
import com.app.licenta.entities.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ActivityMapper {

    @Autowired
    private TrainerMapper trainerMapper;

    public Activity activityDtoToActivity(ActivityDto activityDto) {
        Activity activity = new Activity();
//        activity.setId(activityDto.getId());
//        activity.setTitle(activityDto.getTitle());
//        activity.setDescription(activityDto.getDescription());
//        activity.setPrice(activityDto.getPrice());
//        activity.setCategory(activityDto.getCategory());
//        activity.setAgeRange(activityDto.getAgeRange());
//        activity.setGender(activityDto.getGender());
//        activity.setSpotsAvailable(activityDto.getSpotsAvailable());
//        activity.setTrainer(trainerMapper.trainerDtoToTrainer(activityDto.getTrainer()));
        return activity;
    }

    public ActivityDto activityToActivityDto(Activity activity) {
        ActivityDto activityDto = new ActivityDto();
//        activityDto.setId(activity.getId());
//        activityDto.setTitle(activity.getTitle());
//        activityDto.setDescription(activity.getDescription());
//        activityDto.setPrice(activity.getPrice());
//        activityDto.setCategory(activity.getCategory());
//        activityDto.setAgeRange(activity.getAgeRange());
//        activityDto.setGender(activity.getGender());
//        activityDto.setSpotsAvailable(activity.getSpotsAvailable());
//        activityDto.setTrainer(trainerMapper.trainerToTrainerDto(activity.getTrainer()));
        return activityDto;
    }

    public Set<ActivityDto> activityListToActivityDtoList(Set<Activity> activityList){
        return activityList.stream().map(this::activityToActivityDto).collect(Collectors.toSet());
    }

    public Set<Activity> activityDtoListToActivityList(Set<ActivityDto> activityDtoList){
        return activityDtoList.stream().map(this::activityDtoToActivity).collect(Collectors.toSet());
    }
}
