package com.eniot.intern.lib.exception;


import com.eniot.intern.lib.enums.ErrorCodes;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
public class InternalException extends RuntimeException {
  private ErrorCodes code;
  private String message;
  private Throwable cause;

  public InternalException(String message, Throwable cause, ErrorCodes code) {
    this.message = message;
    this.cause = cause;
    this.code = code;
  }

  public InternalException(String message, ErrorCodes code) {
    this.message = message;
    this.code = code;
  }

  public InternalException(Throwable cause, ErrorCodes code) {
    this.cause = cause;
    this.code = code;
  }

  @Override
  public String getMessage() {
    return new StringBuilder(this.message)
            .append("--> ")
            .append("[Error code ")
            .append(code.getIntCode())
            .append("]:")
            .append(code.getDescription())
            .toString();

  }

}
