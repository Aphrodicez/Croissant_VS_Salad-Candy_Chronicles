package objects;

import javafx.scene.image.Image;


 /**
 * The class Tile
 */ 
public class Tile {

	private Image[] sprite;
	private int id;
	private int tileType;
	
	/**
	 * Initialize fields (Single sprites)
	 */
	public Tile(Image sprite, int id, int tileType) { 

		this.sprite = new Image[1];
		this.sprite[0] = sprite;
		this.id = id;
		this.tileType = tileType;
	}
	/**
	 * Initialize fields (List of sprites)
	 */
	public Tile(Image[] sprite, int id, int tileType) { 

		this.sprite = sprite;
		this.id = id;
		this.tileType = tileType;
	}
	
	/**
	 * Get the sprite at animationIndex
	 */
	public Image getSprite(int animationIndex) { 

		return sprite[animationIndex];
	}
	/**
	 * Get the first sprite of the list
	 */
	public Image getSprite() { 

		return sprite[0];
	}
	/**
	 * Check this this tile's sprites list size > 1
	 */
	public boolean isAnimation() { 

		return sprite.length > 1;
	}
	
	/**
	 * Get this tile's id
	 */
	public int getId() { 

		return id;
	}
	/**
	 * Get this tile's type
	 */
	public int getTileType() { 

		return tileType;
	}
}
