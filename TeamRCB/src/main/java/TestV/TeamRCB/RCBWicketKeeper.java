package TestV.TeamRCB;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.junit.Assert;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RCBWicketKeeper {

	public static void main(String[] args) throws IOException {
		 String path = new String("src/test/java/resources/TeamRCB.json");
		 boolean flag = false;
	     File file = new File(path);
	     String jsonData = new String(Files.readAllBytes(Paths.get(file.toURI())));
	     ObjectMapper objectMapper = new ObjectMapper();
	     Players players = objectMapper.readValue(jsonData, Players.class);
		 String country=null,name = null;
		 List<Player> playerList = players.getPlayer();
		 for(Player player : playerList){
			 if(player.getRole().equalsIgnoreCase("Wicket-keeper")){
				 flag = true;
				 country = player.getCountry();
				 name = player.getName();
				 break; 
			 }
		 }
		 Assert.assertEquals("No Wicket Keeper in RCB team",true, flag);
		 System.out.println("Name of the Wicket-keeper");
		 System.out.println(name);
		 System.out.println("Country of the player");
		 System.out.println(country);
	}

}
