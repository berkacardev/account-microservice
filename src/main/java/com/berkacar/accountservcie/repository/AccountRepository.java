package com.berkacar.accountservcie.repository;

import com.berkacar.accountservcie.repository.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {
}
