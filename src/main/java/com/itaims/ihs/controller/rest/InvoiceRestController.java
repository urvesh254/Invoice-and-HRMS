package com.itaims.ihs.controller.rest;

import com.itaims.ihs.entity.Invoice;
import com.itaims.ihs.entity.InvoiceDetail;
import com.itaims.ihs.entity.InvoicePayment;
import com.itaims.ihs.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceRestController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping
    public List<Invoice> getAll() {
        return invoiceService.getAll();
    }

    @GetMapping("/{id}")
    public Invoice get(@PathVariable("id") long id) {
        return invoiceService.get(id);
    }

    @GetMapping("/{id}/invoice-details")
    public List<InvoiceDetail> getUsers(@PathVariable("id") long id) {
        Invoice invoice = invoiceService.get(id);
        return invoice.getInvoiceDetails();
    }

    @GetMapping("/{id}/invoice-payments")
    public List<InvoicePayment> getPermissions(@PathVariable("id") long id) {
        Invoice invoice = invoiceService.get(id);
        return invoice.getInvoicePayments();
    }

    @PostMapping
    public long save(@RequestBody Invoice object) {
        invoiceService.save(object);
        System.out.println(object);
        return object.getId();
    }

    @PutMapping
    public long update(@RequestBody Invoice object) {
        System.out.println(object);
        invoiceService.update(object);
        return object.getId();
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        invoiceService.delete(id);
    }
}
