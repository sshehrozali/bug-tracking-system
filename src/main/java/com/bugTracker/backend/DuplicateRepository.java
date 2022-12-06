package com.bugTracker.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuplicateRepository extends JpaRepository<> {
}
