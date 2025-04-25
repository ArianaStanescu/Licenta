package com.app.licenta.notifications;

import com.app.licenta.entities.Parent;
import com.app.licenta.entities.Trainer;
import com.app.licenta.repositories.ParentRepository;
import com.app.licenta.repositories.TrainerRepository;
import com.app.licenta.services.NotificationService;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.app.licenta.commons.EmailNotificationMessages.*;

@Component
public class FirebaseNotificationSender {

    private final FirebaseMessaging firebaseMessaging;
    private final NotificationService notificationService;
    private final ParentRepository parentRepository;
    private final TrainerRepository trainerRepository;

    public FirebaseNotificationSender(FirebaseMessaging firebaseMessaging,
                                      NotificationService notificationService,
                                      ParentRepository parentRepository,
                                      TrainerRepository trainerRepository) {
        this.firebaseMessaging = firebaseMessaging;
        this.notificationService = notificationService;
        this.parentRepository = parentRepository;
        this.trainerRepository = trainerRepository;
    }

    @Async
    public void sendNotificationForApprovedEnReq(Integer parentId, String childName, String adTitle) {
        sendNotificationForParent(parentId, ENROLLMENT_REQUEST_APPROVED_TITLE, ENROLLMENT_REQUEST_APPROVED_BODY.formatted(childName,adTitle));
    }

    @Async
    public void sendNotificationForRejectedEnReq(Integer parentId, String childName, String adTitle) {
        sendNotificationForParent(parentId, ENROLLMENT_REQUEST_REJECTED_TITLE, ENROLLMENT_REQUEST_REJECTED_BODY.formatted(childName, adTitle));
    }

    @Async
    public void sendNotificationForNewlyCreatedAd(Integer parentId, String trainerName) {
        sendNotificationForParent(parentId, NEW_AD_CREATED_TITLE, NEW_AD_CREATED_BODY.formatted(trainerName));
    }

    @Async
    public void sendNotificationForNewlyCreatedGroup(Integer parentId, String groupName) {
        sendNotificationForParent(parentId, NEW_GROUP_CREATED_TITLE, NEW_GROUP_CREATED_BODY.formatted(groupName));
    }

    @Async
    public void sendNotificationForParent(Integer parentId, String title, String body) {
        String token = parentRepository.findById(parentId)
                .map(Parent::getFcmToken)
                .orElse(null);
        if (token == null) {
            return;
        }
        Message msg = Message.builder()
                .setToken(token)
                .putAllData(Map.of("title", title, "body", body))
                .build();
        firebaseMessaging.sendAsync(msg);
        notificationService.createForParent(title, body, parentId);
    }

    @Async
    public void sendNotificationForTrainer(Integer trainerId, String title, String body) {
        String token = trainerRepository.findById(trainerId)
                .map(Trainer::getFcmToken)
                .orElse(null);
        if (token == null) {
            return;
        }
        Message msg = Message.builder()
                .setToken(token)
                .putAllData(Map.of("title", title, "body", body))
                .build();
        firebaseMessaging.sendAsync(msg);
        notificationService.createForTrainer(title, body, trainerId);
    }
}