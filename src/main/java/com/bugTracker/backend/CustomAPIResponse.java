package com.bugTracker.backend;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public record CustomAPIResponse(
        String msg
) {
}
