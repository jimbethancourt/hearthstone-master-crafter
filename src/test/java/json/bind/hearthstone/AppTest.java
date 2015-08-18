package json.bind.hearthstone;

import java.io.IOException;
import json.bind.hearthstone.domain.CardUniverse;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void testParseData() throws Exception {
        App app = new App();
        CardUniverse cards = app.parseData();
        Assert.assertNotNull(cards);

    }

    @Test
    public void testCardSetNameBRM() throws IOException {
        App app = new App();
        CardUniverse cards = app.parseData();

        Assert.assertEquals("Blackrock Mountain", cards.getBlackrockMountain().get(0).getCardSet());
    }

    @Test
    public void testCardSetNameGvG() throws IOException {
        App app = new App();
        CardUniverse cards = app.parseData();

        Assert.assertEquals("Goblins Vs Gnomes", cards.getGoblinsVsGnomes().get(0).getCardSet());
    }
}
