package com.itaims.ihs.service;

import com.itaims.ihs.dao.DepartmentDao;
import com.itaims.ihs.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Transactional
    public List<Department> getAll() {
        return departmentDao.getAll();
    }


    @Transactional
    public Department get(long primaryKey) {
        return departmentDao.get(primaryKey);
    }


    @Transactional
    public void save(Department object) {
        departmentDao.save(object);
    }


    @Transactional
    public void update(Department object) {
        Department department = departmentDao.get(object.getId());
        department.setDepartmentName(object.getDepartmentName());
    }


    @Transactional
    public void delete(long primaryKey) {
        Department department = departmentDao.get(primaryKey);
        departmentDao.delete(department);
    }
}
