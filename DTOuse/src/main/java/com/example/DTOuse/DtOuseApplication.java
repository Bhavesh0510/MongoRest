package com.example.DTOuse;

import com.example.DTOuse.model.Location;
import com.example.DTOuse.model.User;
import com.example.DTOuse.repository.LocationRepo;
import com.example.DTOuse.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DtOuseApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DtOuseApplication.class, args);
	}

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private LocationRepo locationRepo;

	@Override
	public void run(String... args) throws Exception{

		Location location = new Location();
		location.setPlace("Pune");
		location.setDescription("Pune is great place to live");
		location.setLongitude(40.5);
		location.setLatitude(30.6);
		locationRepo.save(location);

		User user1 = new User();
		user1.setId(1);
		user1.setFirstName("Ramesh");
		user1.setLastName("Fadatare");
		user1.setEmail("ramesh@gmail.com");
		user1.setPassword("secret");
		user1.setLocation(location);
		userRepo.save(user1);

		User user2 = new User();
		user2.setId(2);
		user2.setFirstName("John");
		user2.setLastName("Cena");
		user2.setEmail("john@gmail.com");
		user2.setPassword("secret2");
		user2.setLocation(location);
		userRepo.save(user2);


	}
}
