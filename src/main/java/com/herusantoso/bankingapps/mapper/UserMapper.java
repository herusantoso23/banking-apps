package com.herusantoso.bankingapps.mapper;

import com.herusantoso.bankingapps.domain.User;
import com.herusantoso.bankingapps.dto.UserCreateDTO;
import com.herusantoso.bankingapps.dto.UserDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "email", target = "username")
    @Mapping(source = "email", target = "email")
    User toEntity(UserCreateDTO dto, @MappingTarget User entity);

    UserDetailDTO toDTO(User entity, @MappingTarget UserDetailDTO dto);

}
