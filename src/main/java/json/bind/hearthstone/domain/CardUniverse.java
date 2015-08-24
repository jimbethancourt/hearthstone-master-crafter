
package json.bind.hearthstone.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties({"Hero Skins", "Tavern Brawl", "Debug", "Missions", "Credits", "System"})
public class CardUniverse{
	@JsonProperty("Basic")
   	private List<Basic> basic;
	@JsonProperty("Blackrock Mountain")
   	private List<BlackrockMountain> blackrockMountain;
	@JsonProperty("Classic")
   	private List<Classic> classic;
	@JsonProperty("Curse of Naxxramas")
   	private List<CurseOfNaxxramas> curseOfNaxxramas;
	@JsonProperty("Goblins vs Gnomes")
   	private List<GoblinsVsGnomes> goblinsVsGnomes;
	@JsonProperty("Promotion")
   	private List<Promotion> promotion;
	@JsonProperty("Reward")
   	private List<Reward> reward;
	@JsonProperty("The Grand Tournament")
	private List<TheGrandTournament> theGrandTournament;

 	public List<Basic> getBasic(){
		return this.basic;
	}
	public void setBasic(List<Basic> basic){
		this.basic = basic;
	}
 	public List<BlackrockMountain> getBlackrockMountain(){
		return this.blackrockMountain;
	}
	public void setBlackrockMountain(List<BlackrockMountain> blackrockMountain){
		this.blackrockMountain = blackrockMountain;
	}
 	public List<Classic> getClassic(){
		return this.classic;
	}
	public void setClassic(List<Classic> classic){
		this.classic = classic;
	}

 	public List<CurseOfNaxxramas> getCurseOfNaxxramas(){
		return this.curseOfNaxxramas;
	}
	public void setCurseOfNaxxramas(List<CurseOfNaxxramas> curseOfNaxxramas){
		this.curseOfNaxxramas = curseOfNaxxramas;
	}
 	public List<GoblinsVsGnomes> getGoblinsVsGnomes(){
		return this.goblinsVsGnomes;
	}
	public void setGoblinsVsGnomes(List<GoblinsVsGnomes> goblinsVsGnomes){
		this.goblinsVsGnomes = goblinsVsGnomes;
	}
 	public List<Promotion> getPromotion(){
		return this.promotion;
	}
	public void setPromotion(List<Promotion> promotion){
		this.promotion = promotion;
	}
 	public List<Reward> getReward(){
		return this.reward;
	}
	public void setReward(List<Reward> reward){
		this.reward = reward;
	}

	public List<TheGrandTournament> getTheGrandTournament() {
		return theGrandTournament;
	}

	public void setTheGrandTournament(List<TheGrandTournament> theGrandTournament) {
		this.theGrandTournament = theGrandTournament;
	}
}
