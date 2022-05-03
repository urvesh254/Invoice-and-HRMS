package com.itaims.ihs.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@Table(name = "employee")
public class Employee extends AuditableBase {

    @Column(name = "emp_name", nullable = false)
    private String employeeName;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "address", nullable = false)
    private String address;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "joining_date")
    @Temporal(TemporalType.DATE)
    private Date joiningDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;

    @JsonIgnore
    @ManyToMany(mappedBy = "assignedEmployees")
    private List<Project> projects;

    @JsonCreator
    public Employee(@JsonProperty(required = true) String employeeName, @JsonProperty(required = true) String number, @JsonProperty(required = true) String email, @JsonProperty(required = true) String address, @JsonProperty(required = true) long departmentId, Date joiningDate, Date dob) {
        this.employeeName = employeeName;
        this.number = number;
        this.email = email;
        this.address = address;
        this.department = new Department() {{
            setId(departmentId);
        }};
        this.joiningDate = joiningDate;
        this.dob = dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return email.equals(employee.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), email);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeName='" + employeeName + '\'' +
                ", number='" + number + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", department=" + department +
                ", joiningDate=" + joiningDate +
                ", dob=" + dob +
                '}';
    }
}
