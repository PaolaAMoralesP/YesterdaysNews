package com.yesterdaysnews.yesterdaysnews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yesterdaysnews.yesterdaysnews.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    
}
