package com.berkacar.accountservcie.security.impl;

import com.berkacar.accountservcie.exception.exceptions.InvalidAuthException;
import com.berkacar.accountservcie.security.SecurityService;
import com.berkacar.accountservcie.security.SecurityUser;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {

    private static final String userName = "userName";
    private static final String password = "password";
    @Override
    public void controlSecurity(SecurityUser securityUser) {
        if (!(securityUser.getUserName().equals(userName) && securityUser.getUserPassword().equals(password))){
            throw new InvalidAuthException();
        }
    }
}
