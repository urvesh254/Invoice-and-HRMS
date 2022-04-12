package com.itaims.ihs.entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Data
@Table(name = "invoice_detail")
public class InvoiceDetail extends AuditableBase {

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "invoice_id", nullable = false)
    private Invoice invoice;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    @JsonProperty(required = true)
    @Column(name = "service_quantity", nullable = false)
    private int serviceQuantity;

    @JsonProperty(required = true)
    @Column(name = "service_price", nullable = false)
    private double servicePrice;

    @JsonProperty(required = true)
    @Column(name = "sub_total", nullable = false)
    private double subTotal;

    @JsonProperty(required = true)
    @Column(name = "gst", nullable = false)
    private double gst;

    @JsonProperty(required = true)
    @Column(name = "total_total", nullable = false)
    private double totalTotal;

    @JsonProperty(required = true)
    @Column(name = "remark", nullable = false)
    private String remark;

    public InvoiceDetail() {
    }

    @JsonCreator
    public InvoiceDetail(@JsonProperty(required = true) long invoiceId, @JsonProperty(required = true) long serviceId, int serviceQuantity, double servicePrice, double subTotal, double gst, double totalTotal, String remark) {
        this.invoice = new Invoice();
        this.invoice.setId(invoiceId);
        this.service = new Service();
        this.service.setId(serviceId);
        this.serviceQuantity = serviceQuantity;
        this.servicePrice = servicePrice;
        this.subTotal = subTotal;
        this.gst = gst;
        this.totalTotal = totalTotal;
        this.remark = remark;
    }


    @JsonAnyGetter
    public Map<String, Object> getExtras() {
        Map<String, Object> extras = new HashMap<>();

        extras.put("invoiceId", invoice.getId());

        return extras;
    }

    @Override
    public String toString() {
        return "InvoiceDetail{" +
                "id=" + id +
                ", invoiceId=" + invoice.getId() +
                ", serviceId=" + service.getId() +
                ", serviceQuantity=" + serviceQuantity +
                ", servicePrice=" + servicePrice +
                ", subTotal=" + subTotal +
                ", gst=" + gst +
                ", totalTotal=" + totalTotal +
                ", remark='" + remark + '\'' +
                '}';
    }


}
