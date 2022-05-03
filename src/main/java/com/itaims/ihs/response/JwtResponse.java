package com.itaims.ihs.response;

import lombok.Data;

@Data
public class JwtResponse {
    private String token;

    public JwtResponse() {
    }

    public JwtResponse(String token) {
        this.token = token;
    }
}
