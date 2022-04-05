package com.itaims.ihs.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "employee")
@EntityListeners(AuditingEntityListener.class)
public class Employee extends AuditableBase {

    @Column(name = "emp_name", nullable = false)
    private String employeeName;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "department", nullable = false)
    private String department;

    @Column(name = "joining_date")
    @Temporal(TemporalType.DATE)
    private Date joiningDate;

    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;

    @ManyToMany(mappedBy = "assignedEmployees",cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Project> projects;
}
