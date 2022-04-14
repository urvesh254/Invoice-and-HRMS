package com.itaims.ihs.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.itaims.ihs.util.Status;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "expenses")
public class Expense extends AuditableBase {

    @JsonProperty(required = true)
    @Column(name = "expense_name", nullable = false)
    private String expenseName;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    public Expense() {
    }

    @JsonCreator
    public Expense(String expenseName, Status status) {
        this.expenseName = expenseName;
        this.status = status != null ? status : Status.ACTIVE;
    }
}
