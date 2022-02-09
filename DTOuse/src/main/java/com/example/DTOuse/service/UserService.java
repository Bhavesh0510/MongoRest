package com.example.DTOuse.service;

import com.example.DTOuse.dto.AdditionDTO;
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

    public ResponseEntity<Object> addUser(AdditionDTO additionDTO){
        System.out.println(additionDTO.toString());
        User user = new User();
        Location location = new Location();
        if(locationRepo.findByPlace(additionDTO.getPlace())==null) {
            location.setPlace(additionDTO.getPlace());
            location.setDescription(additionDTO.getDescription());
            location.setLatitude(additionDTO.getLatitude());
            location.setLongitude(additionDTO.getLongitude());
            locationRepo.save(location);
            System.out.println(location.toString());
        }
        if (userRepo.findByEmail(additionDTO.getEmail())==null) {
            Location location1 = locationRepo.findByPlace(additionDTO.getPlace());
            user.setFirstName(additionDTO.getFirstname());
            user.setLastName(additionDTO.getLastname());
            user.setEmail(additionDTO.getEmail());
            user.setPassword(additionDTO.getPassword());
            user.setLocation(location1);
            userRepo.save(user);
            System.out.println(location1.toString());
            System.out.println(user.toString());
            return ResponseEntity.ok("User added");
        }
        else {
            return new ResponseEntity("User already exists with given Email Id!!!", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Object> updateUser(String id, AdditionDTO additionDTO){

        User user1 = userRepo.findById(id).orElse(new User());

        if(user1.getFirstName()==null){
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        user1.setFirstName(additionDTO.getFirstname());
        user1.setLastName(additionDTO.getLastname());
        user1.setEmail(additionDTO.getEmail());
        user1.setPassword(additionDTO.getPassword());
        userRepo.save(user1);

        return ResponseEntity.ok("User updated");
    }

    public ResponseEntity<Object> updateLocation(String place, AdditionDTO additionDTO){
        Location location = locationRepo.findByPlace(place);

        if(location==null){
            return new ResponseEntity<>("Location not found", HttpStatus.NOT_FOUND);
        }

        location.setPlace(additionDTO.getPlace());
        location.setDescription(additionDTO.getDescription());
        location.setLatitude(additionDTO.getLatitude());
        location.setLongitude(additionDTO.getLongitude());
        locationRepo.save(location);

        return ResponseEntity.ok("Location updated");
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

    public ResponseEntity deleteLocation(String place) {
        if(locationRepo.findByPlace(place)!=null) {
            locationRepo.deleteByPlace(place);
            return new ResponseEntity("Deleted Successfully.", HttpStatus.OK);
        }
        else {
            return new ResponseEntity("Location not found or already deleted", HttpStatus.NOT_FOUND);
        }
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
