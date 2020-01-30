package com.practice.web.dto;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class HelloResponseDtoTest {

    @Test
    public void test(){
        //given (준비)
        String name="test";
        int amount=1000;

        //when(검증)
        HelloResponseDto helloResponseDto=HelloResponseDto.builder()
                .name(name)
                .amount(amount).build();

        //then(결과)
        assertThat(helloResponseDto.getName()).isEqualTo(name);
        assertThat(helloResponseDto.getAmount()).isEqualTo(amount);
    }
}
