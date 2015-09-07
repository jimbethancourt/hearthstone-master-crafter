package json.bind.hearthstone.domain;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by jimb on 8/23/2015.
 */
public enum Attribute {

    //ALWAYS add new enums in alphabetical order to preserve natural comparator ordering for unit tests
    ATTACK(0),
    CHARGE(0),
    DIVINE_SHIELD(0),
    DURABILITY(0),
    HEALTH(0),
    TAUNT(0);


    private final Integer value;

    Attribute(Integer defaultValue) {
        this.value = defaultValue;
    }

    public Integer getValue() {
        return value;
    }

    public static Map<Attribute, Integer> getDefaultAttributeMap(){
        Map<Attribute, Integer> attributes = new TreeMap<>();
        for (Attribute attribute : Attribute.class.getEnumConstants()) {
            attributes.put(attribute, attribute.getValue());
        }
        return attributes;
    }
}
