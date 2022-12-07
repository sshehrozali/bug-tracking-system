package com.bugTracker.backend;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ResponseMessageServiceTest {
    @InjectMocks
    private ResponseMessageService underTest;

    @Test
    void shouldReturnEmptyBugMessage() {
    }
}