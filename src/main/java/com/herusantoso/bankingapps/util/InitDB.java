package com.herusantoso.bankingapps.util;

import com.herusantoso.bankingapps.domain.OauthClientDetail;
import com.herusantoso.bankingapps.domain.Role;
import com.herusantoso.bankingapps.repository.OauthClientDetailRepository;
import com.herusantoso.bankingapps.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class InitDB {

    @Autowired
    private OauthClientDetailRepository oauthClientDetailRepository;

    @Autowired
    private RoleRepository roleRepository;

    @PostConstruct
    public void init() {
        initOauthClientDetails();
        initRoles();
    }

    private void initOauthClientDetails(){
        List<OauthClientDetail> oauthClientDetailList = oauthClientDetailRepository.findAll();
        if(oauthClientDetailList.isEmpty()){
            OauthClientDetail oauthClientDetail = new OauthClientDetail();
            oauthClientDetail.setClientId("adminapp");
            oauthClientDetail.setResourceIds("mw/adminapp,ms/admin,ms/user");
            oauthClientDetail.setClientSecret("{bcrypt}$2a$10$EOs8VROb14e7ZnydvXECA.4LoIhPOoFHKvVF/iBZ/ker17Eocz4Vi");
            oauthClientDetail.setAuthorizedGrantTypes("authorization_code,password,refresh_token,implicit");
            oauthClientDetail.setWebServerRedirectUri(null);
            oauthClientDetail.setAuthorities(null);
            oauthClientDetail.setAdditionalInformation("{}");
            oauthClientDetail.setAutoApprove(null);
            oauthClientDetail.setAccessTokenValidity(9000L);
            oauthClientDetail.setRefreshTokenValidity(3600L);
            oauthClientDetail.setScope("write,read");
            oauthClientDetailRepository.save(oauthClientDetail);
        }
    }

    private void initRoles(){
        List<String> roleNames = Arrays.asList(Constants.Role.USER, Constants.Role.ADMIN);
        roleNames.stream()
                .forEach(roleName -> {
                    Optional<Role> roleFound = roleRepository.findByName(roleName);
                    if(!roleFound.isPresent()){
                        Role role = new Role();
                        role.setName(roleName);
                        roleRepository.save(role);
                    }
                });
    }
}
