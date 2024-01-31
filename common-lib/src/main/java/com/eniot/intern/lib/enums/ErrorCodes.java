package com.eniot.intern.lib.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCodes {
  /*
   * Common Errors
   */
  COM_001(1001, "An unknown error has occurred in the system."),
  COM_002(1002, "Invalid field data error"),
  COM_003(1003, "Duplicate field data error");

  private final int intCode;
  private final String description;
  @Override
  public String toString() {
    return intCode + ": " + description;
  }
}
