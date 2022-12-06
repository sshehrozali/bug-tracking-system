package com.bugTracker.backend;

public record NewBugRequest(
        String msg,
        String details
) {
}
