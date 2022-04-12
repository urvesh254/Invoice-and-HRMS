package com.itaims.ihs.entity;

import com.itaims.ihs.util.PaymentMode;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "invoice_payment")
public class InvoicePayment extends AuditableBase {
    @ManyToOne
    @JoinColumn(name = "invoice_id", nullable = false)
    private Invoice invoice;

    @Column(name = "payment_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "payment_mode", nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;
}
