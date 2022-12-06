package com.bugTracker.backend;

import org.springframework.stereotype.Service;

@Service
public class DuplicateService {
    public Boolean isBugDuplicate(Bug bug) {
        return false;
    }
}
