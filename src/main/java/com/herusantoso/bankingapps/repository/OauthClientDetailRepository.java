package com.herusantoso.bankingapps.repository;

import com.herusantoso.bankingapps.domain.OauthClientDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OauthClientDetailRepository extends JpaRepository<OauthClientDetail, String> {
}
