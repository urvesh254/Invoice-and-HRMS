package com.itaims.ihs.controller.rest;

import com.itaims.ihs.entity.Service;
import com.itaims.ihs.service.ServiceEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceRestController {
    @Autowired
    private ServiceEntityService serviceEntityService;

    @GetMapping
    public List<Service> getAll() {
        return serviceEntityService.getAll();
    }

    @GetMapping("/{id}")
    public Service get(@PathVariable("id") long id) {
        return serviceEntityService.get(id);
    }

    @PostMapping
    public long save(@RequestBody Service object) {
        serviceEntityService.save(object);
        return object.getId();
    }

    @PutMapping
    public long update(@RequestBody Service object) {
        serviceEntityService.update(object);
        return object.getId();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        serviceEntityService.delete(id);
    }
}
