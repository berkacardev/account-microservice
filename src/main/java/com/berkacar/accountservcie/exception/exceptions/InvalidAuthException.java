package com.berkacar.accountservcie.exception.exceptions;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
public class InvalidAuthException extends RuntimeException {
    public InvalidAuthException() {
        log.debug("[{} -> message/date: {}]", this.getClass(), LocalDateTime.now());
    }
}
