package com.app.licenta.repositories;

import com.app.licenta.entities.TrainerImage;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainerImageRepository extends JpaRepository<TrainerImage, Integer> {
    Optional<TrainerImage> findByTrainerId(Integer trainerId);

    @Modifying
    @Transactional
    @Query("DELETE FROM trainer_image ti WHERE ti.trainer.id = :trainerId")
    void deleteByTrainerId(@Param("trainerId") Integer trainerId);
}
