package com.yesterdaysnews.yesterdaysnews.controller;

import com.yesterdaysnews.yesterdaysnews.model.Article;
import com.yesterdaysnews.yesterdaysnews.service.ArticleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ArticleControllerTest {

    @Mock
    private ArticleService articleService;
    @InjectMocks
    private ArticleController articleController; 
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddArticle() {
        // Arrange
        Article article = new Article();
        article.setTitle("Test Article");
        article.setContent("This is a test article.");

        Integer userId = 1; 

        when(articleService.createArticle(article, userId)).thenReturn(article); 

        // Act
        ResponseEntity<Article> response = articleController.addArticle(article, userId);

        // Assert
        assertEquals(201, response.getStatusCode().value()); 
        assertEquals(article, response.getBody()); 
        verify(articleService, times(1)).createArticle(article, userId);
    }

    @Test
    void testRemoveArticle() {
        // Arrange
        Integer articleId = 1;

        when(articleService.deleteArticleById(articleId)).thenReturn(true);

        // Act
        ResponseEntity<String> response = articleController.removeArticle(articleId);

        // Assert
        assertEquals(200, response.getStatusCode().value()); 
        assertEquals(response.getBody(), "Article 1 deleted successfully"); 
        verify(articleService, times(1)).deleteArticleById(articleId); 
    }

    @Test
    void testListAllArticles() {
        // Arrange
        Article article1 = new Article();
        article1.setTitle("Article 1");
        article1.setContent("Content 1");

        Article article2 = new Article();
        article2.setTitle("Article 2");
        article2.setContent("Content 2");

        when(articleService.getAllArticles()).thenReturn(Arrays.asList(article1, article2));

        // Act
        ResponseEntity<?> response = articleController.listAllArticles();

        // Assert
        assertEquals(200, response.getStatusCode().value()); 
        assertEquals(2, ((Iterable<?>) response.getBody()).spliterator().getExactSizeIfKnown()); 
        verify(articleService, times(1)).getAllArticles(); 
    }

    @Test
    void testFindArticleById() {
        // Arrange
        Integer articleId = 1;
        Article article = new Article();
        article.setId(articleId);
        article.setTitle("Test Article");
        article.setContent("This is a test article.");

        when(articleService.getArticleById(articleId)).thenReturn(article); 

        // Act
        ResponseEntity<Article> response = articleController.findArticleById(articleId);

        // Assert
        assertEquals(200, response.getStatusCode().value()); 
        assertEquals(article, response.getBody()); 
        verify(articleService, times(1)).getArticleById(articleId); 
    }
}