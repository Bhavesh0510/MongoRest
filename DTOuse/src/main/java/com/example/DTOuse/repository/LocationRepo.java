package com.example.DTOuse.repository;

import com.example.DTOuse.model.Location;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationRepo extends MongoRepository<Location,String> {
    Location findByPlace(String place);

    void deleteByPlace(String place);
}
