package annadess.model;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class JsonManager {
	
	public static String getJsonFromGameSession(GameSession gameSession){
		Gson gsonObject = new Gson();
		return gsonObject.toJson(gameSession);
	}
	
	public static GameSession getGameSessionFromJson(String jsonString){
		Gson gsonObject = new Gson();
		try {
			return gsonObject.fromJson(jsonString, GameSession.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
			System.out.println("Invalid File Detected");
			return null;
		}
	}
	
}
