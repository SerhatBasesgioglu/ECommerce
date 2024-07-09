package com.aydakar.ecommerce.service;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;

import com.aydakar.ecommerce.entity.User;
import com.aydakar.ecommerce.repository.UserRepository;

@SpringBootTest
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void getAllUsers_ShouldReturnListOfUsers() {
        User user1 = new User();
        User user2 = new User();
        List<User> mockUsers = Arrays.asList(user1, user2);

        when(userRepository.findAll()).thenReturn(mockUsers);

        List<User> userList = userService.getAllUsers();
        assertEquals(mockUsers, userList);
    }
}
