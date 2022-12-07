package com.bugTracker.backend;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BugServiceTest {
    @InjectMocks
    private BugService underTest;
    @InjectMocks
    private ResponseMessageService responseMessageService;

    @Test
    void shouldReturnBugMsgCantBeEmpty() {
        NewBugRequest newBugRequest = new NewBugRequest("", "");
        ResponseEntity<?> actual = underTest.newBugReport(newBugRequest);

        CustomAPIResponse customAPIResponse = new CustomAPIResponse()
        ResponseEntity<?> expected =
        assertThat(actual).isEqualTo()
    }
}