package com.berkacar.accountservcie.response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountResponse {
    private int id;
    private String accountMail;
    private String accountUsername;
    private LocalDateTime accountDatetime;
    private int accountStatus;
    private String accountServer;
    private String accountIpAddress;
}
