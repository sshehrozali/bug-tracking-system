package com.bugTracker.backend;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class BugService {
    private QuestionSupport questionSupport;
    private BugRepository bugRepository;

    public Boolean newBugReport(Bug bug) {
        Boolean validate = questionSupport.checkBugValidation(bug);
        if (validate) {
            log.warn("Bug validation: Passed");
            Boolean isDuplicate = isBugDuplicate(bug);
            if (!isDuplicate) {
                log.info("Bug duplicate: Not Found");
                return true;
            } else {
                log.warn("Bug duplicate: Found");
            }
        } else {
            log.warn("Bug validation: Failed");
        }
        return false;
    }

    public Boolean isBugDuplicate(Bug bug) {
        return false;
    }
}
