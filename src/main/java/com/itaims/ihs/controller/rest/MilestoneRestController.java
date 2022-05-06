package com.itaims.ihs.controller.rest;

import com.itaims.ihs.entity.Milestone;
import com.itaims.ihs.entity.MilestoneModule;
import com.itaims.ihs.service.MilestoneService;
import com.itaims.ihs.util.PermissionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/milestones")
public class MilestoneRestController {
    @Autowired
    private MilestoneService milestoneService;

    @GetMapping
    @PreAuthorize("hasAuthority('" + PermissionType.MILESTONE_VIEW + "')")
    public List<Milestone> getAll() {
        return milestoneService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('" + PermissionType.MILESTONE_VIEW + "')")
    public Milestone get(@PathVariable("id") long id) {
        return milestoneService.get(id);
    }

    @GetMapping("/{id}/milestone-modules")
    @PreAuthorize("hasAuthority('" + PermissionType.MILESTONE_VIEW + "')")
    public List<MilestoneModule> getProjects(@PathVariable("id") long id) {
        return milestoneService.get(id).getMilestoneModules();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('" + PermissionType.MILESTONE_EDIT + "')")
    public long save(@RequestBody Milestone object) {
        System.out.println(object);
        milestoneService.save(object);
        return object.getId();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('" + PermissionType.MILESTONE_EDIT + "')")
    public long update(@RequestBody Milestone object) {
        milestoneService.update(object);
        return object.getId();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('" + PermissionType.MILESTONE_EDIT + "')")
    public void delete(@PathVariable("id") long id) {
        milestoneService.delete(id);
    }
}
