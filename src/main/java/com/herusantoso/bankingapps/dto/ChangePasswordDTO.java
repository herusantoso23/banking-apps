package com.herusantoso.bankingapps.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class ChangePasswordDTO {

    @NotBlank
    @Size(min = 6, max = 20)
    @JsonProperty(value = "old_password")
    private String oldPassword;

    @NotBlank
    @Size(min = 6, max = 20)
    @JsonProperty(value = "new_password")
    private String newPassord;

    @NotBlank
    @Size(min = 6, max = 20)
    @JsonProperty(value = "confirm_password")
    private String confirmPassword;

}
