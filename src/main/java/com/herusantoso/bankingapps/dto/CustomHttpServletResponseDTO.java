package com.herusantoso.bankingapps.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CustomHttpServletResponseDTO {

    private Date timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

}
