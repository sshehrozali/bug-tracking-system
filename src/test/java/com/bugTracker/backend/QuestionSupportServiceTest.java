package com.bugTracker.backend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionSupportServiceTest {
    private QuestionSupportService questionSupportService;
    @BeforeEach
    void setUp() {
        questionSupportService = new QuestionSupportService();
    }

    @Test
    @DisplayName("Should return true if bug message is not empty")
    void shouldReturnTrueIfBugMessageIsNotEmpty() {
        Bug testBug = Bug.builder()
                .bugMessage("Hello I am a test bug")
                .build();
        boolean actual = questionSupportService.checkBugValidation(testBug);
        assertEquals(true, actual);
    }

    @Test
    @DisplayName("Should return false if bug message is empty")
    void shouldReturnFalseIfBugMessageIsEmpty() {
        Bug testBug = Bug.builder()
                .bugMessage("")
                .build();
        boolean actual = questionSupportService.checkBugValidation(testBug);
        assertEquals(false, actual);
    }

    @Test
    @DisplayName("Should return false if length of bug message is equals to 1")
    void shouldReturnFalseIfLengthOfBugMessageEqualsTo1() {
        Bug testBug = Bug.builder()
                .bugMessage("A")
                .build();
        boolean actual = questionSupportService.checkBugValidation(testBug);
        assertEquals(false, actual);
    }

    @Test
    @DisplayName("Should return true if bug message is not empty or blank and length of bug message is greater than 1")
    void shouldReturnTrueIfBugMessageIsNotEmptyOrBlankAndLengthOfBugMessageIsGreaterThanOne() {
        Bug testBug = Bug.builder()
                .bugMessage("String Regex Error")
                .build();
        boolean actual = questionSupportService.checkBugValidation(testBug);
        assertEquals(true, actual);
    }
}