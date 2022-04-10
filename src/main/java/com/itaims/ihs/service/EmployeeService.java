package com.itaims.ihs.service;

import com.itaims.ihs.dao.DepartmentDao;
import com.itaims.ihs.dao.EmployeeDao;
import com.itaims.ihs.entity.Department;
import com.itaims.ihs.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Transactional
    public List<Employee> getAll() {
        return employeeDao.getAll();
    }


    @Transactional
    public Employee get(long primaryKey) {
        return employeeDao.get(primaryKey);
    }


    @Transactional
    public void save(Employee object) {
        Department department = departmentDao.get(object.getDepartment().getId());
        object.setDepartment(department);
        System.out.println(">>>>>>>>>>>>>>>>>>" + department.getDepartmentName() + " " + department.getId());
        System.out.println(department.getEmployees());
        department.getEmployees().add(object);
    }


    @Transactional
    public void update(Employee object) {
        employeeDao.update(object);
    }


    @Transactional
    public void delete(long primaryKey) {
        Employee employee = employeeDao.get(primaryKey);
        Department department = employee.getDepartment();
        department.getEmployees().remove(employee);
    }
}
