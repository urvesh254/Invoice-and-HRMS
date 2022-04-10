package com.itaims.ihs.controller.rest;

import com.itaims.ihs.entity.Permission;
import com.itaims.ihs.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissions")
public class PermissionRestController {
    @Autowired
    private PermissionService permissionService;

    @GetMapping
    public List<Permission> getAll() {
        return permissionService.getAll();
    }

    @GetMapping("/{id}")
    public Permission get(@PathVariable("id") long id) {
        return permissionService.get(id);
    }

    @PostMapping
    public long save(@RequestBody Permission object) {
        permissionService.save(object);
        return object.getId();
    }

    @PutMapping
    public long update(@RequestBody Permission object) {
        permissionService.update(object);
        return object.getId();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        permissionService.delete(id);
    }
}
