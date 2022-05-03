package com.itaims.ihs.entity;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user")
public class User extends AuditableBase {

    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @Column(name = "user_name", nullable = false)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "password", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(name = "email_verified_at", columnDefinition = "DATETIME")
    private Date emailVerifiedAt;

    @Column(name = "remember_token")
    private String rememberToken;

    @JsonCreator
    public User(@JsonProperty(value = "roleId", required = true) long roleId, @JsonProperty(required = true) String username, @JsonProperty(required = true) String number, @JsonProperty(required = true) String email, @JsonProperty(required = true) String password) {
        this.role = new Role();
        this.role.setId(roleId);
        this.username = username;
        this.email = email;
        this.number = number;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role=" + role.getRoleName() +
                ", name='" + username + '\'' +
                ", email='" + email + '\'' +
                ", number='" + number + '\'' +
                ", password='" + password + '\'' +
                ", emailVerifiedAt=" + emailVerifiedAt +
                ", rememberToken='" + rememberToken + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }
}
