package com.itaims.ihs.service;

import com.itaims.ihs.dao.UserDao;
import com.itaims.ihs.entity.Role;
import com.itaims.ihs.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private RoleService roleService;

    @Autowired
    private UserDao userDao;


    @Transactional
    public List<User> getAll() {
        return userDao.getAll();
    }


    @Transactional
    public User get(long primaryKey) {
        return userDao.get(primaryKey);
    }

    @Transactional
    public User getByEmail(String email) {
        return userDao.getByEmail(email);
    }

    @Transactional
    public void save(User object) {
        Role role = roleService.get(object.getRole().getId());
        object.setRole(role);
        role.getUsers().add(object);
    }


    @Transactional
    public void update(User object) {
        userDao.update(object);
    }


    @Transactional
    public void delete(long primaryKey) {
        User user = userDao.get(primaryKey);
        Role role = user.getRole();
        role.getUsers().remove(user);
    }
}
