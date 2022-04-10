package com.itaims.ihs.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "permission")
public class Permission extends AuditableBase {

    @Column(name = "permission_name", nullable = false, unique = true)
    @JsonProperty(required = true)
    private String permissionName;

    public Permission() {
    }

    public Permission(String permissionName) {
        this.permissionName = permissionName;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", permissionName='" + permissionName + '\'' +
                '}';
    }
}
