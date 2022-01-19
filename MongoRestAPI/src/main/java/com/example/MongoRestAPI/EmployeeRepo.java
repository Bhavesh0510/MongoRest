package com.example.MongoRestAPI;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepo extends MongoRepository<Employee, Integer> {
}
