package com.example.DTOuse.service;

import com.example.DTOuse.repository.UserRepo;
import com.example.DTOuse.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {

    @Mock
    private UserRepo userRepo;


    private UserService userService;

    @BeforeEach
    void setUp() {
        this.userService = new UserService(this.userRepo);
    }

    @Test
    void getAllUsers() {

        userService.getAllUserLocation();
        verify(userRepo).findAll();
    }



}