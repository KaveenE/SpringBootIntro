package com.eniot.intern;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.*;

import java.util.Arrays;
import java.util.stream.StreamSupport;

/**
 * Spring Boot application starter class
 */
@SpringBootApplication
@Slf4j
public class InternApiApp {
  public static void main(String[] args) {
    SpringApplication.run(InternApiApp.class, args);
  }
  //What does the below method do?

  @EventListener
  public void handleContextRefresh(ContextRefreshedEvent event) {
    final Environment env = event.getApplicationContext()
            .getEnvironment();

    log.info("Active profiles: {}", Arrays.toString(env.getActiveProfiles()));

    final MutablePropertySources sources = ((AbstractEnvironment) env).getPropertySources();

    StreamSupport.stream(sources.spliterator(), false)
            .filter(ps -> ps instanceof MapPropertySource)
            .map(ps -> ((MapPropertySource) ps).getPropertyNames())
            .flatMap(Arrays::stream)
            .distinct()
            .filter(prop -> prop.contains("spring"))
            .forEach(prop -> log.info("{}: {}", prop, env.getProperty(prop)));
  }
}