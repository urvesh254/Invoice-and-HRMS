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
@Table(name = "invoice_payment")
public class InvoicePayment extends AuditableBase {
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "invoice_id", nullable = false)
    private Invoice invoice;

    @JsonProperty(required = true)
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "payment_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date paymentDate;

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

    public InvoicePayment() {
    }

    @JsonCreator
    public InvoicePayment(@JsonProperty(required = true) long invoiceId, Date paymentDate, double amount, String description, PaymentMode paymentMode) {
        this.invoice = new Invoice();
        this.invoice.setId(invoiceId);
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.description = description;
        this.paymentMode = paymentMode;
    }

    @JsonAnyGetter
    public Map<String, Object> getExtras() {
        Map<String, Object> extras = new HashMap<>();

        extras.put("invoiceId", invoice.getId());

        return extras;
    }

    @Override
    public String toString() {
        return "InvoicePayment{" +
                "invoice=" + invoice.getId() +
                ", paymentDate=" + paymentDate +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", paymentMode=" + paymentMode +
                '}';
    }
}
