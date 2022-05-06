package com.itaims.ihs.controller.rest;

import com.itaims.ihs.entity.BillDetail;
import com.itaims.ihs.service.BillDetailService;
import com.itaims.ihs.util.PermissionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bill-details")
public class BillDetailRestController {
    @Autowired
    private BillDetailService billDetailService;

    @GetMapping
    @PreAuthorize("hasAuthority('" + PermissionType.BILL_DETAIL_VIEW + "')")
    public List<BillDetail> getAll() {
        return billDetailService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('" + PermissionType.BILL_DETAIL_VIEW + "')")
    public BillDetail get(@PathVariable("id") long id) {
        return billDetailService.get(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('" + PermissionType.BILL_DETAIL_EDIT + "')")
    public long save(@RequestBody BillDetail object) {
        System.out.println(object);
        billDetailService.save(object);
        return object.getId();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('" + PermissionType.BILL_DETAIL_EDIT + "')")
    public long update(@RequestBody BillDetail object) {
        billDetailService.update(object);
        return object.getId();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('" + PermissionType.BILL_DETAIL_EDIT + "')")
    public void delete(@PathVariable("id") long id) {
        billDetailService.delete(id);
    }
}
