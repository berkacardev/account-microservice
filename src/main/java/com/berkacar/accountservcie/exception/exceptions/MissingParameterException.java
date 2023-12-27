package com.berkacar.accountservcie.exception.exceptions;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
@Getter
public class MissingParameterException extends RuntimeException{
    public MissingParameterException() {
        super();
        log.debug("[{} -> message/date: {}]", this.getClass(), LocalDateTime.now());
    }
}
