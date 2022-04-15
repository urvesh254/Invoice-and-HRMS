package com.itaims.ihs.entity;

import com.fasterxml.jackson.annotation.*;
import com.itaims.ihs.util.PaymentMode;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Entity
@Data
@Table(name = "bill_payment")
public class BillPayment extends AuditableBase {

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "bill_id", nullable = false)
    private Bill bill;

    @JsonProperty(required = true)
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "bill_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date billDate;

    @JsonProperty(required = true)
    @Column(name = "amount", nullable = false)
    private double amount;

    @JsonProperty(required = true)
    @Column(name = "description", nullable = false)
    private String description;

    @JsonProperty(required = true)
    @Column(name = "payment_mode", nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;

    public BillPayment() {
    }

    @JsonCreator
    public BillPayment(long billId, Date billDate, double amount, String description, PaymentMode paymentMode) {
        this.bill = new Bill();
        this.bill.setId(billId);
        this.billDate = billDate;
        this.amount = amount;
        this.description = description;
        this.paymentMode = paymentMode;
    }

    @JsonAnyGetter
    public Map<String, Object> getExtras() {
        Map<String, Object> extras = new HashMap<>();

        extras.put("billId", bill.getId());

        return extras;
    }


    @Override
    public String toString() {
        return "BillPayment{" +
                "id=" + id +
                ", billId=" + bill.getId() +
                ", billDate=" + billDate +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", paymentMode=" + paymentMode +
                '}';
    }
}
