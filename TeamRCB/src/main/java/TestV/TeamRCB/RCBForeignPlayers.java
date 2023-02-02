package TestV.TeamRCB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

public class RCBForeignPlayers {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		 String path = new String("src/test/java/resources/TeamRCB.json");
	     File file = new File(path);
	     String jsonData = new String(Files.readAllBytes(Paths.get(file.toURI())));
		 JSONObject jObj = new JSONObject(jsonData);
		 JSONArray jArr = jObj.getJSONArray("player");
		 List<String> countries = new ArrayList<String>();
		 for(int i=0;i<jArr.length();i++){
			 if(!(jArr.getJSONObject(i).getString("country").equalsIgnoreCase("India"))){
				 countries.add(jArr.getJSONObject(i).getString("country"));
			 }
		 }
		 Assert.assertEquals("More than 4 Foreign Players", 4, countries.size());
		 System.out.println("Foreign players are from the below countries");
		 for(String country : countries){
			 System.out.println(country);
		 }

	}

}
