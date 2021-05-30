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
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="card_name")
    private String cardName;

    @Column(name="card_level")
    private String cardLevel;

    @Column(name="tag")
    private String tag;

    @Column(name="highlighted")
    private Boolean highlighted;

    @Column(name="timestamp")
    private String timeStamp;

    @Column(name="column_id")
    private Integer columnId;

    @Column(name="assign_to")
    private Integer assignTo;

}
