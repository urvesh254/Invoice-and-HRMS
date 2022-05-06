package com.itaims.ihs.controller.rest;

import com.itaims.ihs.entity.BillPayment;
import com.itaims.ihs.service.BillPaymentService;
import com.itaims.ihs.util.PermissionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bill-payments")
public class BillPaymentRestController {
    @Autowired
    private BillPaymentService billPaymentService;

    @GetMapping
    @PreAuthorize("hasAuthority('" + PermissionType.BILL_PAYMENT_VIEW + "')")
    public List<BillPayment> getAll() {
        return billPaymentService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('" + PermissionType.BILL_PAYMENT_VIEW + "')")
    public BillPayment get(@PathVariable("id") long id) {
        return billPaymentService.get(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('" + PermissionType.BILL_PAYMENT_EDIT + "')")
    public long save(@RequestBody BillPayment object) {
        System.out.println(object);
        billPaymentService.save(object);
        return object.getId();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('" + PermissionType.BILL_PAYMENT_EDIT + "')")
    public long update(@RequestBody BillPayment object) {
        billPaymentService.update(object);
        return object.getId();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('" + PermissionType.BILL_PAYMENT_EDIT + "')")
    public void delete(@PathVariable("id") long id) {
        billPaymentService.delete(id);
    }
}
