package com.berkacar.accountservcie.service;

import com.berkacar.accountservcie.repository.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAccounts();
    Account createAccount(Account account);
}
