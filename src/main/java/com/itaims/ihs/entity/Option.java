package com.itaims.ihs.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "options")
public class Option extends AuditableBase {
    @Column(name = "key_", nullable = false)
    private String key;

    @Column(name = "value_", nullable = false)
    private String value;
}
