package com.herusantoso.bankingapps.service.impl;

import com.herusantoso.bankingapps.domain.Transaction;
import com.herusantoso.bankingapps.domain.User;
import com.herusantoso.bankingapps.dto.TransactionHistoryDTO;
import com.herusantoso.bankingapps.dto.TransactionResponseDTO;
import com.herusantoso.bankingapps.dto.TransactionRequestDTO;
import com.herusantoso.bankingapps.mapper.TransactionMapper;
import com.herusantoso.bankingapps.repository.TransactionRepository;
import com.herusantoso.bankingapps.repository.UserRepository;
import com.herusantoso.bankingapps.service.TransactionService;
import com.herusantoso.bankingapps.util.AuthenticationUtil;
import com.herusantoso.bankingapps.util.Constants;
import com.herusantoso.bankingapps.validation.TransactionValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Transactional
@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private AuthenticationUtil authenticationUtil;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionValidator transactionValidator;

    @Override
    public TransactionResponseDTO deposit(TransactionRequestDTO transactionRequestDTO) {
        User user = authenticationUtil.getCurrentUser();

        user.setBalance(user.getBalance().add(transactionRequestDTO.getAmount()));
        User userSaved = userRepository.saveAndFlush(user);

        Transaction transaction = new Transaction();
        transaction.setAmount(transactionRequestDTO.getAmount());
        transaction.setTransactionType(Constants.TransactionType.DEPOSIT);
        transaction.setUsers(userSaved);
        transaction.setBalance(userSaved.getBalance());
        Transaction transactionSaved = transactionRepository.saveAndFlush(transaction);
        return TransactionMapper.INSTANCE.toDTO(transactionSaved, new TransactionResponseDTO());
    }

    @Override
    public TransactionResponseDTO withDraw(TransactionRequestDTO transactionRequestDTO) {
        User user = authenticationUtil.getCurrentUser();
        transactionValidator.withDrawValidation(user, transactionRequestDTO);
        user.setBalance(user.getBalance().subtract(transactionRequestDTO.getAmount()));
        User userSaved = userRepository.saveAndFlush(user);

        Transaction transaction = new Transaction();
        transaction.setAmount(transactionRequestDTO.getAmount());
        transaction.setTransactionType(Constants.TransactionType.WITHDRAW);
        transaction.setUsers(userSaved);
        transaction.setBalance(userSaved.getBalance());
        Transaction transactionSaved = transactionRepository.saveAndFlush(transaction);
        return TransactionMapper.INSTANCE.toDTO(transactionSaved, new TransactionResponseDTO());
    }

    @Override
    public List<TransactionHistoryDTO> getTransactionHistory() {
        User user = authenticationUtil.getCurrentUser();
        List<Transaction> transactions = transactionRepository.findByUsers(user);
        return transactions
                .stream()
                .map(transaction -> TransactionMapper.INSTANCE.toHistoryDTO(transaction, new TransactionHistoryDTO()))
                .collect(Collectors.toCollection(LinkedList::new));
    }
}
