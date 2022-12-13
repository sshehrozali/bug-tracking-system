package com.bugTracker.backend.service;

import com.bugTracker.backend.entity.Bug;
import org.springframework.stereotype.Service;

@Service
public class QuestionSupportService {
    public Boolean checkBugValidation(Bug bug) {
        if (bug.getBugMessage().isBlank() || bug.getBugMessage().length() == 1) {
            return false;
        }
        return true;
    }
}
