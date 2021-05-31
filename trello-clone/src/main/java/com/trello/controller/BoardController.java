package com.trello.controller;

import com.trello.exception.BoardException;
import com.trello.pojo.Boards;
import com.trello.pojo.Cards;
import com.trello.service.BoardService;
import com.trello.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Boards>> getAllBoards() {
        List<Boards> boardList = boardService.getAllBoard();
        if (boardList.isEmpty()) {
            throw new BoardException("Board Not Found");
        }
        return new ResponseEntity<>(boardList, HttpStatus.OK);
    }

    //Get  list of cards that containing tag
    @RequestMapping("/cards/{tag}")
    public ResponseEntity<List<Cards>> getAllCardsByTag(@PathVariable String tag){
        List<Cards> cardList =  cardService.getAllCardByTag(tag);
        if(cardList.isEmpty()) {
            throw new BoardException("Card Not Found");
        }
        return new ResponseEntity<>(cardList, HttpStatus.OK);
    }

    //Get list of cards in a column
    @RequestMapping("/column/cards/{columnName}")
    public ResponseEntity<List<Cards>> getAllCardsInColumn(@PathVariable String columnName){
        List<Cards> cardList =  cardService.getAllCardByColumn(columnName);
        if(cardList.isEmpty()) {
            throw new BoardException("Card Not Found");
        }
        return new ResponseEntity<>(cardList, HttpStatus.OK);
    }
    //Get list of cards based on created time
    @RequestMapping("/column/cards")
    public ResponseEntity<List<Cards>> getAllCardByTimestamp(@RequestParam String timestamp) {
        List<Cards> cardList =  cardService.getAllCardByTimestamp(timestamp);
        if(cardList.isEmpty()) {
            throw new BoardException("Card Not Found");
        }
        return new ResponseEntity<>(cardList, HttpStatus.OK);
    }

    //Get Highlighted Card
    @RequestMapping("/highlightedCard")
    public ResponseEntity<List<Cards>> getHighlightedCard(@RequestHeader("user-id") String userId) {
        List<Cards> cardList = cardService.getHighlightedCard(userId);
        if(cardList.isEmpty()) {
            throw new BoardException("Highlighted Card Not Found");
        }
        return new ResponseEntity<>(cardList, HttpStatus.OK);
    }
}

