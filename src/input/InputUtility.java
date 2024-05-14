package input;

import java.util.ArrayList;

import javafx.scene.input.KeyCode;
import main.Game;
import main.GameState;

/**
 * The InputUtility class handles user input in the game.
 * It keeps track of mouse and keyboard events and delegates them to the appropriate game states.
 */
public class InputUtility {
	
	/**
	 * Mouse's x position.
	 */
	public static double mouseX;
	
	/**
	 * Mouse's y position.
	 */
	public static double mouseY;
	
	/**
	 * Indicates whether the mouse is on the screen (default = true).
	 */
	public static boolean mouseOnScreen = true;
	
	/**
	 * Indicates whether the left mouse button is currently down.
	 */
	@SuppressWarnings("unused")
	private static boolean leftMouseDown = false;
	
	/**
	 * Indicates whether the left mouse button was clicked last time.
	 */
	private static boolean leftClickedLastTick = false;
	
	/**
	 * List of keys that have been pressed.
	 */
	private static ArrayList<KeyCode> keyPressed = new ArrayList<>();
	
	/**
	 * Checks if the specified key is currently pressed.
	 *
	 * @param keyCode the key code to check
	 * @return true if the key is pressed, false otherwise
	 */
	public static boolean getKeyPressed(KeyCode keyCode) {
		return keyPressed.contains(keyCode);
	}
	
	/**
	 * Sets the specified key as pressed and delegates the key press event to the appropriate game state.
	 *
	 * @param game     the game instance
	 * @param keyCode  the key code that is pressed
	 * @param pressed  true if the key is pressed, false if it is released
	 */
	public static void setKeyPressed(Game game, KeyCode keyCode, boolean pressed) {
		if (pressed) {
			if (!keyPressed.contains(keyCode)) {
				keyPressed.add(keyCode);
				game.getPlaying().keyPressed(keyCode);
			}
		} else {
			keyPressed.remove(keyCode);
		}
	}
	
	/**
	 * Handles the left click event based on the current game state.
	 *
	 * @param game  the game instance
	 * @param x     the x position of the mouse click
	 * @param y     the y position of the mouse click
	 */
	public static void mouseLeftClicked(Game game, int x, int y) {
		switch (GameState.gameState) {
			case MENU:
				game.getMenu().mouseClicked(x, y);
				break;
			case PLAYING:
				game.getPlaying().mouseClicked(x, y);
				break;
			case EDIT:
				game.getEditing().mouseClicked(x, y);
				break;
			case GAME_OVER:
				game.getGameOver().mouseClicked(x, y);
				break;
		}
	}
	
	/**
	 * Handles the left mouse button down event based on the current game state.
	 *
	 * @param game  the game instance
	 * @param x     the x position of the mouse click
	 * @param y     the y position of the mouse click
	 */
	public static void mouseLeftDown(Game game, int x, int y) {
		leftMouseDown = true;
		leftClickedLastTick = true;
		
		switch (GameState.gameState) {
			case MENU:
				game.getMenu().mousePressed(x, y);
				break;
			case PLAYING:
				game.getPlaying().mousePressed(x, y);
				break;
			case EDIT:
				game.getEditing().mousePressed(x, y);
				break;
			case GAME_OVER:
				game.getGameOver().mousePressed(x, y);
				break;
		}
	}
	
	/**
	 * Handles the left mouse button release event based on the current game state.
	 *
	 * @param game  the game instance
	 * @param x     the x position of the mouse click
	 * @param y     the y position of the mouse click
	 */
	public static void mouseLeftRelease(Game game, int x, int y) {
		leftMouseDown = false;
		
		switch (GameState.gameState) {
			case MENU:
				game.getMenu().mouseReleased(x, y);
				break;
			case PLAYING:
				game.getPlaying().mouseReleased(x, y);
				break;
			case EDIT:
				game.getEditing().mouseReleased(x, y);
				break;
			case GAME_OVER:
				game.getGameOver().mouseReleased(x, y);
				break;
		}
	}
	
	/**
	 * Returns whether the left mouse button was clicked last time.
	 *
	 * @return true if the left mouse button was clicked, false otherwise
	 */
	public static boolean isLeftClickTriggered() {
		return leftClickedLastTick;
	}
	
	/**
	 * Sets the leftClickedLastTick value to false.
	 */
	public static void updateInputState() {
		leftClickedLastTick = false;
	}
	
	/**
	 * Handles the mouse moved event based on the current game state.
	 *
	 * @param game  the game instance
	 * @param x     the new x position of the mouse
	 * @param y     the new y position of the mouse
	 */
	public static void mouseMoved(Game game, int x, int y) {
		switch (GameState.gameState) {
			case MENU:
				game.getMenu().mouseMoved(x, y);
				break;
			case PLAYING:
				game.getPlaying().mouseMoved(x, y);
				break;
			case EDIT:
				game.getEditing().mouseMoved(x, y);
				break;
			case GAME_OVER:
				game.getGameOver().mouseMoved(x, y);
				break;
		}
	}
	
	/**
	 * Handles the mouse dragged event based on the current game state.
	 *
	 * @param game  the game instance
	 * @param x     the new x position of the mouse
	 * @param y     the new y position of the mouse
	 */
	public static void mouseDragged(Game game, int x, int y) {
		switch (GameState.gameState) {
			case MENU:
				game.getMenu().mouseDragged(x, y);
				break;
			case PLAYING:
				game.getPlaying().mouseDragged(x, y);
				break;
			case EDIT:
				game.getEditing().mouseDragged(x, y);
				break;
			case GAME_OVER:
				game.getGameOver().mouseDragged(x, y);
				break;
		}
	}
	
	/**
	 * Handles the right click event based on the current game state.
	 *
	 * @param game  the game instance
	 * @param x     the x position of the mouse click
	 * @param y     the y position of the mouse click
	 */
	public static void mouseRightClicked(Game game, int x, int y) {
		switch (GameState.gameState) {
			case MENU:
				game.getMenu().mouseRightClicked(x, y);
				break;
			case PLAYING:
				game.getPlaying().mouseRightClicked(x, y);
				break;
			case EDIT:
				game.getEditing().mouseRightClicked(x, y);
				break;
			case GAME_OVER:
				game.getGameOver().mouseRightClicked(x, y);
				break;
		}	
	}
}