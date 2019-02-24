package com.herusantoso.bankingapps.util;

import com.herusantoso.bankingapps.domain.User;
import com.herusantoso.bankingapps.exception.BadRequestException;
import com.herusantoso.bankingapps.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationUtil {

    @Autowired
    private UserRepository userRepository;

    public User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return userRepository.findOneByUsername(authentication.getName())
                .orElseThrow(() -> new BadRequestException("User not found"));
    }

}
