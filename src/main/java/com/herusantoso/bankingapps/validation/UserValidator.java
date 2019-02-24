package com.herusantoso.bankingapps.validation;

import com.herusantoso.bankingapps.domain.User;
import com.herusantoso.bankingapps.dto.UserCreateDTO;
import com.herusantoso.bankingapps.exception.BadRequestException;
import com.herusantoso.bankingapps.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserValidator {

    @Autowired
    private UserRepository userRepository;

    public void createValidation(UserCreateDTO dto){
        Optional<User> emailFound = userRepository.findOneByEmailIgnoreCase(dto.getEmail());
        if(emailFound.isPresent()){
            throw new BadRequestException("Email already used");
        }
    }

}
