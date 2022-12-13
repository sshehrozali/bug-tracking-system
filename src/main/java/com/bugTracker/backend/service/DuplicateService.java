package com.bugTracker.backend.service;

import com.bugTracker.backend.repository.BugRepository;
import com.bugTracker.backend.repository.DuplicateRepository;
import com.bugTracker.backend.entity.Bug;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class DuplicateService {
    private BugRepository bugRepository;
    private DuplicateRepository duplicateRepository;
    public Boolean isBugDuplicate(Bug newBug) {
        Optional<Bug> existsBug = bugRepository.findByBugMessageLike(newBug.getBugMessage());


        return false;
    }
}
