package com.geekster.mapping.service;


import com.geekster.mapping.model.Emp;
import com.geekster.mapping.repo.IEmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {


    @Autowired
    IEmpRepo empRepo;

    public List<Emp> getEmployees() {
        return empRepo.findAll();
    }

    public String saveEmp(Emp newEmp) {
        empRepo.save(newEmp);
        return "emp added";
    }

    public Emp getEmployeeById( long id) {
        Emp employee = empRepo.findById(id).orElseThrow();
        return employee;
    }

    public String deleteEmpById(Long id) {
        Emp employee = empRepo.findById(id).orElseThrow();
        empRepo.delete(employee);
        return "emp deleted";
    }

    public String updateEmp(Long id, Emp updateEmp) {
        Emp employee = empRepo.findById(id).orElseThrow();
        empRepo.save(updateEmp);
        return "emp updated";
    }
}
