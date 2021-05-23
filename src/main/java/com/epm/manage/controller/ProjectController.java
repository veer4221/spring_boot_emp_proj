package com.epm.manage.controller;

import com.epm.manage.model.Project;
import com.epm.manage.repositories.ProjectRepositories;
import com.epm.manage.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ProjectRepositories projectRepositories;

    @PostMapping
    public ResponseEntity addProject(@RequestBody Project project){
        Project res = projectService.addProjectService(project);
        return ResponseEntity.ok(res);
    }
    @PutMapping(path = "/{projectId}")
    public ResponseEntity updateProject(@PathVariable("projectId") long projectId,@RequestBody Project project){
        Project res = projectService.updateProjectService(projectId,project);
        return ResponseEntity.ok(res);
    }
    @DeleteMapping(path = "/{projectId}")
    public String removeProject(@PathVariable("projectId") long projectId){

        return projectService.removeProject(projectId);

    }
    @GetMapping
    public ResponseEntity getProjects(){
        List res = projectService.getProject();
        return ResponseEntity.ok(res);
    }
    @GetMapping(path = "/{projectId}")
    public ResponseEntity getProjectById(@PathVariable("projectId") long projectId){
        List res = projectService.getProjectById(projectId);
        return ResponseEntity.ok(res);
    }
}
