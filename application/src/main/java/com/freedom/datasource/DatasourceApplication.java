package com.freedom.datasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DatasourceApplication {

  public static void main(String[] args) {
    SpringApplication.run(DatasourceApplication.class, args);
  }
}
