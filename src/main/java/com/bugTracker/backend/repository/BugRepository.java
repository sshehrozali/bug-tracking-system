package com.bugTracker.backend.repository;

import com.bugTracker.backend.entity.Bug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BugRepository extends JpaRepository<Bug, Integer> {
    @Query
    Optional<Bug> findByBugMessageLike(@NonNull String bugMessage);
}
