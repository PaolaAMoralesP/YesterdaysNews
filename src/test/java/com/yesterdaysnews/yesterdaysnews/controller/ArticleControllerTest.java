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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ArticleControllerTest {

    @Mock
    private ArticleService articleService; // Simula el servicio

    @InjectMocks
    private ArticleController articleController; // Inyecta el mock del servicio en el controlador

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks
    }

    @Test
    void testAddArticle() {
        // Arrange
        Article article = new Article();
        article.setTitle("Test Article");
        article.setContent("This is a test article.");

        Integer userId = 1; // ID del usuario que crea el artículo

        when(articleService.createArticle(article, userId)).thenReturn(article); // Simula el comportamiento del servicio

        // Act
        ResponseEntity<Article> response = articleController.addArticle(article, userId);

        // Assert
        assertEquals(201, response.getStatusCode().value()); // Verifica que el código de estado sea 200 OK
        assertEquals(article, response.getBody()); // Verifica que el cuerpo de la respuesta sea el artículo creado
        verify(articleService, times(1)).createArticle(article, userId); // Verifica que el servicio fue llamado exactamente una vez
    }

    @Test
    void testRemoveArticle() {
        // Arrange
        Integer articleId = 1;

        when(articleService.deleteArticleById(articleId)).thenReturn(true); // Simula el comportamiento del servicio

        // Act
        ResponseEntity<String> response = articleController.removeArticle(articleId);

        // Assert
        assertEquals(200, response.getStatusCode().value()); // Verifica que el código de estado sea 200 OK
        assertEquals(response.getBody(), "Article 1 deleted successfully"); // Verifica que el cuerpo de la respuesta sea el mensaje esperado
        verify(articleService, times(1)).deleteArticleById(articleId); // Verifica que el servicio fue llamado exactamente una vez
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

        when(articleService.getAllArticles()).thenReturn(Arrays.asList(article1, article2)); // Simula el comportamiento del servicio

        // Act
        ResponseEntity<?> response = articleController.listAllArticles();

        // Assert
        assertEquals(200, response.getStatusCode().value()); // Verifica que el código de estado sea 200 OK
        assertEquals(2, ((Iterable<?>) response.getBody()).spliterator().getExactSizeIfKnown()); // Verifica que se devuelvan 2 artículos
        verify(articleService, times(1)).getAllArticles(); // Verifica que el servicio fue llamado exactamente una vez
    }

    @Test
    void testFindArticleByIdNotFound() {
        // Arrange
        Integer articleId = 999;
        when(articleService.getArticleById(articleId)).thenReturn(Optional.empty()); // Simulate article not found

        // Act
        ResponseEntity<Article> response = articleController.findArticleById(articleId);

        // Assert
        assertEquals(404, response.getStatusCode().value()); // Verify status code is 404 Not Found
        verify(articleService, times(1)).getArticleById(articleId); // Verify service was called exactly once
    }

    @Test
    void testFindArticleById() {
        // Arrange
        Integer articleId = 1;
        Article article = new Article();
        article.setId(articleId);
        article.setTitle("Test Article");
        article.setContent("This is a test article.");

        when(articleService.getArticleById(articleId)).thenReturn(Optional.of(article)); // Simula el comportamiento del servicio
        
        // Act
        ResponseEntity<Article> response = articleController.findArticleById(articleId);

        // Assert
        assertEquals(200, response.getStatusCode().value()); // Verifica que el código de estado sea 200 OK
        assertEquals(article, response.getBody()); // Verifica que el cuerpo de la respuesta sea el artículo esperado
        verify(articleService, times(1)).getArticleById(articleId); // Verifica que el servicio fue llamado exactamente una vez
    }
}