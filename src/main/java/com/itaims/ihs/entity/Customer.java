package com.itaims.ihs.entity;

import com.itaims.ihs.util.Status;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "customer")
public class Customer extends AuditableBase {

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "country_name", nullable = false)
    private String countryName;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "area", nullable = false)
    private String area;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    public Customer(String customerName, String countryName, String type, String number, String email, String area, Status status) {
        this.customerName = customerName;
        this.countryName = countryName;
        this.type = type;
        this.number = number;
        this.email = email;
        this.area = area;
        this.status = status;

    }
}
