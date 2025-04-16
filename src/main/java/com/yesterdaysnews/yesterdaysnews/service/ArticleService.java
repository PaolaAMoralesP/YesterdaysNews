package com.yesterdaysnews.yesterdaysnews.service;

import com.yesterdaysnews.yesterdaysnews.exception.UserNotFoundException;
import com.yesterdaysnews.yesterdaysnews.exception.ArticleNotFoundException;
import com.yesterdaysnews.yesterdaysnews.model.Article;
import com.yesterdaysnews.yesterdaysnews.model.User;
import com.yesterdaysnews.yesterdaysnews.repository.ArticleRepository;
import com.yesterdaysnews.yesterdaysnews.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

    public ArticleService(ArticleRepository articleRepository, UserRepository userRepository) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
    }

    /**
     * Creates a new article and associates it with a user.
     *
     * @param article The article to create.
     * @param userId  The ID of the user to associate with the article.
     * @return The created article.
     * @throws UserNotFoundException If the user is not found.
     */
    public Article createArticle(Article article, Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + userId + " not found"));

        article.setUser(user);
        return articleRepository.save(article);
    }

    /**
     * Retrieves all articles.
     *
     * @return A list of all articles.
     */
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    /**
     * Retrieves an article by its ID.
     *
     * @param id The ID of the article.
     * @return The article with the given ID.
     * @throws ArticleNotFoundException If the article is not found.
     */
    public Article getArticleById(int id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new ArticleNotFoundException("Article with ID " + id + " not found"));
    }

    /**
     * Updates an existing article.
     *
     * @param id             The ID of the article to update.
     * @param updatedArticle The updated article data.
     * @return The updated article.
     * @throws ArticleNotFoundException If the article is not found.
     */
    public Article updateArticle(int id, Article updatedArticle) {
        // Busca el artículo existente
        Article existingArticle = articleRepository.findById(id)
                .orElseThrow(() -> new ArticleNotFoundException("Article with ID " + id + " not found"));

        // Actualiza los campos del artículo
        existingArticle.setTitle(updatedArticle.getTitle());
        existingArticle.setContent(updatedArticle.getContent());
        existingArticle.setCategories(updatedArticle.getCategories());

        // Guarda los cambios
        return articleRepository.save(existingArticle);
    }

    /**
     * Deletes an article by its ID.
     *
     * @param id The ID of the article to delete.
     * @return True if the article was deleted, false otherwise.
     */
    public boolean deleteArticleById(int id) {
        if (articleRepository.existsById(id)) {
            articleRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable int id) {
        if (deleteArticleById(id)) {
            return ResponseEntity.ok("Article " + id + " deleted successfully");
        } else {
            return ResponseEntity.status(404).body("Article " + id + " not found");
        }
    }
}
