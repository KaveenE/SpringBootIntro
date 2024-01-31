package com.eniot.intern.lib.exception;

import com.eniot.intern.lib.enums.ErrorCodes;

public class FieldException extends InternalException {
  public FieldException(String message, Throwable cause) {
    super(message, cause, ErrorCodes.COM_002);
  }

  public FieldException(String message) {
    super(message, ErrorCodes.COM_002);
  }

  public FieldException(Throwable cause) {
    super(cause, ErrorCodes.COM_002);
  }
}
