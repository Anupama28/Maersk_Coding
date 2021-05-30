package com.maersk.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.maersk.entity.BoardColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Columns {

    @JsonProperty("column_name")
    private String columnName;

    @JsonProperty("cards")
    private List<Cards> card;

    public static List<Columns> setColumnDetails(List<BoardColumn> columnList, List<Columns> columnsList, List<Cards> cardsList) {
        for(BoardColumn column: columnList) {
            Columns columns = new Columns();
            columns.setColumnName(column.getColumnName());
            columns.setCard(cardsList);
            columnsList.add(columns);
        }
        return columnsList;

    }
}
