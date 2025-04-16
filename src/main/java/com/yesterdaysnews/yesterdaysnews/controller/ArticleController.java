
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
    public ResponseEntity<Article> addArticle(@Valid @RequestBody Article article, @RequestParam Integer userId) {
        return new ResponseEntity<> (articleService.createArticle(article, userId), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Article>> listAllArticles() {
        return new ResponseEntity<>(articleService.getAllArticles(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> findArticleById(@PathVariable int id) {
        Optional<Article> article = articleService.getArticleById(id);
        if (article.isPresent()) {
            return new ResponseEntity<>(article.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeArticle(@PathVariable int id) {
        boolean deleted = articleService.deleteArticleById(id);
        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("No article found with ID " + id);
        }
        return ResponseEntity.ok("Article " + id + " deleted successfully");
    }
}


