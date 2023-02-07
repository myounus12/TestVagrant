package TestV.TeamRCB;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Players {
	@JsonProperty("name")
	String name;

	@JsonProperty("location")
	String location;

	@JsonProperty("player")
	List<Player> player;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocation() {
		return this.location;
	}

	public void setPlayer(List<Player> player) {
		this.player = player;
	}

	public List<Player> getPlayer() {
		return this.player;
	}

}
