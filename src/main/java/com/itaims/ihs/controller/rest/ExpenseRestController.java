package com.itaims.ihs.controller.rest;

import com.itaims.ihs.entity.Expense;
import com.itaims.ihs.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseRestController {
    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public List<Expense> getAll() {
        return expenseService.getAll();
    }

    @GetMapping("/{id}")
    public Expense get(@PathVariable("id") long id) {
        return expenseService.get(id);
    }

    @PostMapping
    public long save(@RequestBody Expense object) {
        expenseService.save(object);
        return object.getId();
    }

    @PutMapping
    public long update(@RequestBody Expense object) {
        expenseService.update(object);
        return object.getId();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        expenseService.delete(id);
    }
}
