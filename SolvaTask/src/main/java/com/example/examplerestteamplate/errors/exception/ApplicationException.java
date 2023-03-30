package com.example.examplerestteamplate.errors.exception;

import com.example.examplerestteamplate.errors.model.ApplicationError;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor(staticName = "of")
public class ApplicationException extends RuntimeException {
    private ApplicationError error;
}
