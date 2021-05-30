package com.trello.contoller;

import com.trello.controller.BoardController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BoardController.class)
public class BoardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void retrieveBoardDetails() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/board")).andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.header().string("Content-Type", "text/plain;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.header().string("Content-Length", "11"));
    }
}
