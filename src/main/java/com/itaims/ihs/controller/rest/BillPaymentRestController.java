package com.itaims.ihs.controller.rest;

import com.itaims.ihs.entity.BillPayment;
import com.itaims.ihs.service.BillPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bill-payments")
public class BillPaymentRestController {
    @Autowired
    private BillPaymentService billPaymentService;

    @GetMapping
    public List<BillPayment> getAll() {
        return billPaymentService.getAll();
    }

    @GetMapping("/{id}")
    public BillPayment get(@PathVariable("id") long id) {
        return billPaymentService.get(id);
    }

    @PostMapping
    public long save(@RequestBody BillPayment object) {
        System.out.println(object);
        billPaymentService.save(object);
        return object.getId();
    }

    @PutMapping
    public long update(@RequestBody BillPayment object) {
        billPaymentService.update(object);
        return object.getId();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        billPaymentService.delete(id);
    }
}
