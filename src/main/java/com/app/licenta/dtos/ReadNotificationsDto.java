package com.app.licenta.dtos;

import java.util.List;

public class ReadNotificationsDto {
    private List<Integer> notificationIds;

    public List<Integer> getNotificationIds() {
        return notificationIds;
    }

    public void setNotificationIds(List<Integer> notificationIds) {
        this.notificationIds = notificationIds;
    }
}
