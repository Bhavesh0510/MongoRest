package com.example.MongoRestAPI.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Employee")
public class EmployeeSequence {

    @Id
    private String eid;

    private int seq;
}
