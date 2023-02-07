package TestV.TeamRCB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RCBForeignPlayers {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		 String path = new String("src/test/java/resources/TeamRCB.json");
	     File file = new File(path);
	     String jsonData = new String(Files.readAllBytes(Paths.get(file.toURI())));
	     ObjectMapper objectMapper = new ObjectMapper();
	     Players players = objectMapper.readValue(jsonData, Players.class);
		 List<Player> playerList = players.getPlayer();
		 int count=0;
		 HashMap<String,String> foreignPlayers = new HashMap<String,String>();
		 for(Player player : playerList){
			 String name;
			 if(!(player.getCountry().equalsIgnoreCase("India"))){
				 count++;
				 if(foreignPlayers.containsKey(player.getCountry())){
					 name = foreignPlayers.get(player.getCountry()).concat(",").concat(player.getName());
				 }else{
					 name=player.getName();
				 }
				 foreignPlayers.put(player.getCountry(), name);
			 }
		 }
		 Assert.assertEquals("More than 4 Foreign Players", 4, count);
		 System.out.println("Foreign players details are : ");
		 for(Map.Entry entry : foreignPlayers.entrySet()){
			 System.out.println(entry.getKey()+" : "+entry.getValue());
		 }

	}

}
