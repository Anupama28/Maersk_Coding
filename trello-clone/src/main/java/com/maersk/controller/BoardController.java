package com.maersk.controller;

import com.maersk.entity.Board;
import com.maersk.entity.Card;
import com.maersk.exception.BoardException;
import com.maersk.pojo.Boards;
import com.maersk.pojo.Cards;
import com.maersk.service.BoardService;
import com.maersk.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private CardService cardService;

    // Get board JSON Object
    @RequestMapping("/board")
    public List<Boards> getAllBoards() {
        List<Boards> boardList = boardService.getAllBoard();
        if (boardList.isEmpty()) {
            throw new BoardException("Board Not Found");
        }
        return  boardList;
    }

    //Get  list of cards that containing tag
    @RequestMapping("/cards/{tag}")
    public List<Cards> getAllCards(@PathVariable String tag){
        List<Cards> cardList =  cardService.getAllCard(tag);
        if(cardList.isEmpty()) {
            throw new BoardException("Card Not Found");
        }
        return cardList;
    }

    //Get list of cards in a column
    @RequestMapping("/column/cards/{columnName}")
    public List<Cards> getAllCardsInColumn(@PathVariable String columnName){
        List<Cards> cardList =  cardService.getAllCardByColumn(columnName);
        if(cardList.isEmpty()) {
            throw new BoardException("Card Not Found");
        }
        return  cardList;
    }
    //Get list of cards based on created time
    @RequestMapping("/column/cards")
    public List<Cards> getAllCardByTimestamp(@RequestParam String timestamp) {
        List<Cards> cardList =  cardService.getAllCardByTimestamp(timestamp);
        if(cardList.isEmpty()) {
            throw new BoardException("Card Not Found");
        }
        return cardList;
    }

    //Get Highlighted Card
    @RequestMapping("/highlightedCard")
    public List<Cards> getHighlightedCard(@RequestHeader("user-id") String userId) {
        List<Cards> cardList = cardService.getHighlightedCard(userId);
        if(cardList.isEmpty()) {
            throw new BoardException("Highlighted Card Not Found");
        }
        return cardList;
    }
}

