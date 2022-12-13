package com.bugTracker.backend.repository;

import com.bugTracker.backend.entity.Duplicate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuplicateRepository extends JpaRepository<Duplicate, Integer> {
}
