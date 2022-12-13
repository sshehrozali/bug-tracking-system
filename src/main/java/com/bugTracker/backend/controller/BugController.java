package com.bugTracker.backend.controller;

import com.bugTracker.backend.service.BugService;
import com.bugTracker.backend.response.CustomAPIResponse;
import com.bugTracker.backend.request.NewBugRequest;
import com.bugTracker.backend.service.ResponseMessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
@Slf4j
public class BugController {
    private final BugService bugService;
    private final ResponseMessageService responseMessageService;

    @PostMapping("/new/bug")
    public ResponseEntity<?> newBug(@RequestBody NewBugRequest newBugRequest) {
        log.warn("New incoming Bug request...");
        CustomAPIResponse customAPIResponse = bugService.newBugReport(newBugRequest);
        return new ResponseEntity<>(customAPIResponse.msg(), customAPIResponse.httpStatus());
    }
}
