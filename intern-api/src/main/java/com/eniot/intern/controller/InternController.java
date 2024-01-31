package com.eniot.intern.controller;

import com.eniot.intern.lib.entity.Intern;
import com.eniot.intern.service.InternService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class InternController {
  private final InternService service;

  @PostMapping("create")
  @ResponseStatus(HttpStatus.OK)
  @Operation(summary = "Create an intern, nth much",
          description = "I will try to come up with some meaningful API" +
                  "\n and make it not too simplistic")
  public Intern hireIntern(@Valid @RequestBody Intern newIntern) {
    log.info("hireIntern: {}", newIntern);
    return service.hireIntern(newIntern);
  }

  @GetMapping("findAll")
  @ResponseStatus(HttpStatus.OK)
  @Operation(summary = "Search all intern, nth much again")
  public List<Intern> findAll() {

    log.info("findAll()");
    return service.findAll();
  }

  @GetMapping("search")
  @ResponseStatus(HttpStatus.OK)
  @Operation(summary = "Search up interns by name and/or school",
          description = "Name/School is case-insensitive")
  public List<Intern> searchIntern(@RequestParam
                                   @Parameter(description = "Eg:\n Both the values, Jack and jAcK are equivalent")
                                   String name,
                                   @RequestParam
                                   @Parameter(description = "Eg:\n Both the values, NuS and nus are equivalent")
                                   String school) {
    log.info("searchIntern: {}", name);
    return service.searchIntern(name, school);
  }
}
