package com.bugTracker.backend;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class DuplicateService {
    private BugRepository bugRepository;
    private DuplicateRepository duplicateRepository;
    public Boolean isBugDuplicate(Bug bug) {
        return false;
    }
}
