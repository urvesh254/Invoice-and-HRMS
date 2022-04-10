package com.itaims.ihs.controller.rest;

import com.itaims.ihs.entity.Employee;
import com.itaims.ihs.entity.Project;
import com.itaims.ihs.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Employee get(@PathVariable("id") long id) {
        return employeeService.get(id);
    }

    @GetMapping("/{id}/projects")
    public List<Project> getProjects(@PathVariable("id") long id) {
        return employeeService.get(id).getProjects();
    }

    @PostMapping
    public long save(@RequestBody Employee object) {
        System.out.println(object);
        employeeService.save(object);
        return object.getId();
    }

    @PutMapping
    public long update(@RequestBody Employee object) {
        employeeService.update(object);
        return object.getId();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        employeeService.delete(id);
    }
}
