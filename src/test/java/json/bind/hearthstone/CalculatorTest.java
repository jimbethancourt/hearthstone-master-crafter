package json.bind.hearthstone;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

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
        List<String> filter = Arrays.asList("Attack", "Charge", "Divine Shield", "Health");

        Collection<Card> cards = new HashSet<>();
        cards.add(filterAttributes(filter, allCards.get("Kor'kron Elite")));
        cards.add(filterAttributes(filter, allCards.get("Reckless Rocketeer")));
        cards.add(filterAttributes(filter, allCards.get("Argent Commander")));
        cards.add(filterAttributes(filter, allCards.get("Scarlet Crusader")));
        cards.add(filterAttributes(filter, allCards.get("Argent Squire")));
        cards.add(filterAttributes(filter, allCards.get("Wisp")));
        cards.add(filterAttributes(filter, allCards.get("Silvermoon Guardian")));
        cards.add(filterAttributes(filter, allCards.get("River Crocolisk")));
        //cards.add(allCards.get("Goldshire Footman"));

        double [] handParams = calculateRegressionParamsByHand();
        double [] params = calculator.calculateRegressionParameters(new ArrayList<>(cards));

        Assert.assertEquals(handParams[0], params[0], 0.001); //y intercepts the same
        Assert.assertEquals(handParams[1], params[1], 0.001); //attack the same
        Assert.assertEquals(handParams[2], params[2], 0.001); //charge the same
        Assert.assertEquals(handParams[3], params[3], 0.001); //divine shield the same
        Assert.assertEquals(handParams[4], params[4], 0.001); //health the same
    }

    Card filterAttributes(List<String> attributes, Card card) {
        Map<String, Integer> filteredAttrs =
                card.getRawAttributeValues()
                        .entrySet().stream()
                        .filter(e -> attributes.contains(e.getKey()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        card.setRawAttributeValues(new TreeMap<>(filteredAttrs));
        return card;
    }


    double [] calculateRegressionParamsByHand () {
        OLSMultipleLinearRegression ols = new OLSMultipleLinearRegression();

        double [] manaCost = {4,6,6,3,1,0,4,2}; // mana cost is y intercept
        double [] [] x = new double[8][];

        //atk,health,charge,divine
        //atk,charge,divine,health
        double [] korkonElite =         new double []{4,1,0,3};
        x[0] = korkonElite;
        double [] recklessRocketeer =   new double []{5,1,0,2};
        x[1] = recklessRocketeer;
        double [] argentCommander =     new double []{4,1,1,2};
        x[2] = argentCommander;
        double [] scarletCrusader =     new double []{3,0,1,1};
        x[3] = scarletCrusader;
        double [] argentSquire =        new double []{1,0,1,1};
        x[4] = argentSquire;
        double [] wisp =                new double []{1,0,0,1};
        x[5] = wisp;
        double [] silvermoonGuardian =  new double []{3,0,1,3};
        x[6] = silvermoonGuardian;
        double [] riverCrocolisk =      new double []{2,0,0,3};
        x[7] = riverCrocolisk;

        ols.newSampleData(manaCost, x);

        return ols.estimateRegressionParameters();
    }
}
