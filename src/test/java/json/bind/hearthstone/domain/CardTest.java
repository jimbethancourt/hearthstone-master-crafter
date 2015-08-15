package json.bind.hearthstone.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by jimb on 6/19/2015.
 */
public class CardTest {

    Map<String, Card> allCards;

    @Before
    public void setUp() throws IOException {
        InputStream stream = getClass().getClassLoader().getResourceAsStream("AllSets.json");

        ObjectMapper mapper = new ObjectMapper();
        CardUniverse cardUniverse = mapper.readValue(stream, CardUniverse.class);

        List<Card> allCardsList = new ArrayList<>();
        allCardsList.addAll(cardUniverse.getBasic());
        allCardsList.addAll(cardUniverse.getClassic());
        allCardsList.addAll(cardUniverse.getCurseOfNaxxramas());
        allCardsList.addAll(cardUniverse.getGoblinsVsGnomes());
        allCardsList.addAll(cardUniverse.getBlackrockMountain());

        allCards = new HashMap<>();
        for (Card card : allCardsList) {
            allCards.put(card.getName(), card);
        }
    }

    @Test
    public void testRiverCroc() {
        Card croc = allCards.get("River Crocolisk");
        Assert.assertEquals(croc.getCost().intValue(), 2);
        Assert.assertEquals(croc.getAttack().intValue(), 2);
        Assert.assertEquals(croc.getHealth().intValue(), 3);
        Assert.assertNull(croc.getText());
        Assert.assertNull(croc.getDurability());
    }

    @Test
    public void testTruesilver() {
        Card tsc = allCards.get("Truesilver Champion");
        Assert.assertEquals(tsc.getCost().intValue(), 4);
        Assert.assertEquals(tsc.getAttack().intValue(), 4);
        Assert.assertEquals(tsc.getDurability().intValue(), 2);
        Assert.assertNotNull(tsc.getText());
        Assert.assertEquals("Whenever your hero attacks, restore 2 Health to it.", tsc.getText());
        Assert.assertNull(tsc.getHealth());
    }

}
