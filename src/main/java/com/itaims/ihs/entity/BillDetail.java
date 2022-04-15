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
@Table(name = "bill_detail")
public class BillDetail extends AuditableBase {

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "bill_id", nullable = false)
    private Bill bill;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ManyToOne
    @JoinColumn(name = "expense_id", nullable = false)
    private Expense expense;

    @JsonProperty(required = true)
    @Column(name = "quantity", nullable = false)
    private int quantity;

    @JsonProperty(required = true)
    @Column(name = "price", nullable = false)
    private double price;

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


    public BillDetail() {
    }

    @JsonCreator
    public BillDetail(long billId, long expenseId, int quantity, double price, double subTotal, double gst, double totalTotal, String remark) {
        this.bill = new Bill();
        this.bill.setId(billId);
        this.expense = new Expense();
        this.expense.setId(expenseId);
        this.quantity = quantity;
        this.price = price;
        this.subTotal = subTotal;
        this.gst = gst;
        this.totalTotal = totalTotal;
        this.remark = remark;
    }


    @JsonAnyGetter
    public Map<String, Object> getExtras() {
        Map<String, Object> extras = new HashMap<>();

        extras.put("billId", bill.getId());

        return extras;
    }

    @Override
    public String toString() {
        return "BillDetail{" +
                "id=" + id +
                ", billId=" + bill.getId() +
                ", expense=" + expense.getId() +
                ", quantity=" + quantity +
                ", price=" + price +
                ", subTotal=" + subTotal +
                ", gst=" + gst +
                ", totalTotal=" + totalTotal +
                ", remark='" + remark + '\'' +
                '}';
    }
}
