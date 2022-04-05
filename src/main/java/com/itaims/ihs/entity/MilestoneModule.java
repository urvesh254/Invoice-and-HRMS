package com.itaims.ihs.entity;

import com.itaims.ihs.util.Status;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "milestone_module")
public class MilestoneModule extends AuditableBase {
    @ManyToOne
    @JoinColumn(name = "milestone_id", nullable = false)
    private Milestone milestone;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "deadline", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date deadline;
}
