package com.app.licenta.repositories;

import com.app.licenta.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    List<Notification> findByCreatedAtGreaterThanAndTrainerIdOrderByIdDesc(LocalDateTime date, Integer trainerId);

    List<Notification> findByCreatedAtGreaterThanAndParentIdOrderByIdDesc(LocalDateTime date, Integer parentId);
}
