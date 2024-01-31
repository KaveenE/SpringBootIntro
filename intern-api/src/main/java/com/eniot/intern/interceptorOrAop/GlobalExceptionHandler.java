package com.eniot.intern.interceptorOrAop;


import com.eniot.intern.lib.enums.ErrorCodes;
import com.eniot.intern.lib.models.webPojo.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
  @ExceptionHandler
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public BaseResponse<Void> handleIntegrityViolationException(SQLIntegrityConstraintViolationException ex) {
    return BaseResponse.<Void>builder()
            .code(ErrorCodes.COM_003.getIntCode())
            .message(ex.getMessage())
            .build();
  }
}
