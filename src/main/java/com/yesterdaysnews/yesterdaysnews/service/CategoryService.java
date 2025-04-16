package com.yesterdaysnews.yesterdaysnews.service;

import com.yesterdaysnews.yesterdaysnews.exception.CategoryException;
import com.yesterdaysnews.yesterdaysnews.model.Category;
import com.yesterdaysnews.yesterdaysnews.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements IGenericService<Category, Integer> {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category create(Category category) {
        if (categoryRepository.existsById(category.getId())) {
            throw new CategoryException.CategoryAlreadyExistsException(
                    "Category with ID " + category.getId() + " already exists");
        }
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(
                        () -> new CategoryException.CategoryNotFoundException("Category with ID " + id + " not found"));
    }

    @Override
    public Category update(Integer id, Category category) {
        if (!categoryRepository.existsById(id)) {
            throw new CategoryException.CategoryNotFoundException("Category with ID " + id + " not found");
        }
        category.setId(id); // Ensure the ID is set for the update
        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(Integer id) {
        if (!categoryRepository.existsById(id)) {
            throw new CategoryException.CategoryNotFoundException("Category with ID " + id + " not found");
        }
        // Example of invalid operation
        if (id == 1) { // Assuming ID 1 is a protected category
            throw new CategoryException.InvalidCategoryOperationException("Cannot delete the default category");
        }
        categoryRepository.deleteById(id);
    }
}