package com.itaims.ihs.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class JwtRequest {
    @JsonProperty(required = true)
    private String username;

    @JsonProperty(required = true)
    private String password;

    public JwtRequest() {
    }

    public JwtRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
