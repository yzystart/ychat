package com.yzy.conf;


import com.yzy.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Result> handleException(Exception e) {
        log.error("发生了错误：{}",e.getMessage());
        return new ResponseEntity<>(Result.error("服务繁忙！"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

