package json.bind.hearthstone;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.lang.System;
import java.util.ArrayList;
import java.util.List;
import json.bind.hearthstone.domain.*;
import org.jsoup.Jsoup;

/**
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        App app = new App();
        List<Card> allCards = app.getAllCards();

        for (Card allCard : allCards) {
            if(allCard.getCollectible())
                allCard.getRawAttributeValues();
        }
    }

    public CardUniverse parseData() throws IOException {
        InputStream stream = getClass().getClassLoader().getResourceAsStream("AllSets.json");

        ObjectMapper mapper = new ObjectMapper();
        CardUniverse cardUniverse = mapper.readValue(stream, CardUniverse.class);

        //mapper.writeValue(System.out, cardUniverse);

        return cardUniverse;
    }

    public List<Card> getAllCards(){
        CardUniverse cardUniverse = null;
        try {
            cardUniverse = parseData();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Card> allCards = new ArrayList<>();
        allCards.addAll(cardUniverse.getBasic());
        allCards.addAll(cardUniverse.getClassic());
        allCards.addAll(cardUniverse.getCurseOfNaxxramas());
        allCards.addAll(cardUniverse.getGoblinsVsGnomes());
        allCards.addAll(cardUniverse.getBlackrockMountain());

        return allCards;
    }
}
