package com.yesterdaysnews.yesterdaysnews.controller;

import com.yesterdaysnews.yesterdaysnews.model.User;
import com.yesterdaysnews.yesterdaysnews.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    @Mock
    private UserService userService; 

    @InjectMocks
    private UserController userController; 

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); 
    }

    @Test
    void testCreateUser() {
       
        User user = new User();
        user.setUsername("testuser");
        user.setEmailAddress("test@example.com");

        when(userService.createUser(user)).thenReturn(user); 

        
        ResponseEntity<User> response = userController.addUser(user);

        
        assertEquals(201, response.getStatusCode().value()); 
        assertEquals(user, response.getBody()); 
        verify(userService, times(1)).createUser(user); 
    }

    @Test
    void testDeleteUserById() {
        
        Integer userId = 1;

        when(userService.deleteUserById(userId)).thenReturn(true); 
       
        ResponseEntity<Object> response = userController.UserById(userId);

        
        assertEquals(200, response.getStatusCode().value()); 
        assertEquals(response.getBody(), "User and related articles have been deleted"); 
        verify(userService, times(1)).deleteUserById(userId); 
        }
}