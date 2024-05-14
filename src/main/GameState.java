package main;

/**
 * The GameState enum represents the different states of the game.
 */
public enum GameState {
	
	/**
	 * Represents the state when the game is being played.
	 */
	PLAYING,
	
	/**
	 * Represents the state when the game is in the menu.
	 */
	MENU,
	
	/**
	 * Represents the state when the game is in edit mode.
	 */
	EDIT,
	
	/**
	 * Represents the state when the game is over.
	 */
	GAME_OVER;

	/**
	 * The current game state. The default state is MENU.
	 */
	public static GameState gameState = MENU;
	
	/**
	 * Sets the current game state.
	 *
	 * @param state The new game state to set.
	 */
	public static void setGameState(GameState state) {
		gameState = state;
	}
}