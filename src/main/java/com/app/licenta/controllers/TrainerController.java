package com.app.licenta.controllers;

import com.app.licenta.dtos.*;
import com.app.licenta.entities.Trainer;
import com.app.licenta.mappers.TrainerMapper;
import com.app.licenta.notifications.FirebaseNotificationSender;
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
    private FirebaseNotificationSender firebaseNotificationSender;

    @GetMapping("/{id}")
    public TrainerDto get(@PathVariable Integer id) {
        Trainer trainer = trainerService.getById(id);
        return trainerMapper.trainerToTrainerDto(trainer);
    }

    @GetMapping("email/{email}")
    public TrainerDto getByEmail(@PathVariable String email) {
        return trainerMapper.trainerToTrainerDto(trainerService.getByEmail(email));
    }

    @PostMapping("/register")
    public TrainerDto create(@RequestBody TrainerDto trainerDto) {
        Trainer trainerToCreate = trainerMapper.trainerDtoToTrainer(trainerDto);
        Trainer createdTrainer = trainerService.createTrainer(trainerToCreate);
        return trainerMapper.trainerToTrainerDto(createdTrainer);
    }

    @PutMapping("/{id}")
    public TrainerDto update(@RequestBody TrainerDto trainerDto, @PathVariable Integer id) {
        return trainerMapper.trainerToTrainerDto(trainerService.update(id, trainerMapper.trainerDtoToTrainer(trainerDto)));
    }

    @PutMapping("/update-fcm-token/{id}")
    public void updateFcmToken(@PathVariable Integer id, @RequestBody FcmTokenDto fcmTokenDto) {
        trainerService.updateFcmToken(id, fcmTokenDto.getFcmToken());
    }

    @GetMapping("/send-notification/{trainerId}")
    public void sendNotification(@PathVariable Integer trainerId) {
        firebaseNotificationSender.sendNotificationForTrainer(trainerId, "Trainer notification title", "Trainer notification body");
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        trainerService.deleteById(id);
    }

}
