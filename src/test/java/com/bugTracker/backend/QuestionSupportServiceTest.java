package com.bugTracker.backend;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class QuestionSupportServiceTest {
    @InjectMocks
    private QuestionSupportService questionSupportService;

    @Test
    @DisplayName("Should Check Bug Validation if Bug message is not empty")
    void shouldCheckBugValidationIfBugMessageIsNotEmpty() {
        Bug testBug = Bug.builder()
                .bugMessage("Hello I am a test bug")
                .build();
        boolean actual = questionSupportService.checkBugValidation(testBug);
        assertEquals(true, actual);
    }

    @Test
    @DisplayName("Should Check Bug Validation if Bug message is empty")
    void shouldCheckBugValidationIfBugMessageIsEmpty() {
        Bug testBug = Bug.builder()
                .bugMessage("")
                .build();
        boolean actual = questionSupportService.checkBugValidation(testBug);
        assertEquals(false, actual);
    }

    @Test
    @DisplayName("Should return false if length of bug message is equals to 1")
    void shouldReturnFalseForLengthOfBugMessageEquals1() {

    }
}