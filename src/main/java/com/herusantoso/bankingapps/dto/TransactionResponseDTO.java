package com.herusantoso.bankingapps.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionResponseDTO {

    @JsonProperty(value = "id")
    private String secureId;

    @JsonProperty(value = "transaction_date")
    private Long transactionDate;

    @JsonProperty(value = "transaction_type")
    private String transactionType;

    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "amount")
    private BigDecimal amount;

    @JsonProperty(value = "balance")
    private BigDecimal balance;

}
