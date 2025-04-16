package com.yesterdaysnews.yesterdaysnews.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.yesterdaysnews.yesterdaysnews.service.ArticleService;
import com.yesterdaysnews.yesterdaysnews.model.Article;

import jakarta.validation.Valid;
import java.util.Optional;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping
    public ResponseEntity<Article> createArticle(@Valid @RequestBody Article article, @RequestParam Integer userId) {
        return new ResponseEntity<>(articleService.createArticle(article, userId), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Article>> getAllArticles() {
        return new ResponseEntity<>(articleService.getAllArticles(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable int id) {
        Article article = articleService.getArticleById(id);
        return new ResponseEntity<>(article, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable int id, @Valid @RequestBody Article updatedArticle) {
        // Llama directamente al servicio para actualizar el artículo
        Article updated = articleService.updateArticle(id, updatedArticle);

        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable int id) {
        boolean deleted = articleService.deleteArticleById(id);
        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No article found with ID " + id);
        }
        return ResponseEntity.ok("Article " + id + " deleted successfully");
    }
}
