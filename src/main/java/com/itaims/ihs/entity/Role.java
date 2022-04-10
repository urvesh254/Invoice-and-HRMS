package com.itaims.ihs.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@Table(name = "role")
@NoArgsConstructor
@JsonIgnoreProperties(value = {"users", "permissions"}, allowSetters = true)
public class Role extends AuditableBase {

    @Column(name = "role_name", nullable = false, unique = true)
    private String roleName;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> users;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "role_permission", inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private List<Permission> permissions;

    @JsonCreator
    public Role(@JsonProperty(required = true) String roleName, List<Long> permissions, long id) {
        this.id = id;
        this.roleName = roleName;
        if (permissions != null) {
            System.out.println(">>>>>>>>>>>>" + permissions);
            this.permissions = permissions.stream().map(integer -> new Permission() {{
                setId(integer);
            }}).collect(Collectors.toList());
        }
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}

