package com.itaims.ihs.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@Table(name = "role")
@NoArgsConstructor
public class Role extends AuditableBase {

    @Column(name = "role_name", nullable = false, unique = true)
    private String roleName;

    @JsonIgnore
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> users;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(name = "role_permission", inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private List<Permission> permissions;

    @JsonCreator
    public Role(@JsonProperty(required = true) String roleName, @JsonProperty(required = true) List<Long> permissions, long id) {
        this.id = id;
        this.roleName = roleName;
        if (permissions != null) {
            this.permissions = permissions.stream().map(integer -> new Permission() {{
                setId(integer);
            }}).collect(Collectors.toList());
        } else {
            this.permissions = new ArrayList<>();
        }
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", users=" + users +
                ", permissions=" + permissions +
                '}';
    }
}

