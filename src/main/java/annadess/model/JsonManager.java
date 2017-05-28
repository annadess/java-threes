package annadess.model;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class JsonManager {
	
	private static final Logger logger = LoggerFactory.getLogger(JsonManager.class);
	
	public static String getJsonFromGameSession(GameSession gameSession){
		Gson gsonObject = new Gson();
		return gsonObject.toJson(gameSession);
	}
	
	public static GameSession getGameSessionFromJson(String jsonString){
		Gson gsonObject = new Gson();
		return getGameSession(jsonString, gsonObject);
	}
	
	private static GameSession getGameSession(String jsonString, Gson gsonObject){
		try {
			return gsonObject.fromJson(jsonString, GameSession.class);
		} catch (JsonSyntaxException e) {
			logger.debug("User tried to load invalid file");
			logger.debug(ExceptionUtils.getStackTrace(e));
			return null;
		}
	}
}
