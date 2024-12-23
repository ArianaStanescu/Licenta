package com.app.licenta.controllers;

import com.app.licenta.dtos.*;
import com.app.licenta.entities.Trainer;
import com.app.licenta.mappers.ActivityMapper;
import com.app.licenta.mappers.TrainerMapper;
import com.app.licenta.services.ActivityService;
import com.app.licenta.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trainers")
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private TrainerMapper trainerMapper;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private ActivityMapper activityMapper;

    @GetMapping("/{id}")
    public TrainerDto get(@PathVariable Integer id) {
        Trainer trainer = trainerService.getById(id);
        return trainerMapper.trainerToTrainerDto(trainer);
    }

//    @GetMapping("/list")
//    public List<TrainerDto> findAll() {
//        return trainerMapper.parentListToParentDtoList(trainerService.findAll());
//    }

    @PostMapping("/register")
    public TrainerDto create(@RequestBody TrainerDto trainerDto) {
        Trainer trainerToCreate = trainerMapper.trainerDtoToTrainer(trainerDto);
        Trainer createdTrainer = trainerService.createTrainer(trainerToCreate);
        return trainerMapper.trainerToTrainerDto(createdTrainer);
    }

    //update

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        trainerService.deleteById(id);
    }

//    @PatchMapping("/create-activity/{id}")
//    public TrainerDto createChild(@RequestBody ActivityCreateDto activityCreateDto, @PathVariable Integer id) {
//        Trainer trainer = trainerService.getById(id);
//
//        activityCreateDto.setTrainer(trainerMapper.trainerToTrainerDto(trainer));
//
//        Activity activityToCreate = activityMapper.activityCreateDtoToActivity(activityCreateDto);
//        activityToCreate.setTrainer(trainer);
//        Activity createdActivityToCreate = activityService.createActivity(activityToCreate);
//        trainer.getActivities().add(createdActivityToCreate);
//        return trainerMapper.trainerToTrainerDto(trainer);
//    }
//
//    @DeleteMapping("/delete-activity/{trainerId}/{activityId}")
//    public TrainerDto deleteActivity(@PathVariable Integer trainerId, @PathVariable Integer activityId) {
//        Trainer trainer = trainerService.getById(trainerId);
//        Activity activityToDelete = activityService.getById(activityId);
//        activityService.deleteById(activityId);
//        trainer.getActivities().remove(activityToDelete);
//        return trainerMapper.trainerToTrainerDto(trainer);
//    }
}
