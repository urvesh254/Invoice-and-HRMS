package com.itaims.ihs.response;


import lombok.Data;

@Data
public class ErrorResponse {
    private int status;
    private String message;
    private long timestamp;
}
