package com.itaims.ihs.controller.rest;

import com.itaims.ihs.entity.User;
import com.itaims.ihs.service.UserService;
import com.itaims.ihs.util.PermissionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    @PreAuthorize("hasAuthority('" + PermissionType.USER_VIEW + "')")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('" + PermissionType.USER_VIEW + "')")
    public User get(@PathVariable("id") long id) {
        return userService.get(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('" + PermissionType.USER_EDIT + "')")
    public long save(@RequestBody User object) {
        System.out.println(object);
        object.setPassword(passwordEncoder.encode(object.getPassword()));
        userService.save(object);
        return object.getId();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('" + PermissionType.USER_EDIT + "')")
    public long update(@RequestBody User object) {
        object.setPassword(passwordEncoder.encode(object.getPassword()));
        userService.update(object);
        return object.getId();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('" + PermissionType.USER_EDIT + "')")
    public void delete(@PathVariable("id") long id) {
        userService.delete(id);
    }
}
