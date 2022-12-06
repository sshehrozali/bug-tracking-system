package com.bugTracker.backend;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Slf4j
public class DuplicateService {
    private BugRepository bugRepository;
    private DuplicateRepository duplicateRepository;
    public Boolean isBugDuplicate(Bug bug) {
        boolean bugExists = bugRepository.existsById(bug.getId());
        if (bugExists) {
            Duplicate duplicate = Duplicate.builder()
                    .markedAt(LocalDateTime.now())
                    .bug(bug)
                    .build();
            Duplicate duplicateFlushed = duplicateRepository.saveAndFlush(duplicate);
            log.info("New duplicate marked: " + duplicateFlushed.getId());
            return true;    // Bug already found
        }

        return false;
    }
}
