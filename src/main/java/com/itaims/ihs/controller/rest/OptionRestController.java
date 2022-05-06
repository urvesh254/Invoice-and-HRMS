package com.itaims.ihs.controller.rest;

import com.itaims.ihs.entity.Option;
import com.itaims.ihs.service.OptionService;
import com.itaims.ihs.util.PermissionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/options")
public class OptionRestController {
    @Autowired
    private OptionService optionService;

    @GetMapping
    @PreAuthorize("hasAuthority('" + PermissionType.OPTION_VIEW + "')")
    public List<Option> getAll() {
        return optionService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('" + PermissionType.OPTION_VIEW + "')")
    public Option get(@PathVariable("id") long id) {
        return optionService.get(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('" + PermissionType.OPTION_EDIT + "')")
    public long save(@RequestBody Option object) {
        optionService.save(object);
        return object.getId();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('" + PermissionType.OPTION_EDIT + "')")
    public long update(@RequestBody Option object) {
        optionService.update(object);
        return object.getId();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('" + PermissionType.OPTION_EDIT + "')")
    public void delete(@PathVariable("id") long id) {
        optionService.delete(id);
    }
}
