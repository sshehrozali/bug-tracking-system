package com.bugTracker.backend;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
@Slf4j
public class BugController {
    private BugService bugService;

    @PostMapping("/new/bug")
    public String newBug(@RequestBody NewBugRequest newBugRequest) {
        log.warn("New incoming Bug request...");
        bugService.newBugReport(newBugRequest);
        return "Bug reported.";
    }
}
