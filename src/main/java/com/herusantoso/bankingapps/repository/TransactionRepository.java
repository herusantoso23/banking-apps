package com.herusantoso.bankingapps.repository;

import com.herusantoso.bankingapps.domain.Transaction;
import com.herusantoso.bankingapps.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

//    List<Transaction> findByUsers(User user);

    List<Transaction> findByUsers(User user);

}
