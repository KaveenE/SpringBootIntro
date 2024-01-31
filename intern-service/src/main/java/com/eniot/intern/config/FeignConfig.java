package com.eniot.intern.config;

import com.eniot.intern.models.FeignExceptionDecoder;
import feign.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
@Slf4j
public class FeignConfig {
  @Bean
  Logger.Level feignLoggerLevel() {
    log.info("feignLoggerLevel()");
    return Logger.Level.HEADERS;
  }

  @Bean
  FeignExceptionDecoder errorDecode() {
    log.info("errorDecode()");
    return new FeignExceptionDecoder();
  }

}



