package com.itaims.ihs.entity;

import com.itaims.ihs.util.Status;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "vendor")
public class Vendor extends AuditableBase {

    @Column(name = "vendor_name", nullable = false)
    private String vendorName;

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

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bill> bills;
}
