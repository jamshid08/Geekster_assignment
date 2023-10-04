package com.geekster.mapping.controller;

import com.geekster.mapping.model.Address;
import com.geekster.mapping.model.Emp;
import com.geekster.mapping.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpController {

    @Autowired
    EmpService empService;

    @GetMapping("emps")
    public List<Emp> getEmployees()
    {
        return empService.getEmployees();
    }

    @GetMapping("emp/id/{id}")
    public Emp getEmployeeById(@PathVariable Long id)
    {
        return empService.getEmployeeById(id);
    }


    @PostMapping("emp")
    public String addEmp(@RequestBody Emp newEmp)
    {
        return empService.saveEmp(newEmp);
    }

    @DeleteMapping("emp/id/{id}")
        public String deleteEmpById(@PathVariable Long id){
        return empService.deleteEmpById(id);
    }


    @PutMapping("emp/id/{id}")
    public String updateEmp(@PathVariable Long id, @RequestBody Emp updateEmp)
    {
        return empService.updateEmp(id,updateEmp);
    }

}
