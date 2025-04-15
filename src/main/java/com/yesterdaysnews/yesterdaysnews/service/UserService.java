package com.yesterdaysnews.yesterdaysnews.service;

import com.yesterdaysnews.yesterdaysnews.repository.UserRepository;
import com.yesterdaysnews.yesterdaysnews.model.User;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<Object> createUser(User user) {
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    public List<User> getAllUsers(){
            return userRepository.findAll();
    }

    // public ResponseEntity<Object> deleteUserById(Integer id) {
    //     if (userRepository.existsById(id) ) {
    //         userRepository.deleteById(id);
    //         return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    //     }
    //     //if(user exists and has articles associated){
    //     //    delete including articles + return message
    //     //}
    //      else {
    //         return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    //     }
    // }
public ResponseEntity<Object> deleteUserById(Integer id) {
        User user = userRepository.findUserById(id);
        if (user == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        boolean hasArticles = user.getArticles() != null && !user.getArticles().isEmpty();
        userRepository.delete(user);
            if (hasArticles) {
                return new ResponseEntity<>("User and related articles have been deleted", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("User deleted correctly", HttpStatus.OK);
            }
        }
}
