package com.bugTracker.backend;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ResponseMessageService {
    public String getMessage(Enum code) {
        HashMap<Enum, String> messages = new HashMap<>();
        messages.put(MessageCode.EMPTY_BUG_MESSAGE, "Invalid Bug request. Can't be empty.");
        messages.put(MessageCode.DUPLICATE_BUG_MESSAGE, "Duplicate Bug found.");
        messages.put(MessageCode.INVALID_BUG_MESSAGE, "Not a valid Bug.");
        messages.put(MessageCode.DETAILS_NOT_PROVIDED, "Bug details not provided. Please provide to continue.");

        if (!messages.containsKey(code)) {
            return null;
        }

        return messages.get(code);
    }
}
