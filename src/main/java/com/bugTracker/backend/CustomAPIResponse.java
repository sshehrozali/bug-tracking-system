package com.bugTracker.backend;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Builder
public record CustomAPIResponse(
        String msg,
        HttpStatus httpStatus
) {
}
