
package com.yesterdaysnews.yesterdaysnews.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.yesterdaysnews.yesterdaysnews.service.ArticleService;
import com.yesterdaysnews.yesterdaysnews.model.Article;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping
    public ResponseEntity<Object> createArticle(@Valid @RequestBody Article article, @RequestParam Integer userId) {
        return articleService.createArticle(article, userId);

   
    // @GetMapping
    // public ResponseEntity<Object> getAllArticles(@) {
    //     return ResponseEntity.ok(articleService.getAllArticles());
    // }

    // Agregar
    // @DeleteMapping    
    // public ResponseEntity<Object> deleteArticleById(@PathVariable Integer id) {
    //     return articleService.deleteArticleById(id);
    // }
}
}


