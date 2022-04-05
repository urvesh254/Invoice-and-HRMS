package com.itaims.ihs.entity;

import com.itaims.ihs.util.Status;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "milestone")
public class Milestone extends AuditableBase {

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @OneToMany(mappedBy = "milestone", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MilestoneModule> milestoneModules;

    @Column(name = "budget", nullable = false)
    private double budget;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "deadline", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date deadline;
}
