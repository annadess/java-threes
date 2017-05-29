/**
 * This package contains all the controller classes for the game.<p>
 * The classes in this package can be used to generate a starting board for a new game.
 * <pre>
 * GameState gameState = GameStateGenerator.generateGameState();
 * </pre>
 * See if the elements can move somewhere
 * <pre>
 * if(GameStateOperatorPrerequisites.canMoveUp(gameState)){
 *		//...
 * }	
 * </pre>
 * And move the elements on the board.
 * <pre>
 * GameStateOperator.moveUp(gameState);
 * </pre>
 */
package annadess;
