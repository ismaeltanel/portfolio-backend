package com.tanelismael.portfolio.controller;

import com.tanelismael.portfolio.entity.Project;
import com.tanelismael.portfolio.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/projects")
    public List<Project> getAllProjects(){
        return projectService.getAllProjects();
    }

    @GetMapping("/projects/category/{category}")
    public List<Project> getProjectsByCategory(@PathVariable String category) {
        return projectService.getProjectsByCategory(category);
    }


    @GetMapping("/projects/id/{id}")
    public Project getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id).orElseThrow();
    }
}
