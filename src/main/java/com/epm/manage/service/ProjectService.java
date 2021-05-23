package com.epm.manage.service;

import com.epm.manage.repositories.ProjectRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.epm.manage.model.Project;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepositories projectRepositories;
    public Project addProjectService(Project project){
       return projectRepositories.save(project);
    }

    public List getProject() {
        return  projectRepositories.findAll();
    }

    public List getProjectById( long projectId) {
        boolean exists = projectRepositories.existsById(projectId);
        if(!exists){
            throw new IllegalStateException("not found project");
        }
        return projectRepositories.findAllById(Collections.singleton(projectId));
    }

    @Transactional
    public Project updateProjectService(long projectId, Project project) {
        boolean exists = projectRepositories.existsById(projectId);
        if(!exists){
            throw new IllegalStateException("not found project");
        }
        project.setId(projectId);
        return projectRepositories.save(project);
    }

    public String removeProject(long projectId) {
        boolean exists = projectRepositories.existsById(projectId);
        if(!exists){
            throw new IllegalStateException("not found project");
        }
        projectRepositories.deleteAllById(Collections.singleton(projectId));
        return "record Deleted";
    }
}
