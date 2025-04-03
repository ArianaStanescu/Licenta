package com.app.licenta.mappers;

import com.app.licenta.dtos.NotificationDto;
import com.app.licenta.entities.Notification;

public class NotificationMapper {
    public static NotificationDto notificationToNotificationDto(Notification notification) {
        NotificationDto notificationDto = new NotificationDto();
        notificationDto.setId(notification.getId());
        notificationDto.setCreatedAt(notification.getCreatedAt());
        notificationDto.setSeen(notification.isSeen());
        notificationDto.setTitle(notification.getTitle());
        notificationDto.setBody(notification.getBody());
        return notificationDto;
    }

    public static Notification notificationDtoToNotification(NotificationDto notificationDto) {
        Notification notification = new Notification();
        notification.setId(notificationDto.getId());
        notification.setCreatedAt(notificationDto.getCreatedAt());
        notification.setSeen(notificationDto.isSeen());
        notification.setTitle(notificationDto.getTitle());
        notification.setBody(notificationDto.getBody());
        return notification;
    }
}
