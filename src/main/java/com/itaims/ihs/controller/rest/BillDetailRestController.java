package com.itaims.ihs.controller.rest;

import com.itaims.ihs.entity.BillDetail;
import com.itaims.ihs.service.BillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bill-details")
public class BillDetailRestController {
    @Autowired
    private BillDetailService billDetailService;

    @GetMapping
    public List<BillDetail> getAll() {
        return billDetailService.getAll();
    }

    @GetMapping("/{id}")
    public BillDetail get(@PathVariable("id") long id) {
        return billDetailService.get(id);
    }

    @PostMapping
    public long save(@RequestBody BillDetail object) {
        System.out.println(object);
        billDetailService.save(object);
        return object.getId();
    }

    @PutMapping
    public long update(@RequestBody BillDetail object) {
        billDetailService.update(object);
        return object.getId();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        billDetailService.delete(id);
    }
}
