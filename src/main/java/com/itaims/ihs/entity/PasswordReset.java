package com.itaims.ihs.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "password_reset")
@JsonPropertyOrder("id")
public class PasswordReset extends AuditableBase {

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "token", nullable = false)
    private String token;
}
