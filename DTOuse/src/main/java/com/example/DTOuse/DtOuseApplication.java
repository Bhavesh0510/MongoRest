package com.example.DTOuse;

import com.example.DTOuse.model.Location;
import com.example.DTOuse.model.User;
import com.example.DTOuse.repository.LocationRepo;
import com.example.DTOuse.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//implements CommandLineRunner

@SpringBootApplication
public class DtOuseApplication{

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(DtOuseApplication.class, args);
	}

//	@Autowired
//	private UserRepo userRepo;
//
//	@Autowired
//	private LocationRepo locationRepo;

//	@Override
//	public void run(String... args) throws Exception{
//
//		Location location1 = new Location();
//		location1.setPlace("Mumbai");
//		location1.setDescription("Mumbai Indians is best team in the world.");
//		location1.setLongitude(40.5);
//		location1.setLatitude(30.6);
//		locationRepo.save(location1);
//
//		Location location2 = new Location();
//		location2.setPlace("Banglore");
//		location2.setDescription("RCB is most famous team in the world.");
//		location2.setLongitude(35.5);
//		location2.setLatitude(20.6);
//		locationRepo.save(location2);
//
//		User user1 = new User();
//		user1.setFirstName("Rohit");
//		user1.setLastName("Sharma");
//		user1.setEmail("rohit@gmail.com");
//		user1.setPassword("ipltrophy");
//		user1.setLocation(location1);
//		userRepo.save(user1);
//
//		User user2 = new User();
//		user2.setFirstName("Virat");
//		user2.setLastName("Kohli");
//		user2.setEmail("virat@kohli.com");
//		user2.setPassword("noipltrophytilldate");
//		user2.setLocation(location2);
//		userRepo.save(user2);
//
//
//	}
}
