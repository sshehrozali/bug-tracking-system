package com.bugTracker.backend;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BugServiceTest {
    @InjectMocks
    private BugService bugService;

    @Test
    void shouldReturnBugMsgCantBeEmpty() {
        NewBugRequest newBugRequest = new NewBugRequest("", "");
        CustomAPIResponse customAPIResponseExpected = new CustomAPIResponse("")
    }
}