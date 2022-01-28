package com.example.DTOuse.controller;

import com.example.DTOuse.dto.UserLocationDTO;
import com.example.DTOuse.model.Location;
import com.example.DTOuse.model.User;
import com.example.DTOuse.repository.LocationRepo;
import com.example.DTOuse.repository.UserRepo;
import com.example.DTOuse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Optional<UserLocationDTO> getUserLocation(@PathVariable long id){
        return userService.getUserById(id);
    }




}
