package com.itaims.ihs.controller.rest;

import com.itaims.ihs.entity.Permission;
import com.itaims.ihs.entity.Role;
import com.itaims.ihs.entity.User;
import com.itaims.ihs.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleRestController {

    @Autowired
    private RoleService roleService;


    @GetMapping
    public List<Role> getAll() {
        return roleService.getAll();
    }

    @GetMapping("/{id}")
    public Role get(@PathVariable("id") long id) {
        return roleService.get(id);
    }

    @GetMapping("/{id}/users")
    public List<User> getUsers(@PathVariable("id") long id) {
        Role role = roleService.get(id);
        return role.getUsers();
    }

    @GetMapping("/{id}/permissions")
    public List<Permission> getPermissions(@PathVariable("id") long id) {
        Role role = roleService.get(id);
        return role.getPermissions();
    }

    @PostMapping
    public long save(@RequestBody Role object) {
        roleService.save(object);
        System.out.println(object);
        return object.getId();
    }

    @PutMapping
    public long update(@RequestBody Role object) {
        System.out.println(object);
        roleService.update(object);
        return object.getId();
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        roleService.delete(id);
    }
}
