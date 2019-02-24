package com.herusantoso.bankingapps.service;

import com.herusantoso.bankingapps.dto.TransactionHistoryDTO;
import com.herusantoso.bankingapps.dto.TransactionRequestDTO;
import com.herusantoso.bankingapps.dto.TransactionResponseDTO;

import java.util.List;

public interface TransactionService {

    TransactionResponseDTO deposit(TransactionRequestDTO transactionRequestDTO);

    TransactionResponseDTO withDraw(TransactionRequestDTO transactionRequestDTO);

    List<TransactionHistoryDTO> getTransactionHistory();

}
