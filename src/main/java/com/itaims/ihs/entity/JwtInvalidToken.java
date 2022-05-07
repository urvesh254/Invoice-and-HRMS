package com.itaims.ihs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "invalid_tokens")
public class JwtInvalidToken extends AuditableBase {
    @JsonProperty(required = true)
    @Column(name = "token", nullable = false)
    private String token;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "valid_till", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date validTill;
}