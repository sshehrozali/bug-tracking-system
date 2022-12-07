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
    @DisplayName("Should return error message when message code is not matched")
    void shouldReturnEmptyBugMessage() {
        assertThat(underTest.getMessage(MessageCode.ERROR)).isNull();
    }
}