package com.itaims.ihs.entity;

import com.fasterxml.jackson.annotation.*;
import com.itaims.ihs.util.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Data
@Table(name = "project")
@NoArgsConstructor
public class Project extends AuditableBase {

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "project_name", nullable = false)
    private String projectName;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "start_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "total_budget", nullable = false)
    private double totalBudget;

    @Column(name = "description", nullable = false)
    private String description;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "project_employee", inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Employee> assignedEmployees;

    @JsonIgnore
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Milestone> milestones;

    @JsonIgnore
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Invoice> invoices;

    // TODO: document field will added in future.

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @JsonCreator
    public Project(@JsonProperty(required = true) long customerId, @JsonProperty(required = true) String projectName, @JsonProperty(required = true) Date startDate, @JsonProperty(required = true) double totalBudget, @JsonProperty(required = true) String description, Status status, @JsonProperty("assignedEmployees") List<Long> assignedEmployeeIDs) {
        this.customer = new Customer();
        this.customer.setId(customerId);
        System.out.println(this.customer);
        this.projectName = projectName;
        this.startDate = startDate;
        this.totalBudget = totalBudget;
        this.description = description;
        this.status = status != null ? status : Status.ON_HOLD;

        if (assignedEmployeeIDs != null) {
            this.assignedEmployees = assignedEmployeeIDs.stream().map(integer -> new Employee() {{
                setId(integer);
            }}).collect(Collectors.toList());
        } else {
            this.assignedEmployees = new ArrayList<>();
        }

        this.milestones = new ArrayList<>();
        this.invoices = new ArrayList<>();
    }

    @JsonAnyGetter
    public Map<String, Object> getExtras() {
        Map<String, Object> extras = new HashMap<>();

        extras.put("customerId", customer.getId());

        return extras;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", customer=" + customer.getId() +
                ", projectName='" + projectName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", totalBudget=" + totalBudget +
                ", description='" + description + '\'' +
                ", assignedEmployees=" + assignedEmployees +
                ", milestones=" + milestones +
                ", invoices=" + invoices +
                ", status=" + status +
                '}';
    }

}
