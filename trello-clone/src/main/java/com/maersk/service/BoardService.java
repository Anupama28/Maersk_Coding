package com.maersk.service;

import com.maersk.dao.BoardRepository;
import com.maersk.dao.CardRepository;
import com.maersk.dao.ColumnRepository;
import com.maersk.entity.Board;
import com.maersk.entity.BoardColumn;
import com.maersk.entity.Card;
import com.maersk.pojo.Boards;
import com.maersk.pojo.Cards;
import com.maersk.pojo.Columns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
