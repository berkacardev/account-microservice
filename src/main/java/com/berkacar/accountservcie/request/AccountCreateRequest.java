package com.berkacar.accountservcie.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountCreateRequest {
    private String accountMail;
    private String accountUsername;
    private String accountPassword;
    private String accountServer;
    private String accountIpAddress;
}
