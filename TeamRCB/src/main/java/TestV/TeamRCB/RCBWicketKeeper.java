package TestV.TeamRCB;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

public class RCBWicketKeeper {

	public static void main(String[] args) throws IOException {
		 String path = new String("src/test/java/resources/TeamRCB.json");
		 boolean flag = false;
	     File file = new File(path);
	     String jsonData = new String(Files.readAllBytes(Paths.get(file.toURI())));
		 JSONObject jObj = new JSONObject(jsonData);
		 JSONArray jArr = jObj.getJSONArray("player");
		 String country=null,name = null;
		 for(int i=0;i<jArr.length();i++){
			 if(jArr.getJSONObject(i).getString("role").equalsIgnoreCase("Wicket-keeper")){
				 flag = true;
				 country = jArr.getJSONObject(i).getString("country");
				 name = jArr.getJSONObject(i).getString("name");
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
