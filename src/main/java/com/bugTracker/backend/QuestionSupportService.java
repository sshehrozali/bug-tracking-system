package com.bugTracker.backend;

import org.springframework.stereotype.Service;

@Service
public class QuestionSupportService {
    public Boolean checkBugValidation(Bug bug) {
        if (bug.getBugMessage().isBlank()) {
            return false;
        }
        return true;
    }
}
