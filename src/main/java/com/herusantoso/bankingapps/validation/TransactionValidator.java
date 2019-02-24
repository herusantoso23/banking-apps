package com.herusantoso.bankingapps.validation;

import com.herusantoso.bankingapps.domain.User;
import com.herusantoso.bankingapps.dto.TransactionRequestDTO;
import com.herusantoso.bankingapps.exception.BadRequestException;
import com.herusantoso.bankingapps.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionValidator {

    @Autowired
    private UserRepository userRepository;

    public void withDrawValidation(User entity, TransactionRequestDTO dto){
        if(dto.getAmount().compareTo(entity.getBalance()) == 1)
            throw new BadRequestException("Your balance not enough");
    }

}
