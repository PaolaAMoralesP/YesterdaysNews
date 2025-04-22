package com.yesterdaysnews.yesterdaysnews.dto;

import com.yesterdaysnews.yesterdaysnews.model.Article;

public class ArticleRequest {

    private Article article;
    private Integer userId;

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
