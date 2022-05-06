package com.itaims.ihs.controller.rest;

import com.itaims.ihs.entity.InvoicePayment;
import com.itaims.ihs.service.InvoicePaymentService;
import com.itaims.ihs.util.PermissionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice-payments")
public class InvoicePaymentRestController {
    @Autowired
    private InvoicePaymentService invoicePaymentService;

    @GetMapping
    @PreAuthorize("hasAuthority('" + PermissionType.INVOICE_PAYMENT_VIEW + "')")
    public List<InvoicePayment> getAll() {
        return invoicePaymentService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('" + PermissionType.INVOICE_PAYMENT_VIEW + "')")
    public InvoicePayment get(@PathVariable("id") long id) {
        return invoicePaymentService.get(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('" + PermissionType.INVOICE_PAYMENT_EDIT + "')")
    public long save(@RequestBody InvoicePayment object) {
        System.out.println(object);
        invoicePaymentService.save(object);
        return object.getId();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('" + PermissionType.INVOICE_PAYMENT_EDIT + "')")
    public long update(@RequestBody InvoicePayment object) {
        invoicePaymentService.update(object);
        return object.getId();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('" + PermissionType.INVOICE_PAYMENT_EDIT + "')")
    public void delete(@PathVariable("id") long id) {
        invoicePaymentService.delete(id);
    }
}
