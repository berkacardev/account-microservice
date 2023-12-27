package com.berkacar.accountservcie.controller;

import com.berkacar.accountservcie.response.AccountResponse;
import com.berkacar.accountservcie.security.SecurityUser;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import com.berkacar.accountservcie.facade.AccountFacade;
import com.berkacar.accountservcie.request.AccountCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountFacade accountFacade;

    @Autowired
    public AccountController(AccountFacade accountFacade) {
        this.accountFacade = accountFacade;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<AccountResponse> getAccounts(
            HttpServletRequest request,
            @RequestHeader(name = "userName", required = false) String userName,
            @RequestHeader(name = "password", required = false) String password
    ) {
        SecurityUser securityUser = SecurityUser.builder()
                .userName(userName)
                .userPassword(password)
                .build();
        return accountFacade.getAccounts(securityUser, request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public AccountResponse createAccounts(
            HttpServletRequest request,
            @RequestHeader(name = "userName", required = false) String userName,
            @RequestHeader(name = "password", required = false) String password,
            @RequestBody AccountCreateRequest accountCreateRequest
    ) {
        SecurityUser securityUser = SecurityUser.builder()
                .userName(userName)
                .userPassword(password)
                .build();
        return accountFacade.createAccount(securityUser, accountCreateRequest, request);
    }
}
