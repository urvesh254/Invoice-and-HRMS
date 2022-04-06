package com.itaims.ihs.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "invoice_detail")
public class InvoiceDetail extends AuditableBase {

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "invoice_id", nullable = false)
    private Invoice invoice;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    @Column(name = "service_quantity", nullable = false)
    private int serviceQuantity;

    @Column(name = "service_price", nullable = false)
    private double servicePrice;

    @Column(name = "sub_total", nullable = false)
    private double subTotal;

    @Column(name = "gst", nullable = false)
    private double gst;

    @Column(name = "total_total", nullable = false)
    private double totalTotal;

    @Column(name = "remark", nullable = false)
    private String remark;
}
