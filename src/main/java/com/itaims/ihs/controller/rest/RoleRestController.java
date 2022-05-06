package com.itaims.ihs.controller.rest;

import com.itaims.ihs.entity.Permission;
import com.itaims.ihs.entity.Role;
import com.itaims.ihs.entity.User;
import com.itaims.ihs.service.RoleService;
import com.itaims.ihs.util.PermissionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleRestController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    @PreAuthorize("hasAuthority('" + PermissionType.ROLE_VIEW + "')")
    public List<Role> getAll() {
        return roleService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('" + PermissionType.ROLE_VIEW + "')")
    public Role get(@PathVariable("id") long id) {
        return roleService.get(id);
    }

    @GetMapping("/{id}/users")
    @PreAuthorize("hasAuthority('" + PermissionType.ROLE_VIEW + "')")
    public List<User> getUsers(@PathVariable("id") long id) {
        Role role = roleService.get(id);
        return role.getUsers();
    }

    @GetMapping("/{id}/permissions")
    @PreAuthorize("hasAuthority('" + PermissionType.ROLE_VIEW + "')")
    public List<Permission> getPermissions(@PathVariable("id") long id) {
        Role role = roleService.get(id);
        return role.getPermissions();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('" + PermissionType.ROLE_EDIT + "')")
    public long save(@RequestBody Role object) {
        roleService.save(object);
        System.out.println(object);
        return object.getId();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('" + PermissionType.ROLE_EDIT + "')")
    public long update(@RequestBody Role object) {
        System.out.println(object);
        roleService.update(object);
        return object.getId();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('" + PermissionType.ROLE_EDIT + "')")
    public void delete(@PathVariable("id") long id) {
        roleService.delete(id);
    }
}
