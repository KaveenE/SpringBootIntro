package com.eniot.intern.interceptorOrAop;


import com.eniot.intern.lib.enums.ErrorCodes;
import com.eniot.intern.lib.exception.InternalException;
import com.eniot.intern.lib.exception.OpenFeignException;
import com.eniot.intern.lib.models.webPojo.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  @ExceptionHandler
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public BaseResponse<Void> handleInternalException(HttpServletRequest request, InternalException ex) {
    log.error("Internal Exception occurred: {}, URL: {}", ex, request.getRequestURL());
    return BaseResponse.<Void>builder()
            .code(ex.getCode().getIntCode())
            .message(ex.getMessage())
            .build();

  }

  @ExceptionHandler()
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public BaseResponse<Void> handleException(HttpServletRequest request, Exception ex) {
    log.error("Unexpected Exception occurred: {}, URL: {}", ex, request.getRequestURL());
    return BaseResponse.<Void>builder()
            .code(ErrorCodes.COM_001.getIntCode())
            .message(ex.getMessage())
            .build();
  }

  @ExceptionHandler
  public ResponseEntity<BaseResponse<Void>> handleFeignException(HttpServletRequest request, OpenFeignException ex) {
    log.error("Feign-related Exception occurred: {}, URL: {}", ex.getMessage(), request.getRequestURL());
    BaseResponse<Void> res =  BaseResponse.<Void>builder()
            .code(ErrorCodes.COM_001.getIntCode())
            .message(ex.getMessage())
            .build();
    return ResponseEntity.status(ex.getHttpStatus()).body(res);
  }

  @ExceptionHandler
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public BaseResponse<Void> handleConstraintViolationException(ConstraintViolationException ex) {
    return BaseResponse.<Void>builder()
            .code(ErrorCodes.COM_002.getIntCode())
            .message(ex.getMessage())
            .build();
  }

  @ExceptionHandler
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public BaseResponse<Void> handleMethodArgumentException(MethodArgumentNotValidException ex) {
    return BaseResponse.<Void>builder()
            .code(ErrorCodes.COM_002.getIntCode())
            .message(ex.getMessage())
            .build();
  }
}
