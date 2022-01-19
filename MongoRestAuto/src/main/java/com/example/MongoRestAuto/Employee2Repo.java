package com.example.MongoRestAuto;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.data.repository.NoRepositoryBean;


public interface Employee2Repo extends MongoRepository<Employee2,Integer> {
}
