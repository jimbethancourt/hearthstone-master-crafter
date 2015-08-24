package json.bind.hearthstone;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import json.bind.hearthstone.domain.Card;
import json.bind.hearthstone.domain.CardUniverse;
import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by jimb on 8/22/2015.
 */
public class CalculatorTest {

    Map<String, Card> allCards;
    Calculator calculator;


    @Before
    public void setUp() throws IOException {
        InputStream stream = getClass().getClassLoader().getResourceAsStream("AllSets.json");

        ObjectMapper mapper = new ObjectMapper();
        CardUniverse cardUniverse = mapper.readValue(stream, CardUniverse.class);

        List<Card> allCardsList = new ArrayList<>();
        allCardsList.addAll(cardUniverse.getBasic());
        allCardsList.addAll(cardUniverse.getClassic());

        allCards = new HashMap<>();
        for (Card card : allCardsList) {
            allCards.put(card.getName(), card);
        }

        calculator = new Calculator();
    }

    @Test
    public void testCalculateRegressionParams() {
        Collection<Card> cards = new HashSet<>();
        cards.add(allCards.get("Kor'kron Elite"));
        cards.add(allCards.get("Reckless Rocketeer"));
        cards.add(allCards.get("Argent Commander"));
        cards.add(allCards.get("Scarlet Crusader"));
        cards.add(allCards.get("Argent Squire"));
        cards.add(allCards.get("Wisp"));
        cards.add(allCards.get("Silvermoon Guardian"));
        cards.add(allCards.get("River Crocolisk"));
        cards.add(allCards.get("Goldshire Footman"));

        double [] handParams = calculateRegressionParamsByHand();
        double [] params = calculator.calculateRegressionParameters(new ArrayList<>(cards));

        Assert.assertEquals(handParams[0], params[0], 0.1);
    }


    double [] calculateRegressionParamsByHand () {
        OLSMultipleLinearRegression ols = new OLSMultipleLinearRegression();

        double [] manaCost = {4,6,6,3,1,0,4,2}; // mana cost is y intercept
        double [] [] x = new double[8][];

        //atk,health,charge,divine
        double [] korkonElite =         new double []{4,3,1,0};
        x[0] = korkonElite;
        double [] recklessRocketeer =   new double []{5,2,1,0};
        x[1] = recklessRocketeer;
        double [] argentCommander =     new double []{4,2,1,1};
        x[2] = argentCommander;
        double [] scarletCrusader =     new double []{3,1,0,1};
        x[3] = scarletCrusader;
        double [] argentSquire =        new double []{1,1,0,1};
        x[4] = argentSquire;
        double [] wisp =                new double []{1,1,0,0};
        x[5] = wisp;
        double [] silvermoonGuardian =  new double []{3,3,0,1};
        x[6] = silvermoonGuardian;
        double [] riverCrocolisk =      new double []{2,3,0,0};
        x[7] = riverCrocolisk;

        ols.newSampleData(manaCost, x);

        return ols.estimateRegressionParameters();
    }
}
