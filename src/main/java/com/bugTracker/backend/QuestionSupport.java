package com.bugTracker.backend;

import org.springframework.stereotype.Service;

@Service
public class QuestionSupport {
    public Boolean checkBugValidation(Bug bug) {
        return true;
    }
}
