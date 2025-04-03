package com.app.licenta.controllers;

import com.app.licenta.dtos.FcmTokenDto;
import com.app.licenta.dtos.ParentDto;
import com.app.licenta.entities.Parent;
import com.app.licenta.mappers.ParentMapper;
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
        firebaseNotificationSender.sendNotificationForParent(parentId, "Notification title", "Notification body");
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        parentService.deleteById(id);
    }
}
