package main;

import javafx.scene.canvas.GraphicsContext;

/**
 * The Render class is responsible for rendering the current game state.
 */
public class Render {
	/**
	 * The Game instance.
	 */
	private Game game;
	
	/**
	 * Initializes the Render object with the specified Game instance.
	 *
	 * @param game The Game instance.
	 */
	public Render(Game game) {
		this.game = game;
	}
	
	/**
	 * Renders the current game state.
	 *
	 * @param gc The GraphicsContext used for rendering.
	 */
	public void render(GraphicsContext gc) {
		// Switch statement based on the current game state
		switch(GameState.gameState) {
			case MENU:
				// Render the menu state
				game.getMenu().render(gc);
				break;
			case PLAYING:
				// Render the playing state
				game.getPlaying().render(gc);
				break;
			case EDIT:
				// Render the edit state
				game.getEditing().render(gc);
				break;
			case GAME_OVER:
				// Render the game over state
				game.getGameOver().render(gc);
				break;
		}
	}
}
