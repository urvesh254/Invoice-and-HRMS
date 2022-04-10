package com.itaims.ihs.controller.rest;

import com.itaims.ihs.entity.Department;
import com.itaims.ihs.entity.Employee;
import com.itaims.ihs.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentRestController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> getAll() {
        return departmentService.getAll();
    }

    @GetMapping("/{id}")
    public Department get(@PathVariable("id") long id) {
        return departmentService.get(id);
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getEmployees(@PathVariable("id") long id) {
        return departmentService.get(id).getEmployees();
    }

    @PostMapping
    public long save(@RequestBody Department object) {
        departmentService.save(object);
        return object.getId();
    }

    @PutMapping
    public long update(@RequestBody Department object) {
        departmentService.update(object);
        return object.getId();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        departmentService.delete(id);
    }
}
