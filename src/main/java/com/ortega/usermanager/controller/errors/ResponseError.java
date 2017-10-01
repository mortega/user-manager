package com.ortega.usermanager.controller.errors;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * Created by marcela on 10/1/17.
 */
public class ResponseError {

    private LocalDateTime timestamp;
    private String status;
    private String error;
    private String exception;
    private String message;
    private List<ValidationFieldError> errors;

    public ResponseError(String exception, List errors, String status){
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = "Validation error";
        this.exception = exception;
        this.message = "There are field errors: " + errors.size();
        this.errors = errors;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getException() {
        return exception;
    }

    public String getMessage() {
        return message;
    }

    public List<ValidationFieldError> getErrors() {
        return errors;
    }

}
