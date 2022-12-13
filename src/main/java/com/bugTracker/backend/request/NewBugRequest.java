package com.bugTracker.backend.request;

public record NewBugRequest(
        String msg,
        String details
) {
}
