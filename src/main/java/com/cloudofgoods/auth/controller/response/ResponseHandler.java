package com.cloudofgoods.auth.controller.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> responseBuilder(String message, String customCode, HttpStatus httpStatus, Object responseObject) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("code", customCode);
        response.put("httpStatus", httpStatus);
        response.put("data", responseObject);
        return new ResponseEntity<>(response, httpStatus);
    }
}
