package com.eniot.intern.lib.exception;

import com.eniot.intern.lib.enums.ErrorCodes;
import lombok.Getter;


@Getter
public class OpenFeignException extends InternalException {
  private final Integer httpStatus;
  public OpenFeignException(String message, Throwable cause, ErrorCodes code, int httpStatus) {
    super(message, cause, code);
    this.httpStatus=httpStatus;
  }

  public OpenFeignException(String message, ErrorCodes code, int httpStatus) {
    super(message, code);
    this.httpStatus=httpStatus;

  }

  public OpenFeignException(Throwable cause, ErrorCodes code, int httpStatus) {
    super(cause, code);
    this.httpStatus=httpStatus;
  }
}