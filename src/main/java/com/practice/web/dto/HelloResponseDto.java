package com.practice.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class HelloResponseDto {

    private String name;
    private int amount;

    @Builder
    public HelloResponseDto(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }
}
