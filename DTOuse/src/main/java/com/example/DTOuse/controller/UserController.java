package com.example.DTOuse.controller;

import com.example.DTOuse.dto.UserLocationDTO;
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




}
