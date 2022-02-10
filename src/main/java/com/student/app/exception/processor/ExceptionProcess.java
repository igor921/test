package com.student.app.exception.processor;

import com.student.app.exception.FileException;
import com.student.app.exception.DataParseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionProcess {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class})
    public CommonError globalHandler(Exception e) {
        return new CommonError("Internal error", HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({FileException.class, DataParseException.class})
    public CommonError handleFileFormatException(RuntimeException e) {
        return new CommonError(e.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now());
    }

}
