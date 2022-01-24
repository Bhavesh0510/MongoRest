package com.example.MongoRestAPI.controller;

import com.example.MongoRestAPI.exception.ApiRequestException;
import com.example.MongoRestAPI.models.Employee;
import com.example.MongoRestAPI.repo.EmployeeRepo;
import com.example.MongoRestAPI.service.impl.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepo repo;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @PostMapping("/addEmp")
    public String saveEmp(@RequestBody Employee emp) {
        try{
            if(emp.getEname()==null || emp.getEname().length()==0 || emp.getEname().isEmpty()){
                throw new Exception("Name can't be empty!!");
            }
            if(emp.getSalary()==0){
                throw new Exception("Salary Can't be 0");
            }
        emp.setEid(sequenceGeneratorService.generateSequence(Employee.SEQUENCE_NAME));
        repo.save(emp);
        return "Added Employee with id: " + emp.getEid();
    }
        catch (Exception e){
            return e.getMessage();
        }
    }

    @GetMapping("/getEmp")
    public List<Employee> getAllEmployee(){
        try {
            return repo.findAll();
        }
        catch (ApiRequestException a){
            throw new ApiRequestException("Oops cannot get all students with custom exception");
        }
    }

    @GetMapping("/getEmp/{eid}")
    public String getEmployee(@PathVariable int eid){
        try {
            if (repo.existsById(eid)) {
                return repo.findById(eid).toString();
            } else {
                return "Given ID is not presented in Database Records!!!";
            }
        }
        catch (ApiRequestException a){
            throw new ApiRequestException("Oops cannot get student with custom exception");
        }
    }

    @DeleteMapping("/deleteEmp/{eid}")
    public String deleteEmp(@PathVariable int eid){
        if(repo.existsById(eid)) {
            repo.deleteById(eid);
            return "Record deleted for Employee with id: " + eid;
        }
        else{
            return "Record for this Id is already deleted or does not exists!!";
        }
    }

    @PutMapping(path = "/updateEmp", consumes = { "application/json" })
    public String saveOrupdateEmployee(@RequestBody Employee emp) {
        try {
            if (emp.getEname() == null || emp.getEname().length() == 0 || emp.getEname().isEmpty()) {
                throw new Exception("Name can't be empty!!");
            }
            if (emp.getSalary() == 0) {
                throw new Exception("Salary Can't be 0");
            }
            repo.save(emp);
            return "Updated Details Successfully for Employee with id" + emp.getEid();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
}
