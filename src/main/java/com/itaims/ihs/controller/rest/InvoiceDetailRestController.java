package com.itaims.ihs.controller.rest;

import com.itaims.ihs.entity.InvoiceDetail;
import com.itaims.ihs.service.InvoiceDetailService;
import com.itaims.ihs.util.PermissionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice-details")
public class InvoiceDetailRestController {
    @Autowired
    private InvoiceDetailService invoiceDetailService;

    @GetMapping
    @PreAuthorize("hasAuthority('" + PermissionType.INVOICE_DETAIL_VIEW + "')")
    public List<InvoiceDetail> getAll() {
        return invoiceDetailService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('" + PermissionType.INVOICE_DETAIL_VIEW + "')")
    public InvoiceDetail get(@PathVariable("id") long id) {
        return invoiceDetailService.get(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('" + PermissionType.INVOICE_DETAIL_EDIT + "')")
    public long save(@RequestBody InvoiceDetail object) {
        System.out.println(object);
        invoiceDetailService.save(object);
        return object.getId();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('" + PermissionType.INVOICE_DETAIL_EDIT + "')")
    public long update(@RequestBody InvoiceDetail object) {
        invoiceDetailService.update(object);
        return object.getId();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('" + PermissionType.INVOICE_DETAIL_EDIT + "')")
    public void delete(@PathVariable("id") long id) {
        invoiceDetailService.delete(id);
    }
}
