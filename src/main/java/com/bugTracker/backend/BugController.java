package com.bugTracker.backend;

import lombok.AllArgsConstructor;
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


    @PostMapping("/new/bug")
    public ResponseEntity<?> newBug(@RequestBody NewBugRequest newBugRequest) {
        log.warn("New incoming Bug request...");
        CustomAPIResponse customAPIResponse = bugService.newBugReport(newBugRequest);

        if (customAPIResponse.msg().)
    }
}
