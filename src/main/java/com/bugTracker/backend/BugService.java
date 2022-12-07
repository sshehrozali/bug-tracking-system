package com.bugTracker.backend;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class BugService {

    private BugRepository bugRepository;
    private QuestionSupportService questionSupportService;
    private DuplicateService duplicateService;

    public ResponseEntity<?> newBugReport(NewBugRequest newBugRequest) {
        if (newBugRequest.msg().isBlank() || newBugRequest.msg().isEmpty()) {
            log.warn("Bug request is invalid");
            CustomAPIResponse customAPIResponse = CustomAPIResponse.builder()
                    .msg("Invalid Bug request. Can't be empty.")
                    .build();
            return new ResponseEntity<>(customAPIResponse, HttpStatus.NOT_ACCEPTABLE);
        }

        Bug bug = Bug.builder()
                .bugMessage(newBugRequest.msg())
                .build();

        Boolean validate = questionSupportService.checkBugValidation(bug);
        if (!validate) {
            log.warn("Bug validation: Failed");
            CustomAPIResponse customAPIResponse = CustomAPIResponse.builder()
                    .msg("Not a valid Bug.")
                    .build();
            return new ResponseEntity<>(customAPIResponse, HttpStatus.NOT_ACCEPTABLE);
        }

        Boolean isDuplicate = duplicateService.isBugDuplicate(bug);
        if (isDuplicate) {
            log.warn("Bug duplicate: Marked");
            CustomAPIResponse customAPIResponse = CustomAPIResponse.builder()
                    .msg("Duplicate Bug found.")
                    .build();
            return new ResponseEntity<>(customAPIResponse, HttpStatus.CONFLICT);
        }

        if (newBugRequest.details().isEmpty() || newBugRequest.details().isBlank()) {
            CustomAPIResponse customAPIResponse = CustomAPIResponse.builder()
                    .msg("Please provide details of the Bug.")
                    .build();
            return new ResponseEntity<>(customAPIResponse, HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity<>("Bug reorted.", HttpStatus.OK);
    }
}
