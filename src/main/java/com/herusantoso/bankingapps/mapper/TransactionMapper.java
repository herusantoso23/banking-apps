package com.herusantoso.bankingapps.mapper;

import com.herusantoso.bankingapps.domain.Transaction;
import com.herusantoso.bankingapps.domain.User;
import com.herusantoso.bankingapps.dto.TransactionHistoryDTO;
import com.herusantoso.bankingapps.dto.TransactionResponseDTO;
import com.herusantoso.bankingapps.dto.UserCreateDTO;
import com.herusantoso.bankingapps.dto.UserDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    @Mapping(source = "entity", target = "transactionDate", qualifiedByName = "transactionDate")
    @Mapping(source = "users.email", target = "email")
    TransactionResponseDTO toDTO(Transaction entity, @MappingTarget TransactionResponseDTO dto);

    @Mapping(source = "entity", target = "transactionDate", qualifiedByName = "transactionDate")
    TransactionHistoryDTO toHistoryDTO(Transaction entity, @MappingTarget TransactionHistoryDTO dto);

    @Named("transactionDate")
    default Long transactionDate(Transaction transaction){
        return transaction.getCreationDate().toEpochMilli();
    }

}
