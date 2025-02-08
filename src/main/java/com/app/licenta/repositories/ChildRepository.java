package com.app.licenta.repositories;

import com.app.licenta.entities.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ChildRepository extends JpaRepository<Child, Integer> {
    Set<Child> findAllByParentId(Integer parentId);
}