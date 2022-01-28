package com.example.MongoRestAPI.repo;

import com.example.MongoRestAPI.models.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepo extends MongoRepository<Employee, String> {
}
