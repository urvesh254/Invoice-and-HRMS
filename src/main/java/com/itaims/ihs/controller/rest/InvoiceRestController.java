package com.itaims.ihs.controller.rest;

import com.itaims.ihs.entity.Invoice;
import com.itaims.ihs.entity.InvoiceDetail;
import com.itaims.ihs.entity.InvoicePayment;
import com.itaims.ihs.service.InvoiceService;
import com.itaims.ihs.util.PermissionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceRestController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping
    @PreAuthorize("hasAuthority('" + PermissionType.INVOICE_VIEW + "')")
    public List<Invoice> getAll() {
        return invoiceService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('" + PermissionType.INVOICE_VIEW + "')")
    public Invoice get(@PathVariable("id") long id) {
        return invoiceService.get(id);
    }

    @GetMapping("/{id}/invoice-details")
    @PreAuthorize("hasAuthority('" + PermissionType.INVOICE_VIEW + "')")
    public List<InvoiceDetail> getUsers(@PathVariable("id") long id) {
        Invoice invoice = invoiceService.get(id);
        return invoice.getInvoiceDetails();
    }

    @GetMapping("/{id}/invoice-payments")
    @PreAuthorize("hasAuthority('" + PermissionType.INVOICE_VIEW + "')")
    public List<InvoicePayment> getPermissions(@PathVariable("id") long id) {
        Invoice invoice = invoiceService.get(id);
        return invoice.getInvoicePayments();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('" + PermissionType.INVOICE_EDIT + "')")
    public long save(@RequestBody Invoice object) {
        invoiceService.save(object);
        System.out.println(object);
        return object.getId();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('" + PermissionType.INVOICE_EDIT + "')")
    public long update(@RequestBody Invoice object) {
        System.out.println(object);
        invoiceService.update(object);
        return object.getId();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('" + PermissionType.INVOICE_EDIT + "')")
    public void delete(@PathVariable("id") long id) {
        invoiceService.delete(id);
    }
}
