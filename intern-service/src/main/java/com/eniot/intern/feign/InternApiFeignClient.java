package com.eniot.intern.feign;

import com.eniot.intern.lib.entity.Intern;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="dummyName", url="${intern-api.url}")
public interface InternApiFeignClient {
  @PostMapping("create")
  Intern hireIntern(@RequestBody Intern newIntern);

  @GetMapping("findAll")
  List<Intern> findAll();

  @GetMapping("search")
  List<Intern> searchIntern(@RequestParam String name);
}