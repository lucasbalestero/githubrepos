package com.balestero.githubrepos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "username not found")
public class UsernameNotFoundException extends RuntimeException {
}
