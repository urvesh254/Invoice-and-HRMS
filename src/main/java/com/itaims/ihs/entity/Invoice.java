package com.itaims.ihs.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "invoice")
public class Invoice extends AuditableBase {
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @JsonFormat(pattern = "dd-MM-yyyy")
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

    @ManyToOne
    @JoinColumn(name = "currency_id", nullable = false)
    private Currency currency;

    @Column(name = "taxes", nullable = false)
    private double taxes;

    @Column(name = "total", nullable = false)
    private double total;

    @JsonIgnore
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InvoiceDetail> invoiceDetails;

    @JsonIgnore
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InvoicePayment> invoicePayments;

    @JsonCreator
    public Invoice(@JsonProperty(required = true) long customerId, @JsonProperty(required = true) long projectId, @JsonProperty(required = true) Date invoiceDate, @JsonProperty(required = true) String invoiceNo, @JsonProperty(required = true) String remark, @JsonProperty(required = true) long currencyId, @JsonProperty(required = true) double taxes, @JsonProperty(required = true) double total) {
        this.customer = new Customer();
        this.customer.setId(customerId);
        this.project = new Project();
        this.project.setId(projectId);
        this.invoiceDate = invoiceDate;
        this.invoiceNo = invoiceNo;
        this.remark = remark;
        this.currency = new Currency();
        this.currency.setId(currencyId);
        this.taxes = taxes;
        this.total = total;

        this.invoiceDetails = new ArrayList<>();
        this.invoicePayments = new ArrayList<>();
    }

    @JsonAnyGetter
    public Map<String, Object> getExtras() {
        Map<String, Object> extras = new HashMap<>();

        extras.put("customerId", customer.getId());
        extras.put("projectId", project.getId());

        return extras;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "customer=" + customer.getId() +
                ", project=" + project.getId() +
                ", invoiceDate=" + invoiceDate +
                ", invoiceNo='" + invoiceNo + '\'' +
                ", remark='" + remark + '\'' +
                ", currency=" + currency +
                ", taxes=" + taxes +
                ", total=" + total +
                '}';
    }
}
