package com.itaims.ihs.controller.rest;

import com.itaims.ihs.entity.InvoicePayment;
import com.itaims.ihs.service.InvoicePaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice-payments")
public class InvoicePaymentRestController {
    @Autowired
    private InvoicePaymentService invoicePaymentService;

    @GetMapping
    public List<InvoicePayment> getAll() {
        return invoicePaymentService.getAll();
    }

    @GetMapping("/{id}")
    public InvoicePayment get(@PathVariable("id") long id) {
        return invoicePaymentService.get(id);
    }

    @PostMapping
    public long save(@RequestBody InvoicePayment object) {
        System.out.println(object);
        invoicePaymentService.save(object);
        return object.getId();
    }

    @PutMapping
    public long update(@RequestBody InvoicePayment object) {
        invoicePaymentService.update(object);
        return object.getId();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        invoicePaymentService.delete(id);
    }
}
