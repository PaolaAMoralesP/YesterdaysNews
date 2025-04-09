package com.yesterdaysnews.yesterdaysnews.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
        return userService.createUser(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUserById(@PathVariable Integer id) {
        return userService.deleteUserById(id);
    }
}
