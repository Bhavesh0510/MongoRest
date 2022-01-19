package com.example.MongoRestAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepo repo;

    @PostMapping("/addEmp")
    public String saveEmp(@RequestBody Employee emp){
        repo.save(emp);
        return "Added Employee with id: " + emp.getEid();
    }

    @GetMapping("/getEmp")
    public List<Employee> getAllEmployee(){
        return repo.findAll();
    }

    @GetMapping("/getEmp/{eid}")
    public Optional<Employee> getEmployee(@PathVariable int eid){
        return repo.findById(eid);
    }

    @DeleteMapping("/deleteEmp/{eid}")
    public String deleteEmp(@PathVariable int eid){
        repo.deleteById(eid);
        return "Record deleted for Employee with id: " + eid;
    }

    @PutMapping(path = "/updateEmp", consumes = { "application/json" })
    public Employee saveOrupdateEmployee(@RequestBody Employee emp) {
        repo.save(emp);
        return emp;
    }
}
