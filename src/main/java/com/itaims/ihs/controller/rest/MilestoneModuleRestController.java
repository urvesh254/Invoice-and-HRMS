package com.itaims.ihs.controller.rest;

import com.itaims.ihs.entity.MilestoneModule;
import com.itaims.ihs.service.MilestoneModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/milestone-modules")
public class MilestoneModuleRestController {
    @Autowired
    private MilestoneModuleService milestoneModuleService;

    @GetMapping
    public List<MilestoneModule> getAll() {
        return milestoneModuleService.getAll();
    }

    @GetMapping("/{id}")
    public MilestoneModule get(@PathVariable("id") long id) {
        return milestoneModuleService.get(id);
    }

    @PostMapping
    public long save(@RequestBody MilestoneModule object) {
        milestoneModuleService.save(object);
        return object.getId();
    }

    @PutMapping
    public long update(@RequestBody MilestoneModule object) {
        milestoneModuleService.update(object);
        return object.getId();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        milestoneModuleService.delete(id);
    }
}
