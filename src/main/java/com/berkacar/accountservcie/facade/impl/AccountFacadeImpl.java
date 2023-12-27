package com.berkacar.accountservcie.facade.impl;

import com.berkacar.accountservcie.exception.exceptions.MissingParameterException;
import com.berkacar.accountservcie.repository.entity.Account;
import com.berkacar.accountservcie.request.AccountCreateRequest;
import com.berkacar.accountservcie.response.AccountResponse;
import com.berkacar.accountservcie.security.SecurityService;
import com.berkacar.accountservcie.security.SecurityUser;
import com.berkacar.accountservcie.service.AccountService;
import jakarta.servlet.http.HttpServletRequest;
import com.berkacar.accountservcie.facade.AccountFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccountFacadeImpl implements AccountFacade {

    private final AccountService accountService;
    private final SecurityService securityService;


    @Autowired
    public AccountFacadeImpl(AccountService accountService, SecurityService securityService) {
        this.accountService = accountService;
        this.securityService = securityService;
    }

    @Override
    public List<AccountResponse> getAccounts(SecurityUser securityUser, HttpServletRequest request) {
        controlSecurity(securityUser);
        return accountService.getAccounts().stream().map(this::convertToAccountResponse).toList();
    }

    @Override
    public AccountResponse createAccount(SecurityUser securityUser, AccountCreateRequest accountCreateRequest, HttpServletRequest request) {
        controlSecurity(securityUser);
        setIpAddress(accountCreateRequest,request);
        return convertToAccountResponse(accountService.createAccount(convertToAccount(accountCreateRequest)));
    }


    private void controlSecurity(SecurityUser securityUser) {
        if (securityUser.getUserName() == null || securityUser.getUserPassword() == null) {
            throw new MissingParameterException();
        }
        securityService.controlSecurity(securityUser);
    }

    private void setIpAddress(AccountCreateRequest accountCreateRequest, HttpServletRequest request) {
        if (accountCreateRequest.getAccountIpAddress().equals("-") || accountCreateRequest.getAccountIpAddress().isEmpty()) {
            String remoteIpAddress = request.getRemoteAddr();
            if (remoteIpAddress.equals("0:0:0:0:0:0:0:1")) {
                remoteIpAddress = "127.0.0.1";
            }
            accountCreateRequest.setAccountIpAddress(remoteIpAddress);
        }

    }

    private Account convertToAccount(AccountCreateRequest accountCreateRequest) {
        return Account.builder()
                .accountMail(accountCreateRequest.getAccountMail())
                .accountUsername(accountCreateRequest.getAccountUsername())
                .accountPassword(accountCreateRequest.getAccountPassword())
                .accountDatetime(LocalDateTime.now())
                .accountStatus(1)
                .accountServer(accountCreateRequest.getAccountServer())
                .accountIpAddress(accountCreateRequest.getAccountIpAddress())
                .build();
    }

    private AccountResponse convertToAccountResponse(Account account) {
        return AccountResponse.builder()
                .id(account.getId())
                .accountMail(account.getAccountMail())
                .accountUsername(account.getAccountUsername())
                .accountDatetime(account.getAccountDatetime())
                .accountStatus(account.getAccountStatus())
                .accountServer(account.getAccountServer())
                .accountIpAddress(account.getAccountIpAddress())
                .build();
    }
}
