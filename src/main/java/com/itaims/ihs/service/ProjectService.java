package com.itaims.ihs.service;

import com.itaims.ihs.dao.CustomerDao;
import com.itaims.ihs.dao.EmployeeDao;
import com.itaims.ihs.dao.ProjectDao;
import com.itaims.ihs.entity.Customer;
import com.itaims.ihs.entity.Employee;
import com.itaims.ihs.entity.Milestone;
import com.itaims.ihs.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private EmployeeDao employeeDao;


    @Transactional
    public List<Project> getAll() {
        return projectDao.getAll();
    }


    @Transactional
    public Project get(long primaryKey) {
        return projectDao.get(primaryKey);
    }

    @Transactional
    public void save(Project object) {
        setEmployeesToProject(object, object.getAssignedEmployees());
        Customer customer = customerDao.get(object.getCustomer().getId());
        customer.getProjects().add(object);
    }

    @Transactional
    public void update(Project object) {
        setEmployeesToProject(object, object.getAssignedEmployees());
        projectDao.update(object);
    }

    @Transactional
    public void delete(long primaryKey) {
        Project project = projectDao.get(primaryKey);
        projectDao.delete(project);
    }


    private void setEmployeesToProject(Project project, List<Employee> theEmployees) {
        List<Employee> employees = new ArrayList<>();
        if (theEmployees == null) return;

        for (int i = 0; i < theEmployees.size(); i++) {
            employees.add(i, employeeDao.get(theEmployees.get(i).getId()));
        }
        project.setAssignedEmployees(employees);
    }
}
