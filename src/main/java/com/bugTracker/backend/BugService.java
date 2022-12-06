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

    public Boolean newBugReport(NewBugRequest newBugRequest) {
        if (newBugRequest.msg().isBlank() || newBugRequest.msg().isEmpty()) {
            log.warn("Bug request is invalid");
            return false;
        }

        Bug bug = Bug.builder()
                .bugMessage(newBugRequest.msg())
                .build();

        Boolean validate = questionSupportService.checkBugValidation(bug);
        if (!validate) {
            log.warn("Bug validation: Failed");
            return false;
        }

        Boolean isDuplicate = duplicateService.isBugDuplicate(bug);
        if (isDuplicate) {
            log.warn("Bug duplicate: Marked");
            return false;
        }

        return true;
    }
}
