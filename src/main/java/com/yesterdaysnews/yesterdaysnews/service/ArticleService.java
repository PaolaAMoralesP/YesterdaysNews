
    package com.yesterdaysnews.yesterdaysnews.service;

    import com.yesterdaysnews.yesterdaysnews.model.Article;
    import com.yesterdaysnews.yesterdaysnews.model.User;
    import com.yesterdaysnews.yesterdaysnews.repository.ArticleRepository;
    import com.yesterdaysnews.yesterdaysnews.repository.UserRepository;
    
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.stereotype.Service;
    
    @Service
    public class ArticleService {
    
        private final ArticleRepository articleRepository;
        private final UserRepository userRepository;
    
        public ArticleService(ArticleRepository articleRepository, UserRepository userRepository) {
            this.articleRepository = articleRepository;
            this.userRepository = userRepository;
        }
    
        public ResponseEntity<Object> createArticle(Article article, Integer userId) {
            // Look up the user
            User user = userRepository.findById(userId).orElse(null);
    
            if (user == null) {
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            }
    
            article.setUser(user);
    
            articleRepository.save(article);
    
            return new ResponseEntity<>(article, HttpStatus.CREATED);
        } 
}
