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

public class MessageApiControllerMvcTests {
    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private final MessageApiController underTest = new MessageApiController(false);
    private final MessageApiController underTestWithFeatureOn = new MessageApiController(true);
    private MockMvc mockMvc;
    private MockMvc mockMvcWithFeatureOn;

    @BeforeEach
    public void initMockMvc() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(underTest)
                .build();
        mockMvcWithFeatureOn = MockMvcBuilders
                .standaloneSetup(underTestWithFeatureOn)
                .build();
    }

    @Test
    void get_messages_returns_only_default_messages_with_feature_off() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/messages"))
                .andDo(print())
                .andReturn();

        assertThat(mvcResult.getResponse().getStatus()).isEqualTo(200);

        String json = mvcResult.getResponse().getContentAsString();
        final String[] messages = OBJECT_MAPPER.readValue(json, String[].class);
        assertThat(messages)
                .containsExactlyInAnyOrder("Available Products");
    }

    @Test
    void get_messages_returns_only_default_messages_with_feature_on() throws Exception {
        MvcResult mvcResult = mockMvcWithFeatureOn.perform(get("/api/messages"))
                .andDo(print())
                .andReturn();

        assertThat(mvcResult.getResponse().getStatus()).isEqualTo(200);

        String json = mvcResult.getResponse().getContentAsString();
        final String[] messages = OBJECT_MAPPER.readValue(json, String[].class);
        assertThat(messages)
                .containsExactlyInAnyOrder(
                        "Available Products", "New products available for sale !!!");
    }
}
