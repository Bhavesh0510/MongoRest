package com.example.MongoRestAPI.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Employee")
public class Employee {

//    @Transient
//    public static final String SEQUENCE_NAME="employee_sequence";

    @Id
    private String eid;
    private String ename;
    private double salary;
}
