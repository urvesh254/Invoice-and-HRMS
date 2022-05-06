package com.itaims.ihs.controller.rest;

import com.itaims.ihs.entity.Customer;
import com.itaims.ihs.entity.Invoice;
import com.itaims.ihs.entity.Project;
import com.itaims.ihs.service.CustomerService;
import com.itaims.ihs.util.PermissionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    @PreAuthorize("hasAuthority('" + PermissionType.CUSTOMER_VIEW + "')")
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('" + PermissionType.CUSTOMER_VIEW + "')")
    public Customer get(@PathVariable("id") long id) {
        return customerService.get(id);
    }

    @GetMapping("/{id}/projects")
    @PreAuthorize("hasAuthority('" + PermissionType.CUSTOMER_VIEW + "')")
    public List<Project> getUsers(@PathVariable("id") long id) {
        Customer customer = customerService.get(id);
        return customer.getProjects();
    }

    @GetMapping("/{id}/invoices")
    @PreAuthorize("hasAuthority('" + PermissionType.CUSTOMER_VIEW + "')")
    public List<Invoice> getPermissions(@PathVariable("id") long id) {
        Customer customer = customerService.get(id);
        return customer.getInvoices();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('" + PermissionType.CUSTOMER_EDIT + "')")
    public long save(@RequestBody Customer object) {
        customerService.save(object);
        System.out.println(object);
        return object.getId();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('" + PermissionType.CUSTOMER_EDIT + "')")
    public long update(@RequestBody Customer object) {
        System.out.println(object);
        customerService.update(object);
        return object.getId();
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('" + PermissionType.CUSTOMER_EDIT + "')")
    public void delete(@PathVariable("id") long id) {
        customerService.delete(id);
    }
}
