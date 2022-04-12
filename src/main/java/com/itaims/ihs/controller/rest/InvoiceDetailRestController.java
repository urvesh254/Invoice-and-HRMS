package com.itaims.ihs.controller.rest;

import com.itaims.ihs.entity.InvoiceDetail;
import com.itaims.ihs.service.InvoiceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice-details")
public class InvoiceDetailRestController {
    @Autowired
    private InvoiceDetailService invoiceDetailService;

    @GetMapping
    public List<InvoiceDetail> getAll() {
        return invoiceDetailService.getAll();
    }

    @GetMapping("/{id}")
    public InvoiceDetail get(@PathVariable("id") long id) {
        return invoiceDetailService.get(id);
    }

    @PostMapping
    public long save(@RequestBody InvoiceDetail object) {
        System.out.println(object);
        invoiceDetailService.save(object);
        return object.getId();
    }

    @PutMapping
    public long update(@RequestBody InvoiceDetail object) {
        invoiceDetailService.update(object);
        return object.getId();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        invoiceDetailService.delete(id);
    }
}
