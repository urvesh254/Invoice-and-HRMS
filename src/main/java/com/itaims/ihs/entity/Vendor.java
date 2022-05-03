package com.itaims.ihs.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.itaims.ihs.util.Status;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "vendor")
public class Vendor extends AuditableBase {

    @JsonProperty(required = true)
    @Column(name = "vendor_name", nullable = false)
    private String vendorName;

    @JsonProperty(required = true)
    @Column(name = "country_name", nullable = false)
    private String countryName;

    @JsonProperty(required = true)
    @Column(name = "type", nullable = false)
    private String type;

    @JsonProperty(required = true)
    @Column(name = "number", nullable = false)
    private String number;

    @JsonProperty(required = true)
    @Column(name = "email", nullable = false)
    private String email;

    @JsonProperty(required = true)
    @Column(name = "area", nullable = false)
    private String area;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @JsonIgnore
    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bill> bills;

    public Vendor() {
    }

    @JsonCreator
    public Vendor(String vendorName, String countryName, String type, String number, String email, String area, Status status) {
        this.vendorName = vendorName;
        this.countryName = countryName;
        this.type = type;
        this.number = number;
        this.email = email;
        this.area = area;
        this.status = status != null ? status : Status.ACTIVE;

        this.bills = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "id=" + id +
                ", vendorName='" + vendorName + '\'' +
                ", countryName='" + countryName + '\'' +
                ", type='" + type + '\'' +
                ", number='" + number + '\'' +
                ", email='" + email + '\'' +
                ", area='" + area + '\'' +
                ", status=" + status +
                '}';
    }
}
