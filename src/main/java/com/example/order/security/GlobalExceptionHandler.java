package com.example.order.security;

import com.example.order.Result;
import com.example.order.enums.ResultEnum;
import com.example.order.exception.ServerErrorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ServerErrorException.class})
    public Result<?> exception500(Exception ex) {
        log.error(ex.getMessage());
        return Result.error(ResultEnum.ERROR_500);
    }

    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @ExceptionHandler(IllegalArgumentException.class)
    public Result<?> exception501(Exception e){
        log.error(e.getMessage());
        return Result.error(ResultEnum.ERROR_501);
    }
}
