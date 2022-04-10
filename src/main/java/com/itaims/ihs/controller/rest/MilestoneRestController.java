package com.itaims.ihs.controller.rest;

import com.itaims.ihs.entity.Milestone;
import com.itaims.ihs.entity.MilestoneModule;
import com.itaims.ihs.entity.Project;
import com.itaims.ihs.service.MilestoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/milestones")
public class MilestoneRestController {
    @Autowired
    private MilestoneService milestoneService;

    @GetMapping
    public List<Milestone> getAll() {
        return milestoneService.getAll();
    }

    @GetMapping("/{id}")
    public Milestone get(@PathVariable("id") long id) {
        return milestoneService.get(id);
    }

    @GetMapping("/{id}/milestone-modules")
    public List<MilestoneModule> getProjects(@PathVariable("id") long id) {
        return milestoneService.get(id).getMilestoneModules();
    }

    @PostMapping
    public long save(@RequestBody Milestone object) {
        System.out.println(object);
        milestoneService.save(object);
        return object.getId();
    }

    @PutMapping
    public long update(@RequestBody Milestone object) {
        milestoneService.update(object);
        return object.getId();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        milestoneService.delete(id);
    }
}
