package com.itaims.ihs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@MappedSuperclass
@Data
@EntityListeners(value = {AuditingEntityListener.class})
@JsonPropertyOrder("id")
public abstract class AuditableBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @CreatedBy
    @Column(name = "created_by", updatable = false)
    @JsonIgnore
    private String createdBy;

    @CreatedDate
    @Column(name = "created_dt", updatable = false)
    @JsonIgnore
    private Timestamp createdDt;

    @LastModifiedBy
    @Column(name = "modified_by")
    @JsonIgnore
    private String modifiedBy;

    @LastModifiedDate
    @Column(name = "modified_dt")
    @JsonIgnore
    private Timestamp modifiedDt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuditableBase that = (AuditableBase) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
