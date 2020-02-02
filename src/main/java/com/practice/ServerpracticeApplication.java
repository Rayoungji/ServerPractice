package com.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing //Jpa Auditing 활성화
public class ServerpracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerpracticeApplication.class, args);
    }

}
