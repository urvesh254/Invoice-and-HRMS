package com.itaims.ihs.controller.rest;

import com.itaims.ihs.entity.Expense;
import com.itaims.ihs.service.ExpenseService;
import com.itaims.ihs.util.PermissionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseRestController {
    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    @PreAuthorize("hasAuthority('" + PermissionType.EXPENSE_VIEW + "')")
    public List<Expense> getAll() {
        return expenseService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('" + PermissionType.EXPENSE_VIEW + "')")
    public Expense get(@PathVariable("id") long id) {
        return expenseService.get(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('" + PermissionType.EXPENSE_EDIT + "')")
    public long save(@RequestBody Expense object) {
        expenseService.save(object);
        return object.getId();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('" + PermissionType.EXPENSE_EDIT + "')")
    public long update(@RequestBody Expense object) {
        expenseService.update(object);
        return object.getId();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('" + PermissionType.EXPENSE_EDIT + "')")
    public void delete(@PathVariable("id") long id) {
        expenseService.delete(id);
    }
}
