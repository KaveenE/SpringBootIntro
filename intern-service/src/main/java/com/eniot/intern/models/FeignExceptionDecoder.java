package com.eniot.intern.models;

import com.eniot.intern.lib.enums.ErrorCodes;
import com.eniot.intern.lib.exception.OpenFeignException;
import com.eniot.intern.lib.models.webPojo.BaseResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Optional;


@RequiredArgsConstructor
@Slf4j
public class FeignExceptionDecoder implements ErrorDecoder {

  @Override
  public Exception decode(String methodKey, Response response) {
    log.error("decode() with parameters {}, {}", methodKey, response);

    FeignException feignException = FeignException.errorStatus(methodKey, response);
    BaseResponse<Void> feignErrorModel;

    try {
      feignErrorModel = new ObjectMapper().readValue(feignException.contentUTF8(), BaseResponse.class);
    } catch (IOException ex) {
      log.error("readValue() failed: "+ ex +"");
      return feignException;
    }

    return Optional.ofNullable(feignErrorModel)
            .map(errResp -> new OpenFeignException(feignErrorModel.getMessage()+"("+feignErrorModel.getCode()+")",
                    feignException, ErrorCodes.COM_001, response.status()))
            .orElseThrow(() -> feignException);
  }
}