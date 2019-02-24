package com.herusantoso.bankingapps.resource;

import com.herusantoso.bankingapps.dto.ChangePasswordDTO;
import com.herusantoso.bankingapps.dto.UserCreateDTO;
import com.herusantoso.bankingapps.dto.UserDetailDTO;
import com.herusantoso.bankingapps.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1")
public class UserResource {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Register new user")
    @PostMapping("/user")
    public ResponseEntity<Boolean> createUser(@Valid @RequestBody UserCreateDTO userDTO) {
        Boolean result = userService.createUser(userDTO);
        return ResponseEntity.ok().body(result);
    }

    @ApiOperation(value = "Change password user")
    @PreAuthorize("isAuthenticated()")
    @PutMapping("/user/change-password")
    public ResponseEntity<Boolean> changePassword(@Valid @RequestBody ChangePasswordDTO changePasswordDTO) {
        Boolean result = userService.changePassword(changePasswordDTO);
        return ResponseEntity.ok().body(result);
    }

    @ApiOperation(value = "Get user profile")
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/user")
    public ResponseEntity<UserDetailDTO> getProfile() {
        UserDetailDTO result = userService.getDetail();
        return ResponseEntity.ok().body(result);
    }

}
