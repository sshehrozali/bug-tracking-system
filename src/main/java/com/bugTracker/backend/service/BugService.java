package com.bugTracker.backend.service;

import com.bugTracker.backend.entity.Bug;
import com.bugTracker.backend.misc.MessageCode;
import com.bugTracker.backend.repository.BugRepository;
import com.bugTracker.backend.request.NewBugRequest;
import com.bugTracker.backend.response.CustomAPIResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BugService {
    private final BugRepository bugRepository;
    private final QuestionSupportService questionSupportService;
    private final DuplicateService duplicateService;
    private final ResponseMessageService responseMessageService;

    public CustomAPIResponse newBugReport(NewBugRequest newBugRequest) {
        if (newBugRequest.msg().length() == 1) {
            log.warn("Bug: length equals to 1");
            CustomAPIResponse customAPIResponse = CustomAPIResponse.builder()
                    .msg(responseMessageService.getMessage(MessageCode.INVALID_BUG_MESSAGE))
                    .httpStatus(HttpStatus.NOT_ACCEPTABLE)
                    .build();
            return customAPIResponse;
        }

        if (newBugRequest.msg().isBlank() || newBugRequest.msg().isEmpty()) {
            log.warn("Bug: Empty");
            CustomAPIResponse customAPIResponse = CustomAPIResponse.builder()
                    .msg(responseMessageService.getMessage(MessageCode.EMPTY_BUG_MESSAGE))
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .build();
            return customAPIResponse;
        }

        Bug bug = Bug.builder()
                .bugMessage(newBugRequest.msg())
                .bugDetails(newBugRequest.details())
                .build();

        Boolean validate = questionSupportService.checkBugValidation(bug);
        if (!validate) {
            log.warn("Bug validation: Failed");
            CustomAPIResponse customAPIResponse = CustomAPIResponse.builder()
                    .msg(responseMessageService.getMessage(MessageCode.INVALID_BUG_MESSAGE))
                    .httpStatus(HttpStatus.NOT_ACCEPTABLE)
                    .build();
            return customAPIResponse;
        }

        Boolean isDuplicate = duplicateService.isBugDuplicate(bug);
        if (isDuplicate) {
            log.warn("Bug duplicate: Marked");
            CustomAPIResponse customAPIResponse = CustomAPIResponse.builder()
                    .msg(responseMessageService.getMessage(MessageCode.DUPLICATE_BUG_MESSAGE))
                    .httpStatus(HttpStatus.ALREADY_REPORTED)
                    .build();
            return customAPIResponse;
        }

        if (newBugRequest.details().isEmpty() || newBugRequest.details().isBlank()) {
            CustomAPIResponse customAPIResponse = CustomAPIResponse.builder()
                    .msg(responseMessageService.getMessage(MessageCode.DETAILS_NOT_PROVIDED))
                    .httpStatus(HttpStatus.NO_CONTENT)
                    .build();
            return customAPIResponse;
        }

        bugRepository.save(bug);
        log.info("Bug: Confirmed successfully");
        return new CustomAPIResponse("Bug reported successfully.", HttpStatus.OK);
    }
}
