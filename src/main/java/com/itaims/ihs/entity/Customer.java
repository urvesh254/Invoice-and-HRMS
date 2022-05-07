package com.itaims.ihs.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.itaims.ihs.util.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "customer")
@NoArgsConstructor
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

    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Project> projects;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Invoice> invoices;

    @JsonCreator
    public Customer(@JsonProperty(required = true) String customerName, @JsonProperty(required = true) String countryName, @JsonProperty(required = true) String type, @JsonProperty(required = true) String number, @JsonProperty(required = true) String email, @JsonProperty(required = true) String area, Status status) {
        this.customerName = customerName;
        this.countryName = countryName;
        this.type = type;
        this.number = number;
        this.email = email;
        this.area = area;
        this.status = status != null ? status : Status.ACTIVE;
        this.projects = new ArrayList<>();
        this.invoices = new ArrayList<>();
    }
}
