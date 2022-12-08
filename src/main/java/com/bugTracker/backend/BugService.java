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

    private final BugRepository bugRepository;
    private final QuestionSupportService questionSupportService;
    private final DuplicateService duplicateService;
    private final ResponseMessageService responseMessageService;

    public ResponseEntity<?> newBugReport(NewBugRequest newBugRequest) {
        if (newBugRequest.msg().length() == 1) {
            log.warn("Bug: length equals to 1");
            CustomAPIResponse customAPIResponse = CustomAPIResponse.builder()
                    .msg(responseMessageService.getMessage(MessageCode.INVALID_BUG_MESSAGE))
                    .build();
            return new ResponseEntity<>(customAPIResponse, HttpStatus.NOT_ACCEPTABLE);
        }

        if (newBugRequest.msg().isBlank() || newBugRequest.msg().isEmpty()) {
            log.warn("Bug: Empty");
            CustomAPIResponse customAPIResponse = CustomAPIResponse.builder()
                    .msg(responseMessageService.getMessage(MessageCode.EMPTY_BUG_MESSAGE))
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
                    .msg(responseMessageService.getMessage(MessageCode.INVALID_BUG_MESSAGE))
                    .build();
            return new ResponseEntity<>(customAPIResponse, HttpStatus.NOT_ACCEPTABLE);
        }

        Boolean isDuplicate = duplicateService.isBugDuplicate(bug);
        if (isDuplicate) {
            log.warn("Bug duplicate: Marked");
            CustomAPIResponse customAPIResponse = CustomAPIResponse.builder()
                    .msg(responseMessageService.getMessage(MessageCode.DUPLICATE_BUG_MESSAGE))
                    .build();
            return new ResponseEntity<>(customAPIResponse, HttpStatus.CONFLICT);
        }

        if (newBugRequest.details().isEmpty() || newBugRequest.details().isBlank()) {
            CustomAPIResponse customAPIResponse = CustomAPIResponse.builder()
                    .msg(responseMessageService.getMessage(MessageCode.DETAILS_NOT_PROVIDED))
                    .build();
            return new ResponseEntity<>(customAPIResponse, HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity<>("Bug reported.", HttpStatus.OK);
    }
}
