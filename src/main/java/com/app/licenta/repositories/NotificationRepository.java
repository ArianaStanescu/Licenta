package com.app.licenta.repositories;

import com.app.licenta.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    List<Notification> findByCreatedAtGreaterThanAndTrainerIdOrderByIdDesc(LocalDateTime date, Integer trainerId);

    List<Notification> findByCreatedAtGreaterThanAndParentIdOrderByIdDesc(LocalDateTime date, Integer parentId);

    @Modifying
    @Query("UPDATE notification n set n.seen = true where n.id in :notificationIds")
    void markAsSeen(List<Integer> notificationIds);
}
