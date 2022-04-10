package com.itaims.ihs.entity;

import com.fasterxml.jackson.annotation.*;
import com.itaims.ihs.util.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "milestone")
public class Milestone extends AuditableBase {

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @JsonIgnore
    @OneToMany(mappedBy = "milestone", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MilestoneModule> milestoneModules;

    @Column(name = "budget", nullable = false)
    private double budget;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "description", nullable = false)
    private String description;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "deadline", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date deadline;

    @JsonCreator
    public Milestone(@JsonProperty(required = true) long projectId, @JsonProperty(required = true) double budget, Status status, @JsonProperty(required = true) String description, @JsonProperty(required = true) Date deadline) {
        this.project = new Project();
        this.project.setId(projectId);
        this.budget = budget;
        this.status = status != null ? status : Status.PENDING;
        this.description = description;
        this.deadline = deadline;
        this.milestoneModules = new ArrayList<>();
    }

    @JsonAnyGetter
    public Map<String, Object> getExtras() {
        Map<String, Object> extras = new HashMap<>();

        extras.put("projectId", project.getId());

        return extras;
    }

    @Override
    public String toString() {
        return "Milestone{" +
                "project=" + project.getId() +
                ", budget=" + budget +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                '}';
    }
}
