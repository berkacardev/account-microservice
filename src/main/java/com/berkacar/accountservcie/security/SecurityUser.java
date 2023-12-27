package com.berkacar.accountservcie.security;

import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@Builder
public class SecurityUser {
    private String userName;
    private String userPassword;
}
