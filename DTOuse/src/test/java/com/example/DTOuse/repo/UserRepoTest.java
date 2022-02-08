package com.example.DTOuse.repo;

import com.example.DTOuse.controller.UserController;
import com.example.DTOuse.dto.AdditionDTO;
import com.example.DTOuse.dto.UserLocationDTO;
import com.example.DTOuse.model.User;
import com.example.DTOuse.repository.UserRepo;
import com.example.DTOuse.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserRepoTest {

    @Autowired
    private UserRepo userRepo;


    @MockBean
    private UserService userService;

    @Autowired
    private UserController userController;

    @Test
    void findById() {
        Boolean actualResult = userRepo.existsById("6200fcf7c7247568df9c2837");
        assertThat(actualResult).isTrue();
    }

    @Test
    public void getAllUsersLocationTest() {
        when(userController.getAllUsersLocation()).thenReturn(
                Stream.of(new UserLocationDTO("61f4e6e0388dc90ebe22b8c0", "ramesh@gmail.com", "Banglore", 12.7, 89.6),
                        new UserLocationDTO("2", "jay@gmail.com", "Mumbai", 67.9, 12.9)).collect(Collectors.toList()));
        assertEquals(2, userController.getAllUsersLocation().size());
        assertEquals("61f4e6e0388dc90ebe22b8c0", userController.getAllUsersLocation().get(0).getUserId());
        assertEquals("Mumbai", userController.getAllUsersLocation().get(1).getPlace());
    }

//    public void saveUserTest(){
//    }

    @Test
    public void addUserTest() {
        AdditionDTO customDTO = new AdditionDTO("abc", "xyz", "new@user.com", "123", "place", "desc", 23.33, 33.33);
        when(userController.addUserAndLocation(customDTO)).thenReturn(ResponseEntity.ok(customDTO));
        assertEquals(customDTO, userController.addUserAndLocation(customDTO).getBody());
        assertEquals(200, userController.addUserAndLocation(customDTO).getStatusCodeValue());
    }

    @Test
    public void updateUserTest() {
        String id = "12bvvhbcjhhvxvvgxxvs7";
        AdditionDTO customDTO = new AdditionDTO("abc", "xyz", "modified email", "modified pass", null, null, 0.0, 0.0);
        when(userController.updateUserAndLocation(customDTO, id)).thenReturn(ResponseEntity.ok(customDTO));
        assertEquals(customDTO, userController.updateUserAndLocation(customDTO, id).getBody());
        assertEquals(200, userController.updateUserAndLocation(customDTO, id).getStatusCodeValue());
    }

    @Test
    public void updateLocationTest() {
        String place = "new place";
        AdditionDTO customDTO = new AdditionDTO(null, null, null, null, "new place", "new desc", 23.33, 33.33);
        when(userController.updateUserLocation(customDTO, place)).thenReturn(ResponseEntity.ok(customDTO));
        assertEquals(customDTO, userController.updateUserLocation(customDTO, place).getBody());
        assertEquals(200, userController.updateUserLocation(customDTO, place).getStatusCodeValue());


    }
}