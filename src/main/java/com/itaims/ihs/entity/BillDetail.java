package com.itaims.ihs.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "bill_detail")
public class BillDetail extends AuditableBase {

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "bill_id", nullable = false)
    private Bill bill;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, orphanRemoval = true)
    @JoinColumn(name = "expense_id", nullable = false)
    private Expense expense;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "sub_total", nullable = false)
    private double subTotal;

    @Column(name = "gst", nullable = false)
    private double gst;

    @Column(name = "total_total", nullable = false)
    private double totalTotal;

    @Column(name = "remark", nullable = false)
    private String remark;
}
