package com.itaims.ihs.controller.rest;

import com.itaims.ihs.entity.Bill;
import com.itaims.ihs.entity.Vendor;
import com.itaims.ihs.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendors")
public class VendorRestController {
    @Autowired
    private VendorService vendorService;

    @GetMapping
    public List<Vendor> getAll() {
        return vendorService.getAll();
    }

    @GetMapping("/{id}")
    public Vendor get(@PathVariable("id") long id) {
        return vendorService.get(id);
    }

    @GetMapping("/{id}/bills")
    public List<Bill> getProjects(@PathVariable("id") long id) {
        return vendorService.get(id).getBills();
    }

    @PostMapping
    public long save(@RequestBody Vendor object) {
        System.out.println(object);
        vendorService.save(object);
        return object.getId();
    }

    @PutMapping
    public long update(@RequestBody Vendor object) {
        vendorService.update(object);
        return object.getId();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        vendorService.delete(id);
    }
}
