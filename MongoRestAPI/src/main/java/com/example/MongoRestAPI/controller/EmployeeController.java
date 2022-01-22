package com.example.MongoRestAPI.controller;

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
    public String saveEmp(@RequestBody Employee emp){
        emp.setEid(sequenceGeneratorService.generateSequence(Employee.SEQUENCE_NAME));
        repo.save(emp);
        return "Added Employee with id: " + emp.getEid();
    }

    @GetMapping("/getEmp")
    public List<Employee> getAllEmployee(){
        return repo.findAll();
    }

    @GetMapping("/getEmp/{eid}")
    public String getEmployee(@PathVariable int eid){
        if(repo.existsById(eid)){
            return repo.findById(eid).toString();
        }
        else{
            return "Given ID is not presented in Database Records!!!";
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
    public Employee saveOrupdateEmployee(@RequestBody Employee emp) {
        repo.save(emp);
        return emp;
    }
}