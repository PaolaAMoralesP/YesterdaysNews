package com.yesterdaysnews.yesterdaysnews.exception;

/**
 * Base exception for all category-related exceptions.
 */
public class CategoryException extends RuntimeException {

    public CategoryException(String message) {
        super(message);
    }

    public CategoryException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Exception thrown when a category is not found.
     */
    public static class CategoryNotFoundException extends CategoryException {
        public CategoryNotFoundException(String message) {
            super(message);
        }
    }

    /**
     * Exception thrown when a category already exists.
     */
    public static class CategoryAlreadyExistsException extends CategoryException {
        public CategoryAlreadyExistsException(String message) {
            super(message);
        }
    }

    /**
     * Exception thrown when a category operation is invalid.
     */
    public static class InvalidCategoryOperationException extends CategoryException {
        public InvalidCategoryOperationException(String message) {
            super(message);
        }
    }
}
