package com.herusantoso.bankingapps.resource;

import com.herusantoso.bankingapps.dto.*;
import com.herusantoso.bankingapps.service.TransactionService;
import com.herusantoso.bankingapps.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class TransactionResource {

    @Autowired
    private TransactionService transactionService;

    @ApiOperation(value = "Deposit Transaction")
    @PostMapping("/transaction/deposit")
    public ResponseEntity<TransactionResponseDTO> deposit(@Valid @RequestBody TransactionRequestDTO transactionRequestDTO) {
        TransactionResponseDTO result = transactionService.deposit(transactionRequestDTO);
        return ResponseEntity.ok().body(result);
    }

    @ApiOperation(value = "Withdraw Transaction")
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/transaction/withdraw")
    public ResponseEntity<TransactionResponseDTO> withdraw(@Valid @RequestBody TransactionRequestDTO transactionRequestDTO) {
        TransactionResponseDTO result = transactionService.withDraw(transactionRequestDTO);
        return ResponseEntity.ok().body(result);
    }

    @ApiOperation(value = "Get history transaction")
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/transaction")
    public ResponseEntity<List<TransactionHistoryDTO>> getTransactionHistory() {
        List<TransactionHistoryDTO> result = transactionService.getTransactionHistory();
        return ResponseEntity.ok().body(result);
    }

}
