package com.itaims.ihs.controller.rest;

import com.itaims.ihs.entity.Option;
import com.itaims.ihs.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/options")
public class OptionRestController {
    @Autowired
    private OptionService optionService;

    @GetMapping
    public List<Option> getAll() {
        return optionService.getAll();
    }

    @GetMapping("/{id}")
    public Option get(@PathVariable("id") long id) {
        return optionService.get(id);
    }

    @PostMapping
    public long save(@RequestBody Option object) {
        optionService.save(object);
        return object.getId();
    }

    @PutMapping
    public long update(@RequestBody Option object) {
        optionService.update(object);
        return object.getId();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        optionService.delete(id);
    }
}
