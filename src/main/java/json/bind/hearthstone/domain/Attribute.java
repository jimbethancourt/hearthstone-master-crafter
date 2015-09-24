package json.bind.hearthstone.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

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
    POISONOUS(0),
    STEALTH(0),
    TAUNT(0)
    ;


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

    @Override
    public String toString() {
        return Arrays.asList(this.name().split("_")).stream().map(this::capitalize).collect(Collectors.joining(" "));
    }

    private String capitalize(final String word) {
        String wordToLower = word.toLowerCase();
        return Character.toUpperCase(wordToLower.charAt(0)) + wordToLower.substring(1);
    }
}
