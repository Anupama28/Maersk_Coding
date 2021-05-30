package com.trello.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "column")
public class BoardColumn {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="column_name")
    private String columnName;

    @Column(name="board_id")
    private Integer boardId;


}
