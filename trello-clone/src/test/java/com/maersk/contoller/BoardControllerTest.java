package com.maersk.contoller;

import com.maersk.controller.BoardController;
import com.maersk.pojo.Boards;
import com.maersk.pojo.Cards;
import com.maersk.pojo.Columns;
import com.maersk.service.BoardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
