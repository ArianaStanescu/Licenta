package com.app.licenta.controllers;

import com.app.licenta.dtos.NotificationDto;
import com.app.licenta.dtos.ReadNotificationsDto;
import com.app.licenta.entities.Notification;
import com.app.licenta.mappers.NotificationMapper;
import com.app.licenta.services.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PutMapping("/mark-as-seen")
    public void markAsSeen(@RequestBody ReadNotificationsDto readNotificationsDto) {
        notificationService.markAsSeen(Optional.ofNullable(readNotificationsDto.getNotificationIds()).orElse(List.of()));
    }

    @GetMapping("/latest-for-parent/{parentId}")
    public List<NotificationDto> findLatestForParent(@PathVariable Integer parentId) {
        List<Notification> notifications = notificationService.findLatestForParent(parentId);
        return notifications.stream()
                .map(NotificationMapper::notificationToNotificationDto)
                .toList();
    }

    @GetMapping("/latest-for-trainer/{trainerId}")
    public List<NotificationDto> findLatestForTrainer(@PathVariable Integer trainerId) {
        List<Notification> notifications = notificationService.findLatestForTrainer(trainerId);
        return notifications.stream()
                .map(NotificationMapper::notificationToNotificationDto)
                .toList();
    }
}
