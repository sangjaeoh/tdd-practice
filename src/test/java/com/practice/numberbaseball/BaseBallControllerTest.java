package com.practice.numberbaseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BaseBallController.class)
class BaseBallControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    BaseBallServiceImpl baseBallService;

    @Test
    @DisplayName("숫자야구 게임 테스트")
    void playBaseBall() throws Exception {

        List<BaseBall> inputs = new ArrayList<>();
        inputs.add(new BaseBall("123", 1, 1));
        inputs.add(new BaseBall("356", 1, 0));
        inputs.add(new BaseBall("327", 2, 0));
        inputs.add(new BaseBall("489", 0, 1));
        //given
        given(baseBallService.play(inputs)).willReturn(2);

        //andExpect
        mockMvc.perform(get("/api/v1/baseball/play")
                        .param("input",
                                "4\n" +
                                "123 1 1\n" +
                                "356 1 0\n" +
                                "327 2 0\n" +
                                "489 0 1"))
                        .andExpect(status().isOk())
                        .andExpect(content().string("2"))
                        .andDo(print());

        //verify
        verify(baseBallService).play(inputs);
    }
}