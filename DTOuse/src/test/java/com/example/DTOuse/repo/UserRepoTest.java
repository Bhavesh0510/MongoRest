package com.example.DTOuse.repo;

import com.example.DTOuse.controller.UserController;
import com.example.DTOuse.dto.AdditionDTO;
import com.example.DTOuse.dto.UserLocationDTO;
//import com.example.DTOuse.model.User;
import com.example.DTOuse.repository.UserRepo;
import com.example.DTOuse.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
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
    public void deleteUserTest_EmptyUserId() {
        String id = "";
        String obj = userController.deleteUser(id);
        assertEquals("User id is empty", obj);
    }

    @Test
    public void deleteUserTest_Success() {
        String id = "1";
        when(userService.deleteUser(id)).thenReturn("User deleted");
        String obj = userController.deleteUser(id);
        assertEquals("User deleted", obj);
    }

    @Test
    public void deleteUserTest_NullUserId() {
        String id = null;
        String obj = userController.deleteUser(id);
        assertEquals("User id can't be null", obj);
    }

    @Test
    public void findById() {
        Boolean actualResult = userRepo.existsById("6200fcf7c7247568df9c2837");
        assertThat(actualResult).isTrue();
    }

    @Test
    public void getAllUsersLocationTest() {
        when(userService.getAllUserLocation()).thenReturn(
                Stream.of(new UserLocationDTO("61f4e6e0388dc90ebe22b8c0", "ramesh@gmail.com", "Banglore", 12.7, 89.6),
                        new UserLocationDTO("2", "jay@gmail.com", "Mumbai", 67.9, 12.9)).collect(Collectors.toList()));
        List<UserLocationDTO> users = userController.getAllUsersLocation();
        assertEquals(2, users.size());
        assertEquals("61f4e6e0388dc90ebe22b8c0", users.get(0).getUserId());
        assertEquals("Mumbai", users.get(1).getPlace());
        assertEquals(12.9, users.get(1).getLatitude(),0.0);
        assertEquals(12.7, users.get(0).getLongitude(),0.0);
    }

    @Test
    public void addUserTest() {
        AdditionDTO additionDTO = new AdditionDTO("abc", "xyz", "new@user.com", "123", "place", "desc", 23.33, 33.33);
        when(userController.addUserAndLocation(additionDTO)).thenReturn(ResponseEntity.ok(additionDTO));
        assertEquals(additionDTO, userController.addUserAndLocation(additionDTO).getBody());
        assertEquals(200, userController.addUserAndLocation(additionDTO).getStatusCodeValue());
    }

    @Test
    public void updateUserTest() {
        String id = "12bvvhbcjhhvxvvgxxvs7";
        AdditionDTO additionDTO = new AdditionDTO("abc", "xyz", "modified email", "modified pass", null, null, 0.0, 0.0);
        when(userController.updateUserAndLocation(additionDTO, id)).thenReturn(ResponseEntity.ok(additionDTO));
        assertEquals(additionDTO, userController.updateUserAndLocation(additionDTO, id).getBody());
        assertEquals(200, userController.updateUserAndLocation(additionDTO, id).getStatusCodeValue());
    }

    @Test
    public void updateLocationTest() {
        String place = "new place";
        AdditionDTO additionDTO = new AdditionDTO(null, null, null, null, "new place", "new desc", 23.33, 33.33);
        when(userController.updateUserLocation(additionDTO, place)).thenReturn(ResponseEntity.ok(additionDTO));
        assertEquals(additionDTO, userController.updateUserLocation(additionDTO, place).getBody());
        assertEquals(200, userController.updateUserLocation(additionDTO, place).getStatusCodeValue());
    }

//    @Test
//    public void deleteUserTest() {
//        String id = "12bvvhbcjhhvxvvgxxvs7";
//        when(userController.deleteUser(id)).thenReturn(ResponseEntity.ok(id));
//        assertEquals(id, userController.deleteUser(id).getBody());
//        assertEquals(200, userController.deleteUser(id).getStatusCodeValue());
//    }

    @Test
    public void deleteLocationTest() {
        String place = "new place";
        when(userController.deleteLocation(place)).thenReturn(ResponseEntity.ok(place));
        assertEquals(place, userController.deleteLocation(place).getBody());
        assertEquals(200, userController.deleteLocation(place).getStatusCodeValue());
    }
}