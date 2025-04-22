package com.yesterdaysnews.yesterdaysnews.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for the application.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CategoryException.CategoryNotFoundException.class)
    public ResponseEntity<String> handleCategoryNotFoundException(CategoryException.CategoryNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CategoryException.CategoryAlreadyExistsException.class)
    public ResponseEntity<String> handleCategoryAlreadyExistsException(
            CategoryException.CategoryAlreadyExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(CategoryException.InvalidCategoryOperationException.class)
    public ResponseEntity<String> handleInvalidCategoryOperationException(
            CategoryException.InvalidCategoryOperationException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
