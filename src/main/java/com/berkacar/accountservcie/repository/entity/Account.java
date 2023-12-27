package com.berkacar.accountservcie.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "accounts")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "accountMail",length = 200)
    private String accountMail;
    @Column(name = "accountUsername")
    private String accountUsername;
    @Column(name = "accountPassword")
    private String accountPassword;
    @Column(name = "accountDatetime")
    private LocalDateTime accountDatetime;
    @Column(name = "accountStatus")
    private int accountStatus;
    @Column(name = "accountServer")
    private String accountServer;
    @Column(name = "ipAdress")
    private String accountIpAddress;

}
