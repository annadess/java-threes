/**
 * This package contains all the model classes for the game.<p>
 * The classes in this package can be used to instantiate <code>GameState</code> and
 * <code>GameSession</code> objects.
 * <pre>
 * GameState gameState = new GameState();
 * GameSession gameSession = new GameSession(gameState);
 * </pre>
 * Save their contents to a file.
 * <pre>
 * PersistencyManager.saveToFile(new File(PersistencyManager.saveFolder,"save.json"),
 * 						JsonManager.getJsonFromGameSession(gameSession));
 * </pre>
 * Or load them back in.
 * <pre>
 * gameSession = JsonManager.getGameSessionFromJson(PersistencyManager.openFromFile
 * 					(new File(PersistencyManager.saveFolder,"save.json")));
 * </pre>
 */
package annadess.model;
