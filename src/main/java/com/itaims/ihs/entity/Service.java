package com.itaims.ihs.entity;

import com.itaims.ihs.util.Status;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "service")
public class Service extends AuditableBase {
    @Column(name = "service_name", nullable = false)
    private String serviceName;

    @Column(name = "hsn", nullable = false)
    private String hsn;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;
}