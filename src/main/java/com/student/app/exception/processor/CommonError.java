package com.student.app.exception.processor;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class CommonError {
    private final String message;
    private final HttpStatus status;
    private final LocalDateTime timestamp;

}
