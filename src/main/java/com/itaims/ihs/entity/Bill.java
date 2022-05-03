package com.itaims.ihs.entity;

import com.fasterxml.jackson.annotation.*;
import com.itaims.ihs.util.Status;
import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@Table(name = "bill")
public class Bill extends AuditableBase {

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "vendor_id", nullable = false)
    private Vendor vendor;

    @JsonProperty(required = true)
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "purchase_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date purchaseDate;

    @JsonProperty(required = true)
    @Column(name = "taxes", nullable = false)
    private double taxes;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @JsonIgnore
    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BillDetail> billDetails;

    @JsonIgnore
    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BillPayment> billPayments;

    public Bill() {
    }

    @JsonCreator
    public Bill(long vendorId, Date purchaseDate, double taxes, Status status) {
        this.vendor = new Vendor();
        this.vendor.setId(vendorId);
        this.purchaseDate = purchaseDate;
        this.taxes = taxes;
        this.status = status != null ? status : Status.PENDING;

        this.billDetails = new ArrayList<>();
        this.billPayments = new ArrayList<>();
    }

    @JsonAnyGetter
    public Map<String, Object> getExtras() {
        Map<String, Object> extras = new HashMap<>();

        extras.put("vendorId", vendor.getId());

        return extras;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", vendor=" + vendor +
                ", purchaseDate=" + purchaseDate +
                ", taxes=" + taxes +
                ", status=" + status +
                '}';
    }
}
