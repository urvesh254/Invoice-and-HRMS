package com.itaims.ihs.controller.rest;

import com.itaims.ihs.entity.Bill;
import com.itaims.ihs.entity.Vendor;
import com.itaims.ihs.service.VendorService;
import com.itaims.ihs.util.PermissionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendors")
public class VendorRestController {
    @Autowired
    private VendorService vendorService;

    @GetMapping
    @PreAuthorize("hasAuthority('" + PermissionType.VENDOR_VIEW + "')")
    public List<Vendor> getAll() {
        return vendorService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('" + PermissionType.VENDOR_VIEW + "')")
    public Vendor get(@PathVariable("id") long id) {
        return vendorService.get(id);
    }

    @GetMapping("/{id}/bills")
    @PreAuthorize("hasAuthority('" + PermissionType.VENDOR_VIEW + "')")
    public List<Bill> getProjects(@PathVariable("id") long id) {
        return vendorService.get(id).getBills();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('" + PermissionType.VENDOR_EDIT + "')")
    public long save(@RequestBody Vendor object) {
        System.out.println(object);
        vendorService.save(object);
        return object.getId();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('" + PermissionType.VENDOR_EDIT + "')")
    public long update(@RequestBody Vendor object) {
        vendorService.update(object);
        return object.getId();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('" + PermissionType.VENDOR_EDIT + "')")
    public void delete(@PathVariable("id") long id) {
        vendorService.delete(id);
    }
}
