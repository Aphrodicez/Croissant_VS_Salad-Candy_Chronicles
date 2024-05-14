package main;

import drawing.GameScreen;
import input.InputUtility;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import managers.TileManager;
import scenes.Editing;
import scenes.GameOver;
import scenes.Menu;
import scenes.Playing;
import utilities.LoadSave;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.canvas.GraphicsContext;

/**
 * This class represents the main class for the game.
 */
public class Game extends Application {

	/**
	 * Set Frames Per Second.
	 */
	private static final double FPS_SET = 120.0;
	/**
	 * Set Updates Per Second.
	 */
	private static final double UPS_SET = 120.0;
	/**
	 * Set time per frame (program's time/frame).
	 */
	private static final double timePerFrame = 1_000_000_000.0 / FPS_SET;
	/**
	 * Set updates per frame (program's update/second).
	 */
	private static final double updatesPerFrame = 1_000_000_000.0 / UPS_SET;
	/**
	 * Last time the frame was changed.
	 */
	private long lastFrameTime = 0;
	/**
	 * Last time updated.
	 */
	private long lastUpdateTime = 0;
	/**
	 * Last time money passively increased.
	 */
	private long lastCheckedTime = 0;
	
	@SuppressWarnings("unused")
	/**
	 * Frames count.
	 */
	private int frames = 0;
	@SuppressWarnings("unused")
	/**
	 * Updates count.
	 */
	private int updates = 0;
	/**
	 * Represents the GameScreen class.
	 */
	private GameScreen gameScreen;
	/**
	 * Represents the Render class.
	 */
	private Render render;
	/**
	 * Represents the Menu class.
	 */
	private Menu menu;
	/**
	 * Represents the Playing class.
	 */
	private Playing playing;
	/**
	 * Represents the Editing class.
	 */
	private Editing editing;
	/**
	 * Represents the TileManager class.
	 */
	private TileManager tileManager;
	/**
	 * Represents the GameOver class.
	 */
	private GameOver gameOver;

	/**
	 * Starts the game application.
	 */
	@Override
	public void start(Stage primaryStage) {
		StackPane root = new StackPane();

		Scene scene = new Scene(root);

		primaryStage.setTitle("Croissant VS Salad (Candy Chronicles)");
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);

		createDefaultLevel();
		initClasses();

		root.getChildren().add(gameScreen);

		primaryStage.show();
		
		playing.getSoundPlayer().bgm();

		AnimationTimer animationTimer = new AnimationTimer() {

			@Override
			public void handle(long now) {

				// Render
				if (now - lastFrameTime >= timePerFrame) {
					GraphicsContext gc = gameScreen.getGraphicsContext2D();
					gameScreen.paintComponent(gc);
					frames++;
					lastFrameTime = now;
				}

				// Update
				if (now - lastUpdateTime >= updatesPerFrame) {
					updateGame();
					updates++;
					lastUpdateTime = now;
				}

				if (now - lastCheckedTime >= 1_000_000_000) {
					lastCheckedTime = now;
				}
				gameScreen.requestFocus();
			}
		};

		animationTimer.start();
	}

	/**
	 * Updates the game.
	 */
	private void updateGame() {
		InputUtility.updateInputState();

		switch (GameState.gameState) {
			case EDIT:
				break;
			case MENU:
				break;
			case PLAYING:
				playing.update();
			default:
				break;
		}
	}

	/**
	 * Creates the default level.
	 */
	private void createDefaultLevel() {
		LoadSave.getRandomLevelData("new_level");
	}

	/**
	 * Initializes the classes in fields.
	 */
	private void initClasses() {
		tileManager = new TileManager();

		gameScreen = new GameScreen(this, 640, 800);
		render = new Render(this);

		menu = new Menu(this);
		playing = new Playing(this);
		editing = new Editing(this);
		gameOver = new GameOver(this);
	}
	
	/**
	 * Launches the application.
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@SuppressWarnings("unused")
	/**
	 * Displays the current FPS and UPS.
	 */
	private void displayFPSUPS() {
		System.out.println("FPS: " + frames + " | " + "UPS: " + updates);
		frames = 0;
		updates = 0;
	}

	/**
	 * Returns the Render class.
	 *
	 * @return The Render class.
	 */
	public Render getRender() {
		return render;
	}

	/**
	 * Returns the Menu class.
	 *
	 * @return The Menu class.
	 */
	public Menu getMenu() {
		return menu;
	}

	/**
	 * Returns the Playing class.
	 *
	 * @return The Playing class.
	 */
	public Playing getPlaying() {
		return playing;
	}

	/**
	 * Returns the Editing class.
	 *
	 * @return The Editing class.
	 */
	public Editing getEditing() {
		return editing;
	}

	/**
	 * Returns the TileManager class.
	 *
	 * @return The TileManager class.
	 */
	public TileManager getTileManager() {
		return tileManager;
	}

	/**
	 * Returns the GameOver class.
	 *
	 * @return The GameOver class.
	 */
	public GameOver getGameOver() {
		return gameOver;
	}
}