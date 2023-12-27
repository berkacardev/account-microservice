package com.berkacar.accountservcie.facade;

import com.berkacar.accountservcie.request.AccountCreateRequest;
import com.berkacar.accountservcie.response.AccountResponse;
import com.berkacar.accountservcie.security.SecurityUser;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface AccountFacade {
    List<AccountResponse> getAccounts(SecurityUser securityUser, HttpServletRequest request);
    AccountResponse createAccount(SecurityUser securityUser, AccountCreateRequest accountCreateRequest, HttpServletRequest request);
}
