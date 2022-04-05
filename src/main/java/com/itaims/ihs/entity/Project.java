package com.itaims.ihs.entity;

import com.itaims.ihs.util.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "project")
@NoArgsConstructor
public class Project extends AuditableBase {

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "project_name", nullable = false)
    private String projectName;

    @Column(name = "start_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "total_budget", nullable = false)
    private double totalBudget;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "project_employee", inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Employee> assignedEmployees;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Milestone> milestones;

    // TODO: document field will added in future.

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    public Project(Customer customer, String projectName, Date startDate, double totalBudget, String description, Status status) {
        this.customer = customer;
        this.projectName = projectName;
        this.startDate = startDate;
        this.totalBudget = totalBudget;
        this.description = description;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectName='" + projectName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", totalBudget=" + totalBudget +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
