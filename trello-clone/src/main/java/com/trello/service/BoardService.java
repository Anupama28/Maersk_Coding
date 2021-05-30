package com.trello.service;

import com.trello.dao.BoardRepository;
import com.trello.dao.CardRepository;
import com.trello.dao.ColumnRepository;
import com.trello.entity.Board;
import com.trello.entity.BoardColumn;
import com.trello.entity.Card;
import com.trello.pojo.Boards;
import com.trello.pojo.Cards;
import com.trello.pojo.Columns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    List<Board> boardList;

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    ColumnRepository columnRepository;

    @Autowired
    CardRepository cardRepository;

    public List<Boards> getAllBoard() {
        List<Boards> boardsList = new ArrayList<>();
        boardList = boardRepository.findAll();

        if (!boardList.isEmpty()) {
            boardsList = getColumnDetails(boardList);
        }
        return boardsList;
    }

    private List<Boards> getColumnDetails(List<Board> boardList) {
        List<Boards> boardsList = new ArrayList<>();

        for (Board board : boardList) {
            List<Columns> columnsList = new ArrayList<>();
            List<BoardColumn> columnList = columnRepository.findByBoardId(board.getId());
            if(!columnList.isEmpty()) {
                for (BoardColumn boardColumn : columnList){
                    Columns columns = new Columns();
                    columns.setColumnName(boardColumn.getColumnName());
                    List<Card> cardList = getCardDetails(boardColumn.getId());
                    if(!cardList.isEmpty()) {
                        columns.setCard(Cards.setCartsDetails(cardList));
                        columnsList.add(columns);
                    } else {
                        columns.setCard(new ArrayList<>());
                        columnsList.add(columns);
                    }
                }

            }
            Boards boards = new Boards();
            boards.setBoardName(board.getBoardName());
            boards.setBoardColumn(columnsList);
            boardsList.add(boards);
        }
        return boardsList;
    }

    private List<Card> getCardDetails(Integer columnId) {
        List<Card> cardList = cardRepository.findByColumnId(columnId);
        return cardList;
    }
}
