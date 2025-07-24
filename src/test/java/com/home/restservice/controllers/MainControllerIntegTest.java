package com.home.restservice.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerIntegTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void addPerson() throws Exception {
        String jsonRequest = "{\"name\":\"Скажем....Полуэкт\",\"age\":\"50\",\"snils\":\"1010\"}";

        var response = mockMvc.perform(
                post("/api/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest)
        ).andReturn();
        String resultJson = response.getResponse().getContentAsString();
        assertEquals("{\"id\":1,\"name\":\"Скажем....Полуэкт\",\"age\":\"50\",\"snils\":\"1010\"}", resultJson);
    }
}
