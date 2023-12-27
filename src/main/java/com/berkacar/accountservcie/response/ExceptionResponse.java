package com.berkacar.accountservcie.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class ExceptionResponse {
    private HttpStatus httpStatus;
    private String errorMessage;
    private String description;
    private LocalDateTime dateTime;
}
