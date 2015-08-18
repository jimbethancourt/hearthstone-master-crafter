package json.bind.hearthstone.domain;

/**
 * Created by jimb on 4/27/2015.
 */
import java.lang.reflect.Field;
import java.util.*;
import javax.annotation.Generated;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "id",
        "name",
        "type",
        "rarity",
        "cost",
        "text",
        "flavor",
        "artist",
        "collectible",
        "playerClass",
        "attack",
        "health",
        "race",
        "mechanics",
        "elite",
        "durability"
})
public class Card {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("rarity")
    private String rarity;
    @JsonProperty("cost")
    private Integer cost;
    @JsonProperty("text")
    private String text;
    @JsonProperty("flavor")
    private String flavor;
    @JsonProperty("artist")
    private String artist;
    @JsonProperty("collectible")
    private Boolean collectible;
    @JsonProperty("playerClass")
    private String playerClass;
    @JsonProperty("attack")
    private Integer attack;
    @JsonProperty("health")
    private Integer health;
    @JsonProperty("race")
    private String race;
    @JsonProperty("mechanics")
    @Valid
    private List<String> mechanics = new ArrayList<String>();
    @JsonProperty("elite")
    private Boolean elite;
    @JsonProperty("durability")
    private Integer durability;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public double calculateValue(Map<String, Integer> calculatedAttributeValues){
        return calculatedAttributeValues.get("attack") * attack +
                calculatedAttributeValues.get("health") * health +
                calculatedAttributeValues.get("durabiity") * durability;
    }

    public Map<String, Integer> getRawAttributeValues() {
        Map<String, Integer> rawAttributeValues = new TreeMap<>();


        rawAttributeValues.put("cost", cost);

        if(null != attack)
            rawAttributeValues.put("attack", attack);

        if(null != health)
            rawAttributeValues.put("health", health);

        if(null != durability)
            rawAttributeValues.put("durability", durability);

        if(hasDivineShield())
            rawAttributeValues.put("Divine Shield", 1);

        if(hasTaunt())
            rawAttributeValues.put("Taunt", 1);

        if(hasCharge())
            rawAttributeValues.put("Charge", 1);

        return rawAttributeValues;
    }

    boolean hasDivineShield() {
        return mechanics.contains("Divine Shield");
    }

    boolean hasTaunt() {
        return mechanics.contains("Taunt");
    }

    boolean hasCharge() {
        return mechanics.contains("Charge");
    }



    /**
     * @return The card set name in human readable form
     */
    public String getCardSet() {
        String simpleName = getClass().getSimpleName();
        String[] setName = simpleName.split("(?<=.)(?=\\p{Lu})");
        return Arrays.toString(setName).replaceAll(",","").replace("[","").replace("]","");
    }

    /**
     *
     * @return
     * The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The rarity
     */
    @JsonProperty("rarity")
    public String getRarity() {
        return rarity;
    }

    /**
     *
     * @param rarity
     * The rarity
     */
    @JsonProperty("rarity")
    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    /**
     *
     * @return
     * The cost
     */
    @JsonProperty("cost")
    public Integer getCost() {
        return cost;
    }

    /**
     *
     * @param cost
     * The cost
     */
    @JsonProperty("cost")
    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public boolean isVariableSpellDamage() {
        return text.contains("$");
    }

    /**
     *
     * @return
     * The text
     */
    @JsonProperty("text")
    public String getText() {
        if(null != text)
            return text.replaceAll("\\<.*?\\>", "").replaceAll("$", "");
        else
            return text;
    }

    /**
     *
     * @param text
     * The text
     */
    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    /**
     *
     * @return
     * The flavor
     */
    @JsonProperty("flavor")
    public String getFlavor() {
        return flavor;
    }

    /**
     *
     * @param flavor
     * The flavor
     */
    @JsonProperty("flavor")
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    /**
     *
     * @return
     * The artist
     */
    @JsonProperty("artist")
    public String getArtist() {
        return artist;
    }

    /**
     *
     * @param artist
     * The artist
     */
    @JsonProperty("artist")
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     *
     * @return
     * The collectible
     */
    @JsonProperty("collectible")
    public Boolean getCollectible() {
        return collectible;
    }

    /**
     *
     * @param collectible
     * The collectible
     */
    @JsonProperty("collectible")
    public void setCollectible(Boolean collectible) {
        this.collectible = collectible;
    }

    /**
     *
     * @return
     * The playerClass
     */
    @JsonProperty("playerClass")
    public String getPlayerClass() {
        return playerClass;
    }

    /**
     *
     * @param playerClass
     * The playerClass
     */
    @JsonProperty("playerClass")
    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    /**
     *
     * @return
     * The attack
     */
    @JsonProperty("attack")
    public Integer getAttack() {
        return attack;
    }

    /**
     *
     * @param attack
     * The attack
     */
    @JsonProperty("attack")
    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    /**
     *
     * @return
     * The health
     */
    @JsonProperty("health")
    public Integer getHealth() {
        return health;
    }

    /**
     *
     * @param health
     * The health
     */
    @JsonProperty("health")
    public void setHealth(Integer health) {
        this.health = health;
    }

    /**
     *
     * @return
     * The race
     */
    @JsonProperty("race")
    public String getRace() {
        return race;
    }

    /**
     *
     * @param race
     * The race
     */
    @JsonProperty("race")
    public void setRace(String race) {
        this.race = race;
    }

    /**
     *
     * @return
     * The mechanics
     */
    @JsonProperty("mechanics")
    public List<String> getMechanics() {
        return mechanics;
    }

    /**
     *
     * @param mechanics
     * The mechanics
     */
    @JsonProperty("mechanics")
    public void setMechanics(List<String> mechanics) {
        this.mechanics = mechanics;
    }

    /**
     *
     * @return
     * The elite
     */
    @JsonProperty("elite")
    public Boolean getElite() {
        return elite;
    }

    /**
     *
     * @param elite
     * The elite
     */
    @JsonProperty("elite")
    public void setElite(Boolean elite) {
        this.elite = elite;
    }

    /**
     *
     * @return
     * The durability
     */
    @JsonProperty("durability")
    public Integer getDurability() {
        return durability;
    }

    /**
     *
     * @param durability
     * The durability
     */
    @JsonProperty("durability")
    public void setDurability(Integer durability) {
        this.durability = durability;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
