package com.trello.service;

import com.trello.dao.CardRepository;
import com.trello.dao.ColumnRepository;
import com.trello.dao.UserRepository;
import com.trello.entity.BoardColumn;
import com.trello.entity.User;
import com.trello.pojo.Cards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    ColumnRepository columnRepository;

    @Autowired
    UserRepository userRepository;

    public List<Cards> getAllCardByTag(String tag) {
        List<Cards> cardList = Cards.setCartsDetails(cardRepository.findByTag(tag));
        return cardList;
    }

    public List<Cards> getAllCardByColumn(String columnName) {
        List<BoardColumn> columnList = columnRepository.findByColumnName(columnName);
        Set<Integer> columnId = columnList.stream().map(column -> column.getId()).collect(Collectors.toSet());
        List<Cards> cardList = Cards.setCartsDetails(cardRepository.findByColumnIdIn(columnId));
        return cardList;
    }

    public List<Cards> getAllCardByTimestamp(String timestamp) {
        List<Cards> allCardList = Cards.setCartsDetails(cardRepository.findAll());
        List<Cards> cardList = new ArrayList<>();
        for (Cards card : allCardList) {
            if (card.getTimeStamp().compareTo(timestamp) > 0) {
                cardList.add(card);
            }
        }
        return cardList;
    }

    public List<Cards> getHighlightedCard(String userId) {
        List<Cards> cardList = new ArrayList<>();
        Optional<User> user = userRepository.findById(Integer.valueOf(userId));
        if (user.isPresent()) {
            cardList = Cards.setCartsDetails(cardRepository.findByAssignTo(Integer.valueOf(userId)));
            cardList = cardList.stream().
                    filter(card -> card.getHighlighted() == true)
                    .collect(Collectors.toList());
        }
        return cardList;
    }
}
