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
    private QuestionSupportService questionSupportService;
    @Mock
    private DuplicateService duplicateService;
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

        System.out.println(customAPIResponse.msg());
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Should return invalid bug message")
    void shouldReturnInvalidBugMsg() {
        NewBugRequest newBugRequest = new NewBugRequest("Aaaa", "");
        ResponseEntity<?> actual = underTest.newBugReport(newBugRequest);
//
//        CustomAPIResponse customAPIResponse = new CustomAPIResponse(
//                responseMessageService.getMessage(MessageCode.INVALID_BUG_MESSAGE)
//        );
//        ResponseEntity<?> expected = new ResponseEntity<>(customAPIResponse, HttpStatus.NOT_ACCEPTABLE);

        System.out.println(actual.getBody());
    }
}