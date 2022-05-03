package com.itaims.ihs.entity;

import com.fasterxml.jackson.annotation.*;
import com.itaims.ihs.util.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Entity
@Data
@NoArgsConstructor
@Table(name = "milestone_module")
public class MilestoneModule extends AuditableBase {
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "milestone_id", nullable = false)
    private Milestone milestone;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "deadline", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date deadline;

    @JsonCreator
    public MilestoneModule(@JsonProperty(required = true) long milestoneId, @JsonProperty(required = true) String description, Status status, @JsonProperty(required = true) Date deadline) {
        this.milestone = new Milestone();
        this.milestone.setId(milestoneId);
        this.description = description;
        this.status = status != null ? status : Status.PENDING;
        this.deadline = deadline;
    }

    @JsonAnyGetter
    public Map<String, Object> getExtras() {
        Map<String, Object> extras = new HashMap<>();

        extras.put("milestoneId", milestone.getId());

        return extras;
    }
}
