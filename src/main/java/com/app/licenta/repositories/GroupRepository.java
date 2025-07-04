package com.app.licenta.repositories;

import com.app.licenta.entities.ChildrenGroupStatus;
import com.app.licenta.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Set;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
    Set<Group> findAllByActivityId(Integer activityId);

    @Query("SELECT g FROM group g WHERE g.activity.trainer.id = :trainerId")
    Set<Group> findAllByTrainerId(@Param("trainerId") Integer trainerId);

    @Query("SELECT g FROM group g JOIN g.children c WHERE c.id = :childId")
    Set<Group> findAllByChildId(@Param("childId") Integer childId);

    Set<Group> findAllByAdEndDateBeforeAndStatus(LocalDate date, ChildrenGroupStatus status);
}