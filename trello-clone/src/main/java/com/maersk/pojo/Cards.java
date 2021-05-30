package com.maersk.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.maersk.entity.Card;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cards {

    @JsonProperty("card_name")
    private String cardName;

    @JsonProperty("card_level")
    private String cardLevel;

    @JsonProperty("tag")
    private String tag;

    @JsonProperty("highlighted")
    private Boolean highlighted;

    @JsonProperty("timestamp")
    private String timeStamp;


    public static List<Cards> setCartsDetails(List<Card> cardList) {
        List<Cards> cardsList = new ArrayList<>();
        for(Card card : cardList) {
            Cards cards = new Cards();
            cards.setCardName(card.getCardName());
            cards.setCardLevel(card.getCardLevel());
            cards.setTag(card.getTag());
            cards.setHighlighted(card.getHighlighted());
            cards.setTimeStamp(card.getTimeStamp());
            cardsList.add(cards);
        }
        return cardsList;
    }
}
