package com.balestero.githubrepos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "the provided token is invalid")
public class InvalidTokenException extends RuntimeException{
}
