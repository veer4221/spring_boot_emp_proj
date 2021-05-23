package com.epm.manage.service;

import com.epm.manage.model.Emp;
import com.epm.manage.model.Project;
import com.epm.manage.model.Req;
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
    @Autowired
    private ProjectRepositories projectRepositories;

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

    public String assignProject(Req req) {
//        System.out.println(req.getEmp_id());
//        System.out.println(req.getProject_id());
        Project project = projectRepositories.getById(req.getProject_id());
        Emp emp = empRepositories.getById(req.getEmp_id());

        emp.getProjects().add(project);

        empRepositories.save(emp);
        return "ok";


    }
}
