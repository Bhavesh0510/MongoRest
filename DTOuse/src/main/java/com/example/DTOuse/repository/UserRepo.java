package com.example.DTOuse.repository;

import com.example.DTOuse.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User,String> {
}
