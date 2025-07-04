package com.app.licenta.repositories;

import com.app.licenta.entities.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Integer> {
    Optional<Parent> findByEmail(String email);

    boolean existsByIdAndFavoriteTrainersId(Integer parentId, Integer trainerId);
}
