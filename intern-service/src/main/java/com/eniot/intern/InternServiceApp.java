package com.eniot.intern;

import com.eniot.intern.config.FeignConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Spring Boot application starter class
 */
@SpringBootApplication
@EnableFeignClients(defaultConfiguration = {FeignConfig.class})
public class InternServiceApp {
  public static void main(String[] args) {
    SpringApplication.run(InternServiceApp.class, args);
  }
}
