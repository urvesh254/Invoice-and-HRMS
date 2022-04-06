package com.itaims.ihs.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "invoice")
public class Invoice extends AuditableBase {
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @Column(name = "invoice_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date invoiceDate;

    @Column(name = "invoice_no", nullable = false)
    private String invoiceNo;

    @Column(name = "remark", nullable = false)
    private String remark;

    /*
     * Remove this because there is no use of this because this is also in invoice_payment.
     * */
    // private PaymentMode paymentMode;


    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "currency_id", nullable = false)
    private Currency currency;

    @Column(name = "taxes", nullable = false)
    private double taxes;

    @Column(name = "total", nullable = false)
    private double total;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InvoiceDetail> invoiceDetails;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InvoicePayment> invoicePayments;

}
