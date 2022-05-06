package com.itaims.ihs.controller.rest;

import com.itaims.ihs.entity.Employee;
import com.itaims.ihs.entity.Project;
import com.itaims.ihs.service.EmployeeService;
import com.itaims.ihs.util.PermissionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    @PreAuthorize("hasAuthority('" + PermissionType.EMPLOYEE_VIEW + "')")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('" + PermissionType.EMPLOYEE_VIEW + "')")
    public Employee get(@PathVariable("id") long id) {
        return employeeService.get(id);
    }

    @GetMapping("/{id}/projects")
    @PreAuthorize("hasAuthority('" + PermissionType.EMPLOYEE_VIEW + "')")
    public List<Project> getProjects(@PathVariable("id") long id) {
        return employeeService.get(id).getProjects();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('" + PermissionType.EMPLOYEE_EDIT + "')")
    public long save(@RequestBody Employee object) {
        System.out.println(object);
        employeeService.save(object);
        return object.getId();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('" + PermissionType.EMPLOYEE_EDIT + "')")
    public long update(@RequestBody Employee object) {
        employeeService.update(object);
        return object.getId();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('" + PermissionType.EMPLOYEE_EDIT + "')")
    public void delete(@PathVariable("id") long id) {
        employeeService.delete(id);
    }
}
