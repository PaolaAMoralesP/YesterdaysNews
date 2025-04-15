package com.yesterdaysnews.yesterdaysnews.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yesterdaysnews.yesterdaysnews.service.UserService;
import com.yesterdaysnews.yesterdaysnews.model.User;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUserById(@PathVariable Integer id) {
        Boolean hadArticles = userService.deleteUserById(id);
        if (hadArticles == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        String message = hadArticles
            ? "User and related articles have been deleted"
            : "User deleted correctly";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}

