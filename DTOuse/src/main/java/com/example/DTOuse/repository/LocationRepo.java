package com.example.DTOuse.repository;

import com.example.DTOuse.model.Location;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationRepo extends MongoRepository<Location,Long> {
}
