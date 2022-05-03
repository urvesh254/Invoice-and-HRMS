package com.itaims.ihs.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "currency")
public class Currency extends AuditableBase {
    @JsonProperty(required = true)
    @Column(name = "currency_name", nullable = false)
    private String currencyName;

    @JsonProperty(required = true)
    @Column(name = "country_name", nullable = false)
    private String countryName;

    @JsonProperty(required = true)
    @Column(name = "currency_symbol", nullable = false)
    private String currencySymbol;
}
