package drawing;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseButton;

import main.Game;

import input.InputUtility;

/*
 * This class represents the Game Screen.
 */

public class GameScreen extends Canvas {
	/**
	 * An instance of the Game class.
	 */
	private Game game;
	
	/**
	 * Constructor for GameScreen.
	 * Initialize fields according to parameters.
	 * Call addListener();.
	 * @param game an instance of the Game class.
	 * @param width width of the GameScreen canvas.
	 * @param height height of the GameScreen canvas.
	 */
	public GameScreen(Game game, double width, double height) {
		super(width, height);
		
		this.game = game;
		this.setVisible(true);

		addListener();
	}
	
	/**
	 * A method to render the game.
	 * @param gc an instance of GraphicsContext class.
	 */
	public void paintComponent(GraphicsContext gc) {
		game.getRender().render(gc);
	}
	
	/**
	 * Add listeners for mouse and keyboard events.
	 */
	public void addListener() {
		this.setOnKeyPressed((KeyEvent event) -> {
			InputUtility.setKeyPressed(game, event.getCode(), true);
		});

		this.setOnKeyReleased((KeyEvent event) -> {
			InputUtility.setKeyPressed(game, event.getCode(), false);
		});
		
		this.setOnMouseClicked((MouseEvent event) -> {
			if(event.getButton() == MouseButton.PRIMARY) {
				InputUtility.mouseLeftClicked(game, (int)event.getX(), (int)event.getY());
			}
			else if(event.getButton() == MouseButton.SECONDARY) {
				InputUtility.mouseRightClicked(game, (int)event.getX(), (int)event.getY());
			}
		});

		this.setOnMousePressed((MouseEvent event) -> {
			if (event.getButton() == MouseButton.PRIMARY) {
				InputUtility.mouseLeftDown(game, (int)event.getX(), (int)event.getY());
			}
		});

		this.setOnMouseReleased((MouseEvent event) -> {
			if (event.getButton() == MouseButton.PRIMARY) {
				InputUtility.mouseLeftRelease(game, (int)event.getX(), (int)event.getY());
			}
		});

		this.setOnMouseEntered((MouseEvent event) -> {
			InputUtility.mouseOnScreen = true;
		});

		this.setOnMouseExited((MouseEvent event) -> {
			InputUtility.mouseOnScreen = false;
		});

		this.setOnMouseMoved((MouseEvent event) -> {
			if (InputUtility.mouseOnScreen) {
				InputUtility.mouseX = event.getX();
				InputUtility.mouseY = event.getY();
				InputUtility.mouseMoved(game, (int)event.getX(), (int)event.getY());
			}
		});

		this.setOnMouseDragged((MouseEvent event) -> {
			if (InputUtility.mouseOnScreen) {
				if(event.getButton() == MouseButton.PRIMARY) {
					InputUtility.mouseX = event.getX();
					InputUtility.mouseY = event.getY();
					InputUtility.mouseDragged(game, (int)event.getX(), (int)event.getY());
				}
			}
		});
	}
}
