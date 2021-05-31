package com.trello.service;

import com.trello.dao.CardRepository;
import com.trello.dao.ColumnRepository;
import com.trello.dao.UserRepository;
import com.trello.entity.Card;
import com.trello.pojo.Cards;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CardServiceTest {
    @InjectMocks
    CardService cardService;

    @Mock
    CardRepository cardRepository;

    @Mock
    ColumnRepository columnRepository;

    @Mock
    UserRepository userRepository;

    @Test
    public void findCardByTag() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(1,"card1","level1","tag1", true, "30-05-2021T10:16:21",1,1));
        cardList.add(new Card(2,"card3","level3","tag1", true, "30-05-2021T10:16:21",1,1));
        Mockito.when(cardRepository.findByTag("tag1")).thenReturn(cardList);
        List<Cards> cardLists = cardService.getAllCardByTag("tag1");
        assertEquals(cardLists.get(0).getCardName(), cardLists.get(0).getCardName());
    }

    @Test
    public void findCardByTimeStamp() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(1,"card1","level1","tag1", true, "30-05-2021T10:16:21",1,1));
        cardList.add(new Card(2,"card3","level3","tag1", true, "30-05-2021T10:16:21",1,1));
        Mockito.when(cardRepository.findAll()).thenReturn(cardList);
        List<Cards> cardLists = cardService.getAllCardByTimestamp("30-05-2021T09:16:21");
        assertEquals(cardLists.get(0).getCardName(), cardLists.get(0).getCardName());
    }

}
