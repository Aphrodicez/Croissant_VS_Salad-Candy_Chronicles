package scenes;

import javafx.scene.image.Image;
import main.Game;


 /**
 * The class Game scene
 */ 
public class GameScene {
	/**
	 * Game class object.
	 */
	private Game game;
	/**
	 * animation index.
	 */
	private int animationIndex;
	/**
	 * animation playing speed.
	 */
	private int ANIMATION_SPEED = 9;
	/**
	 * animation tick count.
	 */
	private int tick;
	
	/**
	 * initialize field.
	 */
	public GameScene(Game game) { 

		this.game = game;
	}
	/**
	 * getter for Game object.
	 */
	public Game getGame() { 

		return this.game;
	}
	/**
	 * update game tick.
	 */
	public void updateTick() { 

		tick++;
		if(tick >= ANIMATION_SPEED) {
			tick = 0;
			animationIndex = (animationIndex + 1) % 4;
		}
	}
	/*
	 * Get Animation Index
	 */

/** 
 *
 * Gets the animation index
 *
 * @return the animation index
 */
	public int getAnimationIndex() { 

		return animationIndex;
	}
	/**
	 * return if the sprite has animation.
	 */
	public boolean isAnimation(int spriteID) { 

		return game.getTileManager().isSpriteAnimation(spriteID);
	}
	/**
	 * get sprite for animated sprite.
	 */
	public Image getSprite(int spriteID, int animationIndex) { 

		return game.getTileManager().getAnimationSprite(spriteID, animationIndex);
	}
	/**
	 * get sprite for normal sprite.
	 */
	public Image getSprite(int spriteID) { 

		return game.getTileManager().getSprite(spriteID);
	}
}
