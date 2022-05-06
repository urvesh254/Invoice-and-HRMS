package com.itaims.ihs.controller.rest;

import com.itaims.ihs.entity.Currency;
import com.itaims.ihs.service.CurrencyService;
import com.itaims.ihs.util.PermissionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currencies")
public class CurrencyRestController {
    @Autowired
    private CurrencyService currencyService;

    @GetMapping
    @PreAuthorize("hasAuthority('" + PermissionType.CURRENCY_VIEW + "')")
    public List<Currency> getAll() {
        return currencyService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('" + PermissionType.CURRENCY_VIEW + "')")
    public Currency get(@PathVariable("id") long id) {
        return currencyService.get(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('" + PermissionType.CURRENCY_EDIT + "')")
    public long save(@RequestBody Currency object) {
        currencyService.save(object);
        return object.getId();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('" + PermissionType.CURRENCY_EDIT + "')")
    public long update(@RequestBody Currency object) {
        currencyService.update(object);
        return object.getId();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('" + PermissionType.CURRENCY_EDIT + "')")
    public void delete(@PathVariable("id") long id) {
//        Probabaly not doing delete.
//        currencyService.delete(id);
    }
}
