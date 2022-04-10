package com.itaims.ihs.controller.rest;

import com.itaims.ihs.entity.User;
import com.itaims.ihs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User get(@PathVariable("id") long id) {
        return userService.get(id);
    }

    @PostMapping
    public long save(@RequestBody User object) {
        System.out.println(object);
        userService.save(object);
        return object.getId();
    }

    @PutMapping
    public long update(@RequestBody User object) {
        userService.update(object);
        return object.getId();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        userService.delete(id);
    }
}