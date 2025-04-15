package com.yesterdaysnews.yesterdaysnews.controller;

import com.yesterdaysnews.yesterdaysnews.exception.CategoryException;
import com.yesterdaysnews.yesterdaysnews.model.Category;
import com.yesterdaysnews.yesterdaysnews.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category createdCategory = categoryService.create(category);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAll();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Integer id) {
        Category category = categoryService.getById(id);
        return ResponseEntity.ok(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Integer id, @RequestBody Category category) {
        Category updatedCategory = categoryService.update(id, category);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable Integer id) {
        categoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

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
