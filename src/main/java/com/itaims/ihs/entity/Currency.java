package com.itaims.ihs.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "currency")
public class Currency extends AuditableBase {
    @Column(name = "currency_name", nullable = false)
    private String currencyName;

    @Column(name = "country_name", nullable = false)
    private String countryName;

    @Column(name = "currency_symbol", nullable = false)
    private String currencySymbol;
}
