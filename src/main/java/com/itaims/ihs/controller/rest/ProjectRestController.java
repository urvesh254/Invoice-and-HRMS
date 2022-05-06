package com.itaims.ihs.controller.rest;

import com.itaims.ihs.entity.Employee;
import com.itaims.ihs.entity.Invoice;
import com.itaims.ihs.entity.Milestone;
import com.itaims.ihs.entity.Project;
import com.itaims.ihs.service.ProjectService;
import com.itaims.ihs.util.PermissionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectRestController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    @PreAuthorize("hasAuthority('" + PermissionType.PROJECT_VIEW + "')")
    public List<Project> getAll() {
        return projectService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('" + PermissionType.PROJECT_VIEW + "')")
    public Project get(@PathVariable("id") long id) {
        return projectService.get(id);
    }

    @GetMapping("/{id}/employees")
    @PreAuthorize("hasAuthority('" + PermissionType.PROJECT_VIEW + "')")
    public List<Employee> getUsers(@PathVariable("id") long id) {
        Project project = projectService.get(id);
        return project.getAssignedEmployees();
    }

    @GetMapping("/{id}/milestones")
    @PreAuthorize("hasAuthority('" + PermissionType.PROJECT_VIEW + "')")
    public List<Milestone> getMilestones(@PathVariable("id") long id) {
        Project project = projectService.get(id);
        return project.getMilestones();
    }

    @GetMapping("/{id}/invoices")
    @PreAuthorize("hasAuthority('" + PermissionType.PROJECT_VIEW + "')")
    public List<Invoice> getInvoices(@PathVariable("id") long id) {
        Project project = projectService.get(id);
        return project.getInvoices();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('" + PermissionType.PROJECT_EDIT + "')")
    public long save(@RequestBody Project object) {
        projectService.save(object);
        System.out.println(object);
        return object.getId();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('" + PermissionType.PROJECT_EDIT + "')")
    public long update(@RequestBody Project object) {
        System.out.println(object);
        projectService.update(object);
        return object.getId();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('" + PermissionType.PROJECT_EDIT + "')")
    public void delete(@PathVariable("id") long id) {
        projectService.delete(id);
    }
}
