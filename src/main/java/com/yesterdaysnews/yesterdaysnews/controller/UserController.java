package com.yesterdaysnews.yesterdaysnews.controller;

import org.springframework.http.HttpStatus;
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
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        return new ResponseEntity<> (userService.createUser(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeUserById(@PathVariable Integer id) {
        boolean deleted = userService.deleteUserById(id);
        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("No user found with ID " + id);
        }
        return ResponseEntity.ok("User " + id + " deleted successfully");
    }
}
