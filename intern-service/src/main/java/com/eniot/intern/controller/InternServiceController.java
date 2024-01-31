package com.eniot.intern.controller;

import com.eniot.intern.feign.InternApiFeignClient;
import com.eniot.intern.lib.entity.Intern;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class InternServiceController {
  private final InternApiFeignClient feignClient;

  /**
   * Some random method tbh
   * @param newbs Interns that are to be hired
   * @return All interns hired so far (not only those created)
   */
  @PostMapping("hireMany")
  @ResponseStatus(HttpStatus.OK)
  @Operation(summary = "Create multiple interns",
          description = "Return value will be all the interns in db")
  public List<Intern> hireManyIntern(@RequestBody List<Intern> newbs) {
    log.info("hireManyIntern: {}", newbs);

    newbs.forEach(feignClient::hireIntern);

    return feignClient.findAll();
  }
}