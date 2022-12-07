package com.bugTracker.backend;

import lombok.Builder;
import lombok.Data;

@Builder
public record CustomAPIResponse(
        String msg
) {
}
