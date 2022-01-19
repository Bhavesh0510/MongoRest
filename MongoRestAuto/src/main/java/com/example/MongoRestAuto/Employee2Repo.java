package com.example.MongoRestAuto;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "employee", path = "employee")
public interface Employee2Repo extends MongoRepository<Employee2, Integer> {
}
