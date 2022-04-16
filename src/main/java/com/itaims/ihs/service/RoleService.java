package com.itaims.ihs.service;

import com.itaims.ihs.dao.PermissionDao;
import com.itaims.ihs.dao.RoleDao;
import com.itaims.ihs.entity.Permission;
import com.itaims.ihs.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    private PermissionDao permissionDao;

    @Autowired
    private RoleDao roleDao;


    @Transactional
    public List<Role> getAll() {
        return roleDao.getAll();
    }


    @Transactional
    public Role get(long primaryKey) {
        return roleDao.get(primaryKey);
    }


    @Transactional
    public void save(Role object) {
        setPermissionsToRole(object, object.getPermissions());
        roleDao.save(object);
    }

    @Transactional
    public void update(Role object) {
        Role role = roleDao.get(object.getId());
        object.setUsers(role.getUsers());
        setPermissionsToRole(object, object.getPermissions());
        roleDao.update(object);
    }


    @Transactional
    public void delete(long primaryKey) {
        Role role = roleDao.get(primaryKey);
        roleDao.delete(role);
    }

    private void setPermissionsToRole(Role role, List<Permission> thePermissions) {
        System.out.println(">>>>>>>>>>>>>>In setPermissionsToRole function " + thePermissions);
        List<Permission> permissions = new ArrayList<>();
        if (thePermissions == null) return;

        for (Permission thePermission : thePermissions) {
            permissions.add(permissionDao.get(thePermission.getId()));
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>" + permissions);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>" + role);
        role.setPermissions(permissions);
    }
}
