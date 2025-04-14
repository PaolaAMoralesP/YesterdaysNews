
package com.yesterdaysnews.yesterdaysnews.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.yesterdaysnews.yesterdaysnews.service.ArticleService;
import com.yesterdaysnews.yesterdaysnews.model.Article;

import jakarta.validation.Valid;
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
        return new ResponseEntity<> (articleService.createArticle(article, userId), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Article>> getAllArticles() {
        return new ResponseEntity<>(articleService.getAllArticles(), HttpStatus.OK);
    }


}


