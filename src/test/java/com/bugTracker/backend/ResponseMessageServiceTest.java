package com.bugTracker.backend;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ResponseMessageServiceTest {
    @InjectMocks
    private ResponseMessageService underTest;

    @Test
    @DisplayName("Should return empty bug message")
    void shouldReturnEmptyBugMessage() {
        assertThat(underTest.getMessage(MessageCode.EMPTY_BUG_MESSAGE)).isNotBlank();
    }

    @Test
    @DisplayName("Should return invalid bug message")
    void shouldReturnInvalidBugMessage() {
        assertThat(underTest.getMessage(MessageCode.INVALID_BUG_MESSAGE)).isNotBlank();
    }

    @Test
    @DisplayName("Should return duplicate bug message")
    void shouldReturnDuplicateBugMessage() {
        assertThat(underTest.getMessage(MessageCode.DUPLICATE_BUG_MESSAGE)).isNotBlank();
    }

    @Test
    @DisplayName("Should return bug details not provided message")
    void shouldReturnDetailsNotProvidedBugMessage() {
        assertThat(underTest.getMessage(MessageCode.DETAILS_NOT_PROVIDED)).isNotBlank();
    }
}