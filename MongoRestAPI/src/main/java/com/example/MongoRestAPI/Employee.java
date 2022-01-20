package com.example.MongoRestAPI;

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

    @Transient
    public static final String SEQUENCE_NAME="employee_sequence";

    @Id
    private int eid;
    private String ename;
    private double salary;
//
//    public int getEid() {
//        return eid;
//    }
//
//    public void setEid(int eid) {
//        this.eid = eid;
//    }
//
//    public String getEname() {
//        return ename;
//    }
//
//    public void setEname(String ename) {
//        this.ename = ename;
//    }
//
//    public double getSalary() {
//        return salary;
//    }
//
//    public void setSalary(double salary) {
//        this.salary = salary;
//    }
//
//    @Override
//    public String toString() {
//        return "Employee{" +
//                "eid=" + eid +
//                ", ename='" + ename + '\'' +
//                ", salary=" + salary +
//                '}';
//    }
}
