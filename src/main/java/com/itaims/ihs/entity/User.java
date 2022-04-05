package com.itaims.ihs.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user")
public class User extends AuditableBase {

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "role_id", nullable = false)
    private Role role;

    @Column(name = "user_name", nullable = false)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email_verified_at", columnDefinition = "DATETIME")
    private Date emailVerifiedAt;

    @Column(name = "remember_token")
    private String rememberToken;

    public User(Role role, String name, String number, String email, String password) {
        this.role = role;
        this.username = name;
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
}
