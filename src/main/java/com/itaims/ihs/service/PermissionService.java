package com.itaims.ihs.service;

import com.itaims.ihs.dao.PermissionDao;
import com.itaims.ihs.entity.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Transactional
    public List<Permission> getAll() {
        return permissionDao.getAll();
    }


    @Transactional
    public Permission get(long primaryKey) {
        return permissionDao.get(primaryKey);
    }


    @Transactional
    public void save(Permission object) {
        permissionDao.save(object);
    }


    @Transactional
    public void update(Permission object) {
        permissionDao.update(object);
    }


    @Transactional
    public void delete(long primaryKey) {
        Permission permission = this.get(primaryKey);
        permissionDao.delete(permission);
    }
}
