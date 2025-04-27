package com.app.licenta.controllers;

import com.app.licenta.dtos.FcmTokenDto;
import com.app.licenta.dtos.ParentDto;
import com.app.licenta.dtos.TrainerDto;
import com.app.licenta.entities.Parent;
import com.app.licenta.entities.Trainer;
import com.app.licenta.mappers.ParentMapper;
import com.app.licenta.mappers.TrainerMapper;
import com.app.licenta.notifications.FirebaseNotificationSender;
import com.app.licenta.services.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parents")
public class ParentController {

    @Autowired
    private ParentService parentService;

    @Autowired
    private ParentMapper parentMapper;

    @Autowired
    private TrainerMapper trainerMapper;

    @Autowired
    private FirebaseNotificationSender firebaseNotificationSender;

    @GetMapping("/{id}")
    public ParentDto get(@PathVariable Integer id) {
        Parent parent = parentService.getById(id);
        return parentMapper.parentToParentDto(parent);
    }

    @GetMapping("email/{email}")
    public ParentDto getByEmail(@PathVariable String email) {
        return parentMapper.parentToParentDto(parentService.getByEmail(email));
    }

    @GetMapping("/list")
    public List<ParentDto> findAll() {
        return parentMapper.parentListToParentDtoList(parentService.findAll());
    }

    @PostMapping("/register")
    public ParentDto create(@RequestBody ParentDto parentDto) {
        Parent parentToCreate = parentMapper.parentDtoToParent(parentDto);
        Parent createdParent = parentService.createParent(parentToCreate);
        return parentMapper.parentToParentDto(createdParent);
    }

    @PostMapping("/add-favorite-trainer/{parentId}/{trainerId}")
    public void addFavoriteTrainer(@PathVariable Integer parentId, @PathVariable Integer trainerId) {
        parentService.addFavoriteTrainer(parentId, trainerId);
    }

    @GetMapping("/favorite-trainers/{parentId}")
    public List<TrainerDto> getFavoriteTrainers(@PathVariable Integer parentId,
                                                @RequestParam Integer pageNumber,
                                                @RequestParam Integer pageSize) {
        List<Trainer> favoriteTrainers = parentService.getFavoriteTrainers(parentId, pageNumber, pageSize);
        return favoriteTrainers.stream()
                .map(trainerMapper::trainerToTrainerDto)
                .toList();
    }

    @GetMapping("/has-favorite-trainer/{parentId}/{trainerId}")
    public Boolean hasFavoriteTrainer(@PathVariable Integer parentId, @PathVariable Integer trainerId) {
        return parentService.hasFavoriteTrainer(parentId, trainerId);
    }

    @PutMapping("/{id}")
    public ParentDto update(@RequestBody ParentDto parentDto, @PathVariable Integer id) {
        return parentMapper.parentToParentDto(parentService.update(id, parentMapper.parentDtoToParent(parentDto)));
    }

    @PutMapping("/update-fcm-token/{id}")
    public void updateFcmToken(@PathVariable Integer id, @RequestBody FcmTokenDto fcmTokenDto) {
        parentService.updateFcmToken(id, fcmTokenDto.getFcmToken());
    }

    @GetMapping("/send-notification/{parentId}")
    public void sendNotification(@PathVariable Integer parentId) {
        firebaseNotificationSender.sendNotificationForParent(parentId, "Notification title", "Notification body ");
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        parentService.deleteById(id);
    }

    @DeleteMapping("/remove-favorite-trainer/{parentId}/{trainerId}")
    public void deleteFavoriteTrainer(@PathVariable Integer parentId, @PathVariable Integer trainerId) {
        parentService.removeFavoriteTrainer(parentId, trainerId);
    }
}
