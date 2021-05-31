package com.trello.contoller;

import com.trello.controller.BoardController;
import com.trello.entity.Card;
import com.trello.pojo.Cards;
import com.trello.service.BoardService;
import com.trello.service.CardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BoardController.class)
public class BoardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BoardService boardService;

    @MockBean
    private CardService cardService;

    @Test
    public void retrieveCardByTags() throws Exception {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(1,"card1","level1","tag1", true, "30-05-2021T10:16:21",1,1));
        cardList.add(new Card(2,"card3","level3","tag1", true, "30-05-2021T10:16:21",1,1));
        List<Cards> cards = Cards.setCartsDetails(cardList);

        Mockito.when(cardService.getAllCardByTag(Mockito.anyString())).thenReturn(cards);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/cards/tag1").accept(
                MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        assertEquals(result.getResponse().getStatus(),200);

    }

    @Test
    public void retrieveCardByColumnName() throws Exception {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(1,"card1","level1","tag1", true, "30-05-2021T10:16:21",1,1));
        cardList.add(new Card(2,"card3","level3","tag1", true, "30-05-2021T10:16:21",1,1));
        List<Cards> cards = Cards.setCartsDetails(cardList);

        Mockito.when(cardService.getAllCardByColumn(Mockito.anyString())).thenReturn(cards);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/column/cards/todo").accept(
                MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        assertEquals(result.getResponse().getStatus(),200);

    }

    @Test
    public void retrieveCardByTimestamp() throws Exception {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(1,"card1","level1","tag1", true, "30-05-2021T10:16:21",1,1));
        cardList.add(new Card(2,"card3","level3","tag1", true, "30-05-2021T10:16:21",1,1));
        List<Cards> cards = Cards.setCartsDetails(cardList);

        Mockito.when(cardService.getAllCardByTimestamp(Mockito.anyString())).thenReturn(cards);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/column/cards?timestamp=30-05-2021T10:16:21").accept(
                MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        assertEquals(result.getResponse().getStatus(),200);

    }
}
