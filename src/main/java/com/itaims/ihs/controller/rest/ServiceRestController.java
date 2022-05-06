package com.itaims.ihs.controller.rest;

import com.itaims.ihs.entity.Service;
import com.itaims.ihs.service.ServiceEntityService;
import com.itaims.ihs.util.PermissionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceRestController {
    @Autowired
    private ServiceEntityService serviceEntityService;

    @GetMapping
    @PreAuthorize("hasAuthority('" + PermissionType.SERVICE_VIEW + "')")
    public List<Service> getAll() {
        return serviceEntityService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('" + PermissionType.SERVICE_VIEW + "')")
    public Service get(@PathVariable("id") long id) {
        return serviceEntityService.get(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('" + PermissionType.SERVICE_EDIT + "')")
    public long save(@RequestBody Service object) {
        serviceEntityService.save(object);
        return object.getId();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('" + PermissionType.SERVICE_EDIT + "')")
    public long update(@RequestBody Service object) {
        serviceEntityService.update(object);
        return object.getId();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('" + PermissionType.SERVICE_EDIT + "')")
    public void delete(@PathVariable("id") long id) {
        serviceEntityService.delete(id);
    }
}
