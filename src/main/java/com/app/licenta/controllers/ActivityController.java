package com.app.licenta.controllers;

import com.app.licenta.dtos.ActivityDto;
import com.app.licenta.dtos.ActivityUpdateDto;
import com.app.licenta.entities.Activity;
import com.app.licenta.entities.Trainer;
import com.app.licenta.mappers.ActivityMapper;
import com.app.licenta.mappers.TrainerMapper;
import com.app.licenta.services.ActivityService;
import com.app.licenta.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/activities")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private TrainerMapper trainerMapper;

    @Autowired
    private TrainerService trainerService;

    @GetMapping("/{id}")
    public ActivityDto get(@PathVariable Integer id) {
        Activity activity = activityService.getById(id);
        return activityMapper.activityToActivityDto(activity);
    }

    @GetMapping("/list/{trainerId}")
    public Set<ActivityDto> findAllByTrainerId(@PathVariable Integer trainerId) {
        return activityMapper.activityListToActivityDtoList(activityService.findAllByTrainerId(trainerId));
    }

    @PostMapping("/create/{trainerId}")
    public ActivityDto create(@PathVariable Integer trainerId, @RequestBody ActivityDto activityDto) {
        Trainer trainer = trainerService.getById(trainerId);
        activityDto.setTrainer(trainerMapper.trainerToTrainerDto(trainer));
        Activity activityToCreate = activityMapper.activityDtoToActivity(activityDto);
        activityToCreate.setTrainer(trainer);
        trainer.getActivities().add(activityToCreate);
        Activity createdActivity = activityService.createActivity(activityToCreate);

        return activityMapper.activityToActivityDto(createdActivity);
    }

    @PutMapping("/{id}")
    public ActivityUpdateDto update(@RequestBody ActivityUpdateDto activityUpdateDto, @PathVariable Integer id) {
        return activityMapper.activityToActivityUpdateDto(activityService.update(id, activityMapper.activityUpdateDtoToActivity(activityUpdateDto)));
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        activityService.deleteById(id);
    }
}
