package com.bugTracker.backend;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class BugService {

    private BugRepository bugRepository;
    private QuestionSupportService questionSupportService;
    private DuplicateService duplicateService;

    public Boolean newBugReport(Bug bug) {
        Boolean validate = questionSupportService.checkBugValidation(bug);
        if (validate) {
            log.warn("Bug validation: Passed");
            Boolean isDuplicate = duplicateService.isBugDuplicate(bug);
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
}
