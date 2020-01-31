package com.practice.web.hello.controller;

import com.practice.web.hello.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        HelloResponseDto helloResponseDto=HelloResponseDto.builder()
                .name(name)
                .amount(amount).build();
        return helloResponseDto;
    }
}
