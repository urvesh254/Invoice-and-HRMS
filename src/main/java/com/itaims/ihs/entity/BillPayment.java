package com.itaims.ihs.entity;

import com.itaims.ihs.util.PaymentMode;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "bill_payment")
public class BillPayment extends AuditableBase {

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "bill_id", nullable = false)
    private Bill bill;

    @Column(name = "bill_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date billDate;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "payment_mode", nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;
}
