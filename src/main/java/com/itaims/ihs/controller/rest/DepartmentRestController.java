package com.itaims.ihs.controller.rest;

import com.itaims.ihs.entity.Department;
import com.itaims.ihs.entity.Employee;
import com.itaims.ihs.service.DepartmentService;
import com.itaims.ihs.util.PermissionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentRestController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    @PreAuthorize("hasAuthority('" + PermissionType.DEPARTMENT_VIEW + "')")
    public List<Department> getAll() {
        return departmentService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('" + PermissionType.DEPARTMENT_VIEW + "')")
    public Department get(@PathVariable("id") long id) {
        return departmentService.get(id);
    }

    @GetMapping("/{id}/employees")
    @PreAuthorize("hasAuthority('" + PermissionType.DEPARTMENT_VIEW + "')")
    public List<Employee> getEmployees(@PathVariable("id") long id) {
        return departmentService.get(id).getEmployees();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('" + PermissionType.DEPARTMENT_EDIT + "')")
    public long save(@RequestBody Department object) {
        departmentService.save(object);
        return object.getId();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('" + PermissionType.DEPARTMENT_EDIT + "')")
    public long update(@RequestBody Department object) {
        departmentService.update(object);
        return object.getId();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('" + PermissionType.DEPARTMENT_EDIT + "')")
    public void delete(@PathVariable("id") long id) {
        departmentService.delete(id);
    }
}
