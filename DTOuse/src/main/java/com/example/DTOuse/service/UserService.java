package com.example.DTOuse.service;

import com.example.DTOuse.dto.UserLocationDTO;
import com.example.DTOuse.model.User;
import com.example.DTOuse.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<UserLocationDTO> getAllUserLocation(){
        return userRepo.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());

    }

    public Optional<UserLocationDTO> getUserById(Long id){
        return userRepo.findById(id).map(this::convertEntityToDto);
    }


    private UserLocationDTO convertEntityToDto(User user){
        UserLocationDTO userLocationDTO = new UserLocationDTO();
        userLocationDTO.setUserId(user.getId());
        userLocationDTO.setEmail(user.getEmail());
        userLocationDTO.setPlace(user.getLocation().getPlace());
        userLocationDTO.setLongitude(user.getLocation().getLongitude());
        userLocationDTO.setLatitude(user.getLocation().getLatitude());
        return userLocationDTO;
    }

//    private UserLocationDTO convertEntityToDto2(User user){
//        UserLocationDTO userLocationDTO = new UserLocationDTO();
//        userLocationDTO.setUserId(user.getId());
//        userLocationDTO.setEmail(user.getEmail());
//        userLocationDTO.setPlace(user.getLocation().getPlace());
//        userLocationDTO.setLongitude(user.getLocation().getLongitude());
//        userLocationDTO.setLatitude(user.getLocation().getLatitude());
//        return userLocationDTO;
//    }
    
}
