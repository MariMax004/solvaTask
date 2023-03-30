package com.example.examplerestteamplate.errors;

import com.example.examplerestteamplate.errors.exception.ApplicationException;
import com.example.examplerestteamplate.errors.model.ApplicationError;
import com.example.examplerestteamplate.errors.model.ErrorType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;

@Getter
@AllArgsConstructor
public enum ErrorDescriptor {
    NOT_FOUND("Метод не найден", ErrorType.APP, HttpStatus.BAD_REQUEST),
    TYPE_NOT_FOUND("Данного типа не существует", ErrorType.APP, HttpStatus.BAD_REQUEST),
    NOT_FIRST_LIMIT("Лимит можно изменять только один раз", ErrorType.APP, HttpStatus.BAD_REQUEST),
    NOT_BANK_ACCOUNT("Клиента с таким счетом нет", ErrorType.DATA_BASE, HttpStatus.BAD_REQUEST),
    NO_SUM("Сумма не введена или введена неверно", ErrorType.DATA_BASE, HttpStatus.BAD_REQUEST),
    NO_CURRENCY("Валюта не введена или введена неверно", ErrorType.DATA_BASE, HttpStatus.BAD_REQUEST),
    NO_BANK_ACCOUNT("Банк аккаунт не введен или введен неверно", ErrorType.DATA_BASE, HttpStatus.BAD_REQUEST);


    private final String message;
    private final ErrorType type;
    private final HttpStatus status;


    public void exception() {
        throw ApplicationException.of(applicationError());
    }

    public void throwIsTrue(Boolean flag) {
        if (flag) {
            exception();
        }
    }

    public void throwIsFalse(Boolean flag) {
        if (!flag) {
            exception();
        }
    }

    public void throwIsNull(Object object) {
        if (ObjectUtils.isEmpty(object)) {
            exception();
        }
    }

    public ApplicationError applicationError() {
        return new ApplicationError(this.message, this.type, this.status);
    }

    public ApplicationException throwApplication() {
        return ApplicationException.of(applicationError());
    }
}
