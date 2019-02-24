package com.herusantoso.bankingapps.service.impl;

import com.herusantoso.bankingapps.domain.Role;
import com.herusantoso.bankingapps.domain.User;
import com.herusantoso.bankingapps.dto.ChangePasswordDTO;
import com.herusantoso.bankingapps.dto.UserCreateDTO;
import com.herusantoso.bankingapps.dto.UserDetailDTO;
import com.herusantoso.bankingapps.exception.BadRequestException;
import com.herusantoso.bankingapps.mapper.UserMapper;
import com.herusantoso.bankingapps.repository.RoleRepository;
import com.herusantoso.bankingapps.repository.UserRepository;
import com.herusantoso.bankingapps.service.UserService;
import com.herusantoso.bankingapps.util.AuthenticationUtil;
import com.herusantoso.bankingapps.util.Constants;
import com.herusantoso.bankingapps.validation.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AuthenticationUtil authenticationUtil;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Boolean createUser(UserCreateDTO userDTO) {
        userValidator.createValidation(userDTO);

        User user = UserMapper.INSTANCE.toEntity(userDTO, new User());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findByName(Constants.Role.USER)
                .orElseThrow(() -> new BadRequestException("Role not found")));
        user.setRoles(roles);
        userRepository.save(user);
        return Boolean.TRUE;
    }

    @Override
    public Boolean changePassword(ChangePasswordDTO changePasswordDTO) {
        User user = authenticationUtil.getCurrentUser();

        if(passwordEncoder.matches(changePasswordDTO.getOldPassword(), user.getPassword())){
            if(changePasswordDTO.getNewPassord().equals(changePasswordDTO.getConfirmPassword())){
                user.setPassword(passwordEncoder.encode(changePasswordDTO.getConfirmPassword()));
                userRepository.save(user);
            } else {
                throw new BadRequestException("Confirm password doesnt match");
            }
        } else {
            throw new BadRequestException("Invalid password");
        }
        return Boolean.TRUE;
    }

    @Override
    public UserDetailDTO getDetail() {
        User user = authenticationUtil.getCurrentUser();
        return UserMapper.INSTANCE.toDTO(user, new UserDetailDTO());
    }
}
