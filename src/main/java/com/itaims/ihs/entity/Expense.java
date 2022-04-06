package com.itaims.ihs.entity;

import com.itaims.ihs.util.Status;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "expenses")
public class Expense extends AuditableBase {

    @Column(name = "expense_name", nullable = false)
    private String expenseName;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;
}
