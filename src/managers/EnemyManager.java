package managers;

import static utilities.Constants.Direction.*;
import static utilities.Constants.Enemies.*;
import static utilities.Constants.Tiles.*;

import java.util.ArrayList;

import entity.enemy.Tomato;
import entity.enemy.Enemy;
import entity.enemy.Cabbage;
import entity.enemy.Corn;
import entity.enemy.Onion;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import objects.PathPoint;
import scenes.Playing;
import utilities.ImageFix;
import utilities.SpritesHolder;


 /**
 * The class Enemy manager
 */ 
public class EnemyManager {

	@SuppressWarnings("unused")
	/**
	 * Represent Playing class
	 */
	private Playing playing;
	/**
	 * List of enemy images
	 */
	private Image[] enemyImages;

	/**
	 * List of enemies
	 */
	private ArrayList<Enemy> enemies = new ArrayList<>();
	/**
	 * Start of path
	 */
	private PathPoint start;
	/**
	 * End of path
	 */
	private PathPoint end;
	
	/**
	 * Slow Effect's Image
	 */
	private Image slowEffectImage;

	/**
	 * Initialize fields
	 * Load effect's images and enemy's images
	 */
	public EnemyManager(Playing playing, PathPoint start, PathPoint end) { 

		this.start = start;
		this.end = end;

		this.playing = playing;
		enemyImages = new Image[4];
		
		loadEffectImages();
		loadEnemyImages();
	}

	/**
	 * Load effect's images
	 */
	private void loadEffectImages() { 

		slowEffectImage = ImageFix.getSubImage(SpritesHolder.getMapSprite(), 32 * 9, 32 * 2, 32, 32);
	}

	/**
	 * Load enemy's images
	 */
	private void loadEnemyImages() { 

		Image atlas = SpritesHolder.getMapSprite();
		for (int i = 0; i < enemyImages.length; ++i) {
			enemyImages[i] = ImageFix.getSubImage(atlas, 32 * i, 32 * 1, 32, 32);
		}
	}

	/**
	 * Update EnemyManager using thread
	 */
	public void update() { 

		Thread thread = new Thread(() -> {
			for (Enemy enemy : enemies) {
				if (!enemy.isAlive()) {
					continue;
				}
				updateEnemyMove(enemy);
			}
		});
		thread.start();
	}

	/**
	 * Move enemies
	 */
	public void updateEnemyMove(Enemy e) { 

		if (e.getLastDir() == -1) {
			setNewDirectionAndMove(e);
		}

		int newX = (int) (e.getX() + getSpeedXandWidth(e.getLastDir(), e));
		int newY = (int) (e.getY() + getSpeedYandHeight(e.getLastDir(), e));
		
		if(newX < 0 || newY < 0 || newX >= 20 * 32 || newY >= 20 * 32) {
			setNewDirectionAndMove(e);
		}
		else if (getTileType(newX, newY) == ROAD_TILE) {
			e.move(e.getLastDir());
		} 
		else if (isAtEnd(e)) {
			e.kill();
			playing.removeOneLife();
		}
		else {
			setNewDirectionAndMove(e);
		}
	}

	/**
	 * Return if this enemy is at the end of the path
	 */
	private boolean isAtEnd(Enemy enemy) { 

		// TODO Auto-generated method stub
		if (enemy.getX() == 32 * end.getxIndex() && enemy.getY() == 32 * end.getyIndex()) {
			return true;
		}
		return false;
	}

	/**
	 * Change direction if enemy can't move into current direction
	 */
	private void setNewDirectionAndMove(Enemy enemy) { 

		int dir = enemy.getLastDir();

		// move into the current tile 100%

		int xIndex = (int) (enemy.getX() / 32);
		int yIndex = (int) (enemy.getY() / 32);

		fixEnemyOffsetTile(enemy, dir, xIndex, yIndex);

		if (isAtEnd(enemy)) {
			return;
		}

		// Not walk back
		if (dir == LEFT || dir == RIGHT) {
			int newY = (int) (enemy.getY() + getSpeedYandHeight(UP, enemy));
			if (getTileType((int) enemy.getX(), newY) == ROAD_TILE) {
				enemy.move(UP);
			} else {
				enemy.move(DOWN);
			}
		} else {
			int newX = (int) (enemy.getX() + getSpeedXandWidth(RIGHT, enemy));
			if (getTileType(newX, (int) enemy.getY()) == ROAD_TILE) {
				enemy.move(RIGHT);
			} else {
				enemy.move(LEFT);
			}
		}
	}

	/**
	 * Fix enemy's offset tile
	 */
	private void fixEnemyOffsetTile(Enemy enemy, int dir, int xIndex, int yIndex) { 

		switch (dir) {
		case RIGHT:
			if (xIndex < 19) {
				xIndex++;
			}
			break;

		case DOWN:
			if (yIndex > 0) {
				yIndex++;
			}
			break;
		}
		enemy.setPos(32 * xIndex, 32 * yIndex);
	}

	/**
	 * Get type of the tile in this coordinate (x, y)
	 */
	private int getTileType(int x, int y) { 

		return playing.getTileType(x, y);
	}

	/**
	 * Get speedX
	 */
	private float getSpeedXandWidth(int dir, Enemy e) { 

		// TODO Auto-generated method stub
		if (dir == LEFT) {
			return -e.getSpeed();
		}
		// Dealing with sprite offset
		else if (dir == RIGHT) {
			return e.getSpeed() + 32;
		}
		return 0;
	}

	/**
	 * Get speedY
	 */
	private float getSpeedYandHeight(int dir, Enemy e) { 

		// TODO Auto-generated method stub
		if (dir == UP) {
			return -e.getSpeed();
		}
		// Dealing with sprite offset
		else if (dir == DOWN) {
			return e.getSpeed() + 32;
		}
		return 0;
	}

	/**
	 * Add enemy into the wave
	 */
	public void addEnemy(int enemyType, int waveIndex) { 


		int x = 32 * start.getxIndex();
		int y = 32 * start.getyIndex();

		switch (enemyType) {
		case CORN:
			enemies.add(new Corn(x, y, 0, waveIndex));
			break;
		case TOMATO:
			enemies.add(new Tomato(x, y, 0, waveIndex));
			break;
		case CABBAGE:
			enemies.add(new Cabbage(x, y, 0, waveIndex));
			break;
		case ONION:
			enemies.add(new Onion(x, y, 0, waveIndex));
			break;
		}
	}

	/**
	 * Draw enemies, health bars, and effects
	 */
	public void draw(GraphicsContext gc) { 

		for (int i = enemies.size() - 1; i >= 0; i--) {
			if (!enemies.get(i).isAlive()) {
				enemies.remove(i);
			}
		}
		for (Enemy e : enemies) {
			drawEnemy(e, gc);
			drawHealthBar(e, gc);
			drawEffects(e, gc);
		}
	}
	
	/**
	 * Draw effects
	 */
	private void drawEffects(Enemy e, GraphicsContext gc) { 

		if(e.isSlowed()) {
			gc.drawImage(slowEffectImage, (int)e.getX(), (int)e.getY() - 6);
		}
	}

	/**
	 * Draw heath bar
	 */
	private void drawHealthBar(Enemy enemy, GraphicsContext gc) { 

		// Full Health Bar
		gc.setFill(Color.LIGHTGRAY);
		gc.fillRect((int) enemy.getX() + 16 - (enemy.getBarWidth() / 2), (int) enemy.getY() - 8 - 6, enemy.getBarWidth(),
				3);

		// Health Bar
		gc.setFill(Color.RED);
		gc.fillRect((int) enemy.getX() + 16 - (enemy.getBarWidth() / 2), (int) enemy.getY() - 8 - 6,
				(int) (getHealthPercentage(enemy) * enemy.getBarWidth()), 3);
	}

	/**
	 * Get this enemy's HP/MaxHP
	 */
	private float getHealthPercentage(Enemy enemy) { 

		return (float) enemy.getHealth() / enemy.getMaxHealth();
	}

	/**
	 * Draw enemy
	 */
	private void drawEnemy(Enemy enemy, GraphicsContext gc) { 

		gc.drawImage(enemyImages[enemy.getEnemyType()], (int) enemy.getX(), (int) enemy.getY() - 6);
	}

	/**
	 * Get the list of enemies
	 */
	public ArrayList<Enemy> getEnemies() { 

		return enemies;
	}

	/**
	 * Spawn enemy at a specific wave
	 */
	public void spawnEnemy(int nextEnemy, int waveIndex) { 

		addEnemy(nextEnemy, waveIndex);
	}

	/**
	 * Get amount of alive enemies
	 */
	public int getAmountOfAliveEnemies() { 

		return getEnemies().size();
	}

	/**
	 * Clear enemies list
	 */
	public void reset() { 

		enemies.clear();
	}
}
