package json.bind.hearthstone.domain;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by jimb on 8/23/2015.
 */
public enum Attribute {

    DIVINE_SHIELD("Divine Shield", 0),
    TAUNT("Taunt", 0),
    CHARGE("Charge", 0);


    private final String name;
    private final Integer value;

    Attribute(String name, Integer defaultValue) {
        this.name = name;
        this.value = defaultValue;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static Map<String, Integer> getDefaultAttributeMap(){
        Map<String, Integer> attributes = new TreeMap<>();
        for (Attribute attribute : Attribute.class.getEnumConstants()) {
            attributes.put(attribute.getName(), attribute.getValue());
        }
        return attributes;
    }
}
