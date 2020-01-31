package com.practice.web;

import com.practice.web.hello.controller.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
//외부연동과 관련된 부분만 테스트 가능(restapi가 잘 되는지)
public class HelloControllerTest {


   //테스트 클래스에서 테스트 된 클래스에는 @InjectMocks 주석을 달아야 한다
    @InjectMocks
    private HelloController helloController;

    private MockMvc mockMvc;

    @Test
    public void hello() throws Exception {
        String hello = "hello";

        mockMvc = MockMvcBuilders.standaloneSetup(helloController).build();


        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDto() throws Exception {
        String name = "라영지";
        int amount = 10000;

        mockMvc = MockMvcBuilders.standaloneSetup(helloController).build();

        mockMvc.perform(get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));


    }

}
