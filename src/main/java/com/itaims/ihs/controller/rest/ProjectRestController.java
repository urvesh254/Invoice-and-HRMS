package com.itaims.ihs.controller.rest;

import com.itaims.ihs.entity.Employee;
import com.itaims.ihs.entity.Milestone;
import com.itaims.ihs.entity.Project;
import com.itaims.ihs.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectRestController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<Project> getAll() {
        return projectService.getAll();
    }

    @GetMapping("/{id}")
    public Project get(@PathVariable("id") long id) {
        return projectService.get(id);
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getUsers(@PathVariable("id") long id) {
        Project project = projectService.get(id);
        return project.getAssignedEmployees();
    }

    @GetMapping("/{id}/milestones")
    public List<Milestone> getPermissions(@PathVariable("id") long id) {
        Project project = projectService.get(id);
        return project.getMilestones();
    }

    @PostMapping
    public long save(@RequestBody Project object) {
        projectService.save(object);
        System.out.println(object);
        return object.getId();
    }

    @PutMapping
    public long update(@RequestBody Project object) {
        System.out.println(object);
        projectService.update(object);
        return object.getId();
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        projectService.delete(id);
    }
}
