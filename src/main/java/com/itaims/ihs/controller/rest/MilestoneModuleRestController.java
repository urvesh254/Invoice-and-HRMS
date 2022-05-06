package com.itaims.ihs.controller.rest;

import com.itaims.ihs.entity.MilestoneModule;
import com.itaims.ihs.service.MilestoneModuleService;
import com.itaims.ihs.util.PermissionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/milestone-modules")
public class MilestoneModuleRestController {
    @Autowired
    private MilestoneModuleService milestoneModuleService;

    @GetMapping
    @PreAuthorize("hasAuthority('" + PermissionType.MILESTONE_MODULE_VIEW + "')")
    public List<MilestoneModule> getAll() {
        return milestoneModuleService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('" + PermissionType.MILESTONE_MODULE_VIEW + "')")
    public MilestoneModule get(@PathVariable("id") long id) {
        return milestoneModuleService.get(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('" + PermissionType.MILESTONE_MODULE_EDIT + "')")
    public long save(@RequestBody MilestoneModule object) {
        milestoneModuleService.save(object);
        return object.getId();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('" + PermissionType.MILESTONE_MODULE_EDIT + "')")
    public long update(@RequestBody MilestoneModule object) {
        milestoneModuleService.update(object);
        return object.getId();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('" + PermissionType.MILESTONE_MODULE_EDIT + "')")
    public void delete(@PathVariable("id") long id) {
        milestoneModuleService.delete(id);
    }
}
