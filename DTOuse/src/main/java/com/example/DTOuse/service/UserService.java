package com.example.DTOuse.service;

import com.example.DTOuse.dto.UserLocationDTO;
import com.example.DTOuse.model.Location;
import com.example.DTOuse.model.User;
import com.example.DTOuse.repository.LocationRepo;
import com.example.DTOuse.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private LocationRepo locationRepo;

    @Autowired
    private ModelMapper modelMapper;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

//    public UserService(UserRepo userRepo, ModelMapper mapper) {
//        this.userRepo = userRepo;
//        this.mapper = mapper;
//    }

    public List<UserLocationDTO> getAllUserLocation(){
        return userRepo.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());

    }

    public ResponseEntity<Object> getUserById(String id){
        User user = userRepo.findById(id).orElse(new User());
        if(user.getFirstName()==null){
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(convertEntityToDto(user));
    }


    public ResponseEntity deleteUser(String id){
        if(userRepo.findById(id).isPresent()) {
            userRepo.deleteById(id);
            return new ResponseEntity("Deleted Successfully.", HttpStatus.OK);
        }
        else {
            return new ResponseEntity("User not found or already deleted", HttpStatus.NOT_FOUND);
        }
    }



    private UserLocationDTO convertEntityToDto(User user){

//        UserLocationDTO userLocationDTO = new UserLocationDTO();
//
//        userLocationDTO.setUserId(user.getId());
//        userLocationDTO.setEmail(user.getEmail());
//        userLocationDTO.setPlace(user.getLocation().getPlace());
//        userLocationDTO.setLongitude(user.getLocation().getLongitude());
//        userLocationDTO.setLatitude(user.getLocation().getLatitude());
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(user, UserLocationDTO.class);
//        return userLocationDTO;
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
