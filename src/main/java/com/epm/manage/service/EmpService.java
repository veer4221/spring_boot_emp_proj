package com.epm.manage.service;

import com.epm.manage.model.Emp;
import com.epm.manage.model.Project;
import com.epm.manage.repositories.EmpRepositories;
import com.epm.manage.repositories.ProjectRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class EmpService {
    @Autowired
    private EmpRepositories empRepositories;

    public Emp addEmpService(Emp emp){
        return empRepositories.save(emp);
    }

    public List getEmp() {
        return  empRepositories.findAll();
    }

    public List getEmpById( long empId) {
        boolean exists = empRepositories.existsById(empId);
        if(!exists){
            throw new IllegalStateException("not found emp");
        }
        return empRepositories.findAllById(Collections.singleton(empId));
    }

    @Transactional
    public Emp updateEmpService(long empId, Emp emp) {
        boolean exists = empRepositories.existsById(empId);
        if(!exists){
            throw new IllegalStateException("not found emp");
        }
        emp.setId(empId);
        return empRepositories.save(emp);
    }

    public String removeEmp(long empId) {
        boolean exists = empRepositories.existsById(empId);
        if(!exists){
            throw new IllegalStateException("not found emp");
        }
        empRepositories.deleteAllById(Collections.singleton(empId));
        return "record Deleted";
    }

}
