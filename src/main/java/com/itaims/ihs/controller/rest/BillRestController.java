package com.itaims.ihs.controller.rest;

import com.itaims.ihs.entity.Bill;
import com.itaims.ihs.entity.BillDetail;
import com.itaims.ihs.entity.BillPayment;
import com.itaims.ihs.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bills")
public class BillRestController {

    @Autowired
    private BillService billService;

    @GetMapping
    public List<Bill> getAll() {
        return billService.getAll();
    }

    @GetMapping("/{id}")
    public Bill get(@PathVariable("id") long id) {
        return billService.get(id);
    }

    @GetMapping("/{id}/bill-details")
    public List<BillDetail> getUsers(@PathVariable("id") long id) {
        Bill bill = billService.get(id);
        return bill.getBillDetails();
    }

    @GetMapping("/{id}/bill-payments")
    public List<BillPayment> getPermissions(@PathVariable("id") long id) {
        Bill bill = billService.get(id);
        return bill.getBillPayments();
    }

    @PostMapping
    public long save(@RequestBody Bill object) {
        billService.save(object);
        System.out.println(object);
        return object.getId();
    }

    @PutMapping
    public long update(@RequestBody Bill object) {
        System.out.println(object);
        billService.update(object);
        return object.getId();
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        billService.delete(id);
    }
}
