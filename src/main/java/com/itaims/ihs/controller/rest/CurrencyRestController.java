package com.itaims.ihs.controller.rest;

import com.itaims.ihs.entity.Currency;
import com.itaims.ihs.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currencies")
public class CurrencyRestController {
    @Autowired
    private CurrencyService currencyService;

    @GetMapping
    public List<Currency> getAll() {
        return currencyService.getAll();
    }

    @GetMapping("/{id}")
    public Currency get(@PathVariable("id") long id) {
        return currencyService.get(id);
    }

    @PostMapping
    public long save(@RequestBody Currency object) {
        currencyService.save(object);
        return object.getId();
    }

    @PutMapping
    public long update(@RequestBody Currency object) {
        currencyService.update(object);
        return object.getId();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
//        Probabaly not doing delete.
//        currencyService.delete(id);
    }
}
