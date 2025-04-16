package com.yesterdaysnews.yesterdaysnews.exception;

/**
 * Base exception for all category-related exceptions.
 */
public class CategoryException extends RuntimeException {

    public CategoryException(String message) {
        super("[CATEGORY ERROR] " + message);
    }

    public CategoryException(String message, Throwable cause) {
        super("[CATEGORY ERROR] " + message, cause);
    }

    /**
     * Exception thrown when a category is not found.
     */
    public static class CategoryNotFoundException extends CategoryException {
        public CategoryNotFoundException(String message) {
            super("[CATEGORY NOT FOUND] " + message);
        }
    }

    /**
     * Exception thrown when a category already exists.
     */
    public static class CategoryAlreadyExistsException extends CategoryException {
        public CategoryAlreadyExistsException(String message) {
            super("[CATEGORY ALREADY EXISTS] " + message);
        }
    }

    /**
     * Exception thrown when a category operation is invalid.
     */
    public static class InvalidCategoryOperationException extends CategoryException {
        public InvalidCategoryOperationException(String message) {
            super("[INVALID CATEGORY OPERATION] " + message);
        }
    }
}
