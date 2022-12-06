package com.bugTracker.backend;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class BugServiceTest {

    @Mock
    private BugRepository bugRepository;
    @InjectMocks
    private BugService bugService;

    @Test
    @DisplayName("When new Bug is reported")
    void newBugReport() {
    }

    @Test
    @DisplayName("When we need to check if a bug is already reported or not")
    void isBugDuplicate() {
    }
}