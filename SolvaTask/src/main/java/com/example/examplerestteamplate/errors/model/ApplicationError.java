package com.example.examplerestteamplate.errors.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor(staticName = "of")
@Data
public class ApplicationError {
    private String error;
    private ErrorType errorType;
    private LocalDateTime time;
    private HttpStatus status;

    public ApplicationError(String message, ErrorType type, HttpStatus status) {
        this.error = message;
        this.errorType = type;
        this.status = status;
    }
}
