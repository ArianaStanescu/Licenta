package com.app.licenta.services;

import com.app.licenta.entities.Notification;
import com.app.licenta.entities.Parent;
import com.app.licenta.entities.Trainer;
import com.app.licenta.repositories.NotificationRepository;
import com.app.licenta.repositories.ParentRepository;
import com.app.licenta.repositories.TrainerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;
    private final TrainerRepository trainerRepository;
    private final ParentRepository parentRepository;

    public NotificationService(NotificationRepository notificationRepository,
                               TrainerRepository trainerRepository,
                               ParentRepository parentRepository) {
        this.notificationRepository = notificationRepository;
        this.trainerRepository = trainerRepository;
        this.parentRepository = parentRepository;
    }

    public void createForTrainer(String title, String body, Integer trainerId) {
        Trainer trainer = trainerRepository.findById(trainerId)
                .orElseThrow(() -> new EntityNotFoundException("Trainer with id " + trainerId + " not found"));
        Notification notification = new Notification();
        notification.setTitle(title);
        notification.setBody(body);
        notification.setCreatedAt(LocalDateTime.now());
        notification.setTrainer(trainer);
        notificationRepository.save(notification);
    }

    public void createForParent(String title, String body, Integer parentId) {
        Parent parent = parentRepository.findById(parentId)
                .orElseThrow(() -> new EntityNotFoundException("Parent with id " + parentId + " not found"));
        Notification notification = new Notification();
        notification.setTitle(title);
        notification.setBody(body);
        notification.setCreatedAt(LocalDateTime.now());
        notification.setParent(parent);
        notificationRepository.save(notification);
    }

    public void markAsRead(Integer notificationId) {
        notificationRepository.findById(notificationId)
                .ifPresent(notification -> {
                    notification.setSeen(true);
                    notificationRepository.save(notification);
                });
    }

    public List<Notification> findLatestForTrainer(Integer trainerId) {
        return notificationRepository.findByCreatedAtGreaterThanAndParentIdOrderByIdDesc(LocalDateTime.now().minusDays(7), trainerId);
    }

    public List<Notification> findLatestForParent(Integer parentId) {
        return notificationRepository.findByCreatedAtGreaterThanAndParentIdOrderByIdDesc(LocalDateTime.now().minusDays(7), parentId);
    }
}
