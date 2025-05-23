package com.yesterdaysnews.yesterdaysnews.controller;

import com.yesterdaysnews.yesterdaysnews.model.Category;
import com.yesterdaysnews.yesterdaysnews.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CategoryControllerTest {
    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    
    @Test
    void testCreateCategory() {
        
        Category inputCategory = new Category();
        inputCategory.setType("Technology");
    
        Category createdCategory = new Category();
        createdCategory.setId(1);
        createdCategory.setType("Technology");
    
        when(categoryService.create(inputCategory)).thenReturn(createdCategory);
    
        
        ResponseEntity<Category> response = categoryController.createCategory(inputCategory);
    
        
        assertEquals(201, response.getStatusCode().value());
        assertEquals(createdCategory.getType(), response.getBody().getType());
        assertEquals(createdCategory.getId(), response.getBody().getId());
        verify(categoryService, times(1)).create(inputCategory);
    }

    @Test
    void testDeleteCategoryById() {
        
        int idToDelete = 1;
        doNothing().when(categoryService).deleteById(idToDelete);

        
        ResponseEntity<Void> response = categoryController.deleteCategoryById(idToDelete);

        
        assertEquals(204, response.getStatusCode().value());
        assertNull(response.getBody()); // ResponseEntity.noContent() returns null body
        verify(categoryService, times(1)).deleteById(idToDelete);
    }

    @Test
    void testGetAllCategories() {
         
    Category tech = new Category();
    tech.setType("Technology");

    Category health = new Category();
    health.setType("Health");

    List<Category> categories = Arrays.asList(tech, health);
    when(categoryService.getAll()).thenReturn(categories);

    
    ResponseEntity<List<Category>> response = categoryController.getAllCategories();

    
    assertEquals(200, response.getStatusCode().value());
    assertNotNull(response.getBody());
    assertEquals(2, response.getBody().size());
    assertEquals("Technology", response.getBody().get(0).getType());
    assertEquals("Health", response.getBody().get(1).getType());
    verify(categoryService, times(1)).getAll();
}

    @Test
    void testGetCategoryById() {
    
    int id = 1;
    Category category = new Category();
    category.setType("Lifestyle");

    when(categoryService.getById(id)).thenReturn(category);

    
    ResponseEntity<Category> response = categoryController.getCategoryById(id);

    
    assertEquals(200, response.getStatusCode().value());
    assertNotNull(response.getBody());
    assertEquals("Lifestyle", response.getBody().getType());
    verify(categoryService, times(1)).getById(id);
    }


    @Test
    void testUpdateCategory() {
    
    int id = 1;
    Category inputCategory = new Category();
    inputCategory.setType("Technology");

    Category updatedCategory = new Category();
    updatedCategory.setType("Technology");

    when(categoryService.update(id, inputCategory)).thenReturn(updatedCategory);

    
    ResponseEntity<Category> response = categoryController.updateCategory(id, inputCategory);

    
    assertEquals(200, response.getStatusCode().value());
    assertNotNull(response.getBody());
    assertEquals("Technology", response.getBody().getType());
    verify(categoryService, times(1)).update(id, inputCategory);
    }
}
