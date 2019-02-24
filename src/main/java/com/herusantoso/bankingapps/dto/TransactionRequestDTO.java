package com.herusantoso.bankingapps.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import java.math.BigDecimal;

@Data
public class TransactionRequestDTO {

    @Min(0)
    private BigDecimal amount;

}
