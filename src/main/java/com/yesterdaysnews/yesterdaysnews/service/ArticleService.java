package com.yesterdaysnews.yesterdaysnews.service;

import com.yesterdaysnews.yesterdaysnews.exception.UserNotFoundException;
import com.yesterdaysnews.yesterdaysnews.model.Article;
import com.yesterdaysnews.yesterdaysnews.model.User;
import com.yesterdaysnews.yesterdaysnews.repository.ArticleRepository;
import com.yesterdaysnews.yesterdaysnews.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

    public ArticleService(ArticleRepository articleRepository, UserRepository userRepository) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
    }

    public Article createArticle(Article article, Integer userId) {
        // Look up the user
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));

        article.setUser(user);
        articleRepository.save(article);

        return article;
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Optional<Article> getArticleById(int id) {
        return articleRepository.findById(id);
    }

    public Article updateArticle(Article updatedArticle) {
        int articleId = updatedArticle.getId();
        Optional<Article> existingArticle = articleRepository.findById(articleId);

        if (existingArticle.isPresent()) {
            Article articleToUpdate = existingArticle.get();
            articleToUpdate.setContent(updatedArticle.getContent());

            return articleRepository.save(articleToUpdate);
        } else {
            return null; // puede cambiarse a una Excepcion
        }
    }

    public boolean deleteArticleById(int id) {
        if (!articleRepository.existsById(id)) {
            return false;
        }
        articleRepository.deleteById(id);
        return true;
    }

}
