package com.bugTracker.backend;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BugServiceTest {
    @InjectMocks
    private BugService underTest;
    @Mock
    private ResponseMessageService responseMessageService;

    @Test
    @DisplayName("Should return empty bug message")
    void shouldReturnEmptyBugMsg() {
        NewBugRequest newBugRequest = new NewBugRequest("", "");
        ResponseEntity<?> actual = underTest.newBugReport(newBugRequest);

        CustomAPIResponse customAPIResponse = new CustomAPIResponse(
                responseMessageService.getMessage(MessageCode.EMPTY_BUG_MESSAGE)
        );
        ResponseEntity<?> expected = new ResponseEntity<>(customAPIResponse, HttpStatus.NOT_ACCEPTABLE);

        assertThat(actual).isEqualTo(expected);
    }

    void shouldReturnInvalidBugMsg()
}