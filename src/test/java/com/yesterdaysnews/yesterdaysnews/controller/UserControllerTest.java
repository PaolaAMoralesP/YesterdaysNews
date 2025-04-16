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
    private UserService userService; // Simula el servicio, lo controla el test

    @InjectMocks
    private UserController userController; // instancia que inyecta el mock del servicio y asi no se tiene que crear una instancia real del controlador

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks
    }

    @Test
    void testCreateUser() {
        // Arrange - Se prepara el escenario del test:
        User user = new User();
        user.setUsername("testuser");
        user.setEmailAddress("test@example.com");

        when(userService.createUser(user)).thenReturn(user); // Simula el comportamiento del servicio

        // Act - Se llama directamente al método del controlador como si fuera un endpoint.
        ResponseEntity<User> response = userController.addUser(user);

        // Assert - htttp respuesta
        assertEquals(201, response.getStatusCode().value()); // Verifica que el código de estado sea 200 OK
        assertEquals(user, response.getBody()); // Verifica que el cuerpo de la respuesta sea el usuario creado
        verify(userService, times(1)).createUser(user); // Verifica que el servicio fue llamado exactamente una vez
    }

    @Test
    void testDeleteUserById() {
        // Arrange
        Integer userId = 1;

        when(userService.deleteUserById(userId)).thenReturn(true); // Simula el comportamiento del servicio

        // Act
        ResponseEntity<String> response = userController.removeUserById(userId);

        // Assert
        assertEquals(200, response.getStatusCode().value()); // Verifica que el código de estado sea 200 OK
        assertEquals(response.getBody(), "User " + userId + " deleted successfully"); // Verifica que el cuerpo de la respuesta sea el mensaje esperado
        verify(userService, times(1)).deleteUserById(userId); // Verifica que el servicio fue llamado exactamente una vez
    }
}