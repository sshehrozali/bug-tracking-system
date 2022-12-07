package com.bugTracker.backend;

import java.util.HashMap;

public class ResponseMessageService {
    public ResponseMessageService() {
        HashMap<Enum, String> responseMessages = new HashMap<>();
        responseMessages.put(MessageCode.EMPTY_BUG_MESSAGE, "Empty Bug");
    }
}
