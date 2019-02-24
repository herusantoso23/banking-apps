package com.herusantoso.bankingapps.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserDetailDTO {

    @JsonProperty(value = "id")
    private String secureId;

    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "balance")
    private String balance;

}
