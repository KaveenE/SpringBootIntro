package com.eniot.intern.lib.models.webPojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseResponse<T> {
  @Builder.Default
  private Integer code = 200;
  @Builder.Default
  private String message = "Request was successful";
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String details;
  private T data;

}