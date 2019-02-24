package com.herusantoso.bankingapps.service;

import com.herusantoso.bankingapps.dto.ChangePasswordDTO;
import com.herusantoso.bankingapps.dto.UserCreateDTO;
import com.herusantoso.bankingapps.dto.UserDetailDTO;

public interface UserService {

    Boolean createUser(UserCreateDTO userDTO);

    Boolean changePassword(ChangePasswordDTO changePasswordDTO);

    UserDetailDTO getDetail();

}
