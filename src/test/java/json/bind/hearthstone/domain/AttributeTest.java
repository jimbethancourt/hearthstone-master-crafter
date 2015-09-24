package json.bind.hearthstone.domain;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * Created by jimb on 9/8/2015.
 */
public class AttributeTest extends TestCase {

    public void testToStringAttack() throws Exception {
        Assert.assertEquals("Attack", Attribute.ATTACK.toString());
    }

    public void testToStringDivineShield() throws Exception {
        Assert.assertEquals("Divine Shield", Attribute.DIVINE_SHIELD.toString());
    }
}