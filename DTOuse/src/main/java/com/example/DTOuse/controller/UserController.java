package com.example.DTOuse.controller;

import com.example.DTOuse.dto.AdditionDTO;
import com.example.DTOuse.dto.UserLocationDTO;
import com.example.DTOuse.model.Location;
import com.example.DTOuse.model.User;
import com.example.DTOuse.repository.LocationRepo;
import com.example.DTOuse.repository.UserRepo;
import com.example.DTOuse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo user;

    @Autowired
    private LocationRepo location;

    @GetMapping("/users-location")
    public List<UserLocationDTO> getAllUsersLocation(){
        return userService.getAllUserLocation();
    }

    @GetMapping("/users-location/{id}")
    public ResponseEntity<Object> getUserLocation(@PathVariable String id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/users-location/delete/{id}")
    public ResponseEntity deleteUserLocation(@PathVariable String id){
        return userService.deleteUser(id);
    }

    @PostMapping("/users-location/add")
    public ResponseEntity addUserAndLocation(@RequestBody AdditionDTO additionDTO){
        return userService.addUser(additionDTO);
    }

    @PutMapping("/users-location/update-user/{id}")
    public ResponseEntity updateUserAndLocation(@RequestBody AdditionDTO additionDTO, @PathVariable String id){
        return userService.updateUser(id, additionDTO);
    }

    @PutMapping("/users-location/update-location/{place}")
    public ResponseEntity updateUserLocation(@RequestBody AdditionDTO additionDTO, @PathVariable String place){
        return userService.updateLocation(place, additionDTO);
    }

}

