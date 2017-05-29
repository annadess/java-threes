package annadess.model;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/**
 * A class that parses JSON syntax into Java objects and vice-versa.
 * 
 * @author annadess
 */
public class JsonManager {

	private static final Logger logger = LoggerFactory.getLogger(JsonManager.class);

	/**
	 * Returns the JSON syntax from the passed {@code GameSession} object.
	 * 
	 * @param gameSession the object passed to create the JSON syntax
	 * @return the JSON syntax from the passed {@code GameSession} object
	 */
	public static String getJsonFromGameSession(GameSession gameSession) {
		Gson gsonObject = new Gson();
		return gsonObject.toJson(gameSession);
	}

	/**
	 * Returns the {@code GameSession} object from the passed JSON syntax.
	 * 
	 * @param jsonString the JSON syntax passed to create the {@code GameSession} object 
	 * @return the {@code GameSession} object from the passed JSON syntax
	 */
	public static GameSession getGameSessionFromJson(String jsonString) {
		Gson gsonObject = new Gson();
		return getGameSession(jsonString, gsonObject);
	}

	private static GameSession getGameSession(String jsonString, Gson gsonObject) {
		try {
			return gsonObject.fromJson(jsonString, GameSession.class);
		} catch (JsonSyntaxException e) {
			logger.debug("User tried to load invalid file");
			logger.debug(ExceptionUtils.getStackTrace(e));
			return null;
		}
	}
}
