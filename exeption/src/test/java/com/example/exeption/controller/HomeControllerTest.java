package com.example.exeption.controller;

import com.example.exeption.dto.MemberRegisterDto;
import com.example.exeption.repository.MemberRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@DisplayName("홈 컨트롤러 단위 테스트")
@SpringBootTest
@AutoConfigureMockMvc
class HomeControllerTest {

    @MockBean
    MemberRepository memberRepository;

    @Autowired
    MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("멤버 추가 API 테스트")
    void create() throws Exception {
        String content = objectMapper.writeValueAsString(
                new MemberRegisterDto.Request("이름입니다", "email@email.com", 14, 2000));

        mvc.perform(post("/member")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(jsonPath("$.code").value("C001"))
                .andDo(print());
    }
}