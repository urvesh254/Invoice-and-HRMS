package com.itaims.ihs.controller.rest;

import com.itaims.ihs.entity.Permission;
import com.itaims.ihs.service.PermissionService;
import com.itaims.ihs.util.PermissionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissions")
public class PermissionRestController {
    @Autowired
    private PermissionService permissionService;

    @GetMapping
    @PreAuthorize("hasAuthority('" + PermissionType.PERMISSION_VIEW + "')")
    public List<Permission> getAll() {
        return permissionService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('" + PermissionType.PERMISSION_VIEW + "')")
    public Permission get(@PathVariable("id") long id) {
        return permissionService.get(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('" + PermissionType.PERMISSION_EDIT + "')")
    public long save(@RequestBody Permission object) {
        permissionService.save(object);
        return object.getId();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('" + PermissionType.PERMISSION_EDIT + "')")
    public long update(@RequestBody Permission object) {
        permissionService.update(object);
        return object.getId();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('" + PermissionType.PERMISSION_EDIT + "')")
    public void delete(@PathVariable("id") long id) {
        permissionService.delete(id);
    }
}
