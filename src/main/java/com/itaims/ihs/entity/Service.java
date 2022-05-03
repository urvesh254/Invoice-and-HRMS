package com.itaims.ihs.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.itaims.ihs.util.Status;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "service")
public class Service extends AuditableBase {
    @JsonProperty(required = true)
    @Column(name = "service_name", nullable = false)
    private String serviceName;

    @JsonProperty(required = true)
    @Column(name = "hsn", nullable = false)
    private String hsn;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    public Service() {
    }

    @JsonCreator
    public Service(String serviceName, String hsn, Status status) {
        this.serviceName = serviceName;
        this.hsn = hsn;
        this.status = status != null ? status : Status.ACTIVE;
    }
}