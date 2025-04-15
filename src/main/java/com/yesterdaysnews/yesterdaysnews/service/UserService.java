package com.yesterdaysnews.yesterdaysnews.service;

import com.yesterdaysnews.yesterdaysnews.repository.UserRepository;
import com.yesterdaysnews.yesterdaysnews.model.User;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Boolean deleteUserById(Integer id) {
        User user = userRepository.findUserById(id);
        if (user == null) {
            return null;
        }
        userRepository.delete(user);
        return user.getArticles() != null && !user.getArticles().isEmpty();
    }
}

