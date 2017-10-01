package com.ortega.usermanager.controller;

import com.ortega.usermanager.controller.errors.ResponseError;
import com.ortega.usermanager.controller.errors.ValidationFieldError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcela on 10/1/17.
*/

@ControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {

        protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
            List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
            List<ValidationFieldError> errors = new ArrayList<>();
            for (FieldError fieldError : fieldErrors) {
                ValidationFieldError customFieldError = new ValidationFieldError(fieldError.getField(), fieldError.getDefaultMessage(), fieldError.getRejectedValue());
                errors.add(customFieldError);
            }

            ResponseError errorResponse = new ResponseError(ex.getClass().getName(), errors, status.toString());
            return new ResponseEntity(errorResponse, headers, status);
        }
}





