package com.itaims.ihs.response;


import lombok.Data;

@Data
public class ErrorResponse {
    private int status;
    private String message;
    private long timestamp;

    public ErrorResponse() {
    }

    public ErrorResponse(String message, int status) {
        this.status = status;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }
}
