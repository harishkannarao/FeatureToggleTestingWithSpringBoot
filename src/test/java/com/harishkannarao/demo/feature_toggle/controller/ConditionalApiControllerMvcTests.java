package com.harishkannarao.demo.feature_toggle.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public class ConditionalApiControllerMvcTests {

    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private final ConditionalApiController underTest = new ConditionalApiController();
    private MockMvc mockMvc;

    @BeforeEach
    public void initMockMvc() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(underTest)
                .build();
    }

    @Test
    public void test_getMessages_returns_expected_message() throws Exception {
        MvcResult mvcResult = mockMvc
                .perform(get("/api/conditional"))
                .andDo(print())
                .andReturn();
        assertThat(mvcResult.getResponse().getStatus()).isEqualTo(200);

        String json = mvcResult.getResponse().getContentAsString();
        String[] result = OBJECT_MAPPER.readValue(json, String[].class);

        assertThat(result)
                .containsExactlyInAnyOrder("I am available!!!");
    }
}
