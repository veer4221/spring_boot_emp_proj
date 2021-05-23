package com.epm.manage.controller;

import com.epm.manage.model.Emp;
import com.epm.manage.model.Project;
import com.epm.manage.model.Req;
import com.epm.manage.repositories.EmpRepositories;
import com.epm.manage.repositories.ProjectRepositories;
import com.epm.manage.service.EmpService;
import com.epm.manage.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "api/v1/emp")
public class EmpController {
    @Autowired
    private EmpService empService;
    @Autowired
    private EmpRepositories empRepositories;

    @PostMapping
    public ResponseEntity addEmp(@RequestBody Emp emp){
        Emp res = empService.addEmpService(emp);
        return ResponseEntity.ok(res);
    }
    @RequestMapping(value = "/assign", method = RequestMethod.POST)
    public String projectAssign(@RequestBody Req req){
        System.out.println(req);

        return empService.assignProject(req);

    }
    @PutMapping(path = "/{empId}")
    public ResponseEntity updateEmp(@PathVariable("empId") long empId, @RequestBody Emp emp){
        Emp res = empService.updateEmpService(empId,emp);
        return ResponseEntity.ok(res);
    }
    @DeleteMapping(path = "/{empId}")
    public String removeEmp(@PathVariable("empId") long empId){

        return empService.removeEmp(empId);

    }
    @GetMapping
    public ResponseEntity getEmps(){
        List res = empService.getEmp();
        return ResponseEntity.ok(res);
    }
    @GetMapping(path = "/{empId}")
    public ResponseEntity getEmpById(@PathVariable("empId") long empId){
        List res = empService.getEmpById(empId);
        return ResponseEntity.ok(res);
    }
}
