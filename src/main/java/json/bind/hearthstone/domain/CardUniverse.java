
package json.bind.hearthstone.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class CardUniverse{
	@JsonProperty("Basic")
   	private List<Basic> basic;
	@JsonProperty("Blackrock Mountain")
   	private List<BlackrockMountain> blackrockMountain;
	@JsonProperty("Classic")
   	private List<Classic> classic;
	@JsonProperty("Credits")
   	private List<Credits> credits;
	@JsonProperty("Curse of Naxxramas")
   	private List<CurseOfNaxxramas> curseOfNaxxramas;
	@JsonProperty("Debug")
   	private List<Debug> debug;
	@JsonProperty("Goblins vs Gnomes")
   	private List<GoblinsVsGnomes> goblinsVsGnomes;
	@JsonProperty("Missions")
   	private List<Missions> missions;
	@JsonProperty("Promotion")
   	private List<Promotion> promotion;
	@JsonProperty("Reward")
   	private List<Reward> reward;
	@JsonProperty("System")
   	private List<SystemCardSet> system;

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
 	public List<Credits> getCredits(){
		return this.credits;
	}
	public void setCredits(List<Credits> credits){
		this.credits = credits;
	}
 	public List<CurseOfNaxxramas> getCurseOfNaxxramas(){
		return this.curseOfNaxxramas;
	}
	public void setCurseOfNaxxramas(List<CurseOfNaxxramas> curseOfNaxxramas){
		this.curseOfNaxxramas = curseOfNaxxramas;
	}
 	public List<Debug> getDebug(){
		return this.debug;
	}
	public void setDebug(List<Debug> debug){
		this.debug = debug;
	}
 	public List<GoblinsVsGnomes> getGoblinsVsGnomes(){
		return this.goblinsVsGnomes;
	}
	public void setGoblinsVsGnomes(List<GoblinsVsGnomes> goblinsVsGnomes){
		this.goblinsVsGnomes = goblinsVsGnomes;
	}
 	public List<Missions> getMissions(){
		return this.missions;
	}
	public void setMissions(List<Missions> missions){
		this.missions = missions;
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
 	public List<SystemCardSet> getSystem(){
		return this.system;
	}
	public void setSystem(List<SystemCardSet> system){
		this.system = system;
	}
}
