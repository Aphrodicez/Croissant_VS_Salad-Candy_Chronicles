package managers;

import static utilities.Constants.Tiles.*;

import java.util.ArrayList;

import javafx.scene.image.Image;
import objects.Tile;
import utilities.ImageFix;
import utilities.SpritesHolder;


 /**
 * The class Tile manager
 */ 
public class TileManager {
	
	@SuppressWarnings("unused")
	/**
	* Grass tile
	 */
	private Tile GRASS;

	@SuppressWarnings("unused")
	/**
	* Water tile
	 */
	private Tile WATER;

	@SuppressWarnings("unused")
	/**
	* Road left to right tile
	 */
	private Tile ROAD_LR;

	@SuppressWarnings("unused")
	/**
	* Road top to bottom tile
	 */
	private Tile ROAD_TB;

	@SuppressWarnings("unused")
	/**
	* Road bottom to right tile
	 */
	private Tile ROAD_B_TO_R;

	@SuppressWarnings("unused")
	/**
	* Road left to bottom tile
	 */
	private Tile ROAD_L_TO_B;

	@SuppressWarnings("unused")
	/**
	* Road left to top tile
	 */
	private Tile ROAD_L_TO_T;

	@SuppressWarnings("unused")
	/**
	* Road top to right tile
	 */
	private Tile ROAD_T_TO_R;

	@SuppressWarnings("unused")
	/**
	* Bottom left water corner tile
	 */
	private Tile BL_WATER_CORNER;

	@SuppressWarnings("unused")
	/**
	* Top left water corner tile
	 */
	private Tile TL_WATER_CORNER;

	@SuppressWarnings("unused")
	/**
	* Top right water corner tile
	 */
	private Tile TR_WATER_CORNER;

	@SuppressWarnings("unused")
	/**
	* Bottom right water corner tile
	 */
	private Tile BR_WATER_CORNER;

	@SuppressWarnings("unused")
	/**
	* Top water tile
	 */
	private Tile T_WATER;

	@SuppressWarnings("unused")
	/**
	* Right water tile
	 */
	private Tile R_WATER;

	@SuppressWarnings("unused")
	/**
	* Bottom water tile
	 */
	private Tile B_WATER;

	@SuppressWarnings("unused")
	/**
	* Left water tile
	 */
	private Tile L_WATER;

	@SuppressWarnings("unused")
	/**
	* Top left isle tile
	 */
	private Tile TL_ISLE;

	@SuppressWarnings("unused")
	/**
	* Top right isle tile
	 */
	private Tile TR_ISLE;

	@SuppressWarnings("unused")
	/**
	* Bottom right isle tile
	 */
	private Tile BR_ISLE;
	/**
	* Bottom left isle tile
	 */
	private Tile BL_ISLE;
	/**
	 * spriteImage
	 */
	private Image atlas;
	/**
	 * List of tiles
	 */
	private ArrayList<Tile> tiles = new ArrayList<>();
	/**
	* List of grass tiles
	 */
	private ArrayList<Tile> grass = new ArrayList<>();
	/**
	* List of water tiles
	 */
	private ArrayList<Tile> water = new ArrayList<>();
	/**
	* List of straight road tiles
	 */
	private ArrayList<Tile> roadS = new ArrayList<>();
	/**
	* List of curved road tiles
	 */
	private ArrayList<Tile> roadC = new ArrayList<>();
	/**
	* List of corner tiles
	 */
	private ArrayList<Tile> corners = new ArrayList<>();
	/**
	* List of beach tiles
	 */
	private ArrayList<Tile> beaches = new ArrayList<>();
	/**
	* List of island tiles
	 */
	private ArrayList<Tile> islands = new ArrayList<>();
	/**
	* List of path start tiles
	 */
	private ArrayList<Tile> pathStart = new ArrayList<>();
	/**
	* List of path end tiles
	 */
	private ArrayList<Tile> pathEnd = new ArrayList<>();
	/**
	* List of house tiles
	 */
	private ArrayList<Tile> houses = new ArrayList<>();	
	/**
	 * Initialize fields
	 * Create tiles
	 */
	public TileManager() { 

		atlas = SpritesHolder.getMapSprite();
		createTiles();
	}
	/**
	 * Creat tiles
	 */
	private void createTiles() { 

		int id = 0;
		
		grass.add(GRASS = new Tile(getSprite(9, 0), id++, GRASS_TILE));
		water.add(WATER = new Tile(getAnimationSprites(0, 0, 4), id++, WATER_TILE));

		roadS.add(ROAD_LR = new Tile(getSprite(8, 0), id++, ROAD_TILE));
		roadS.add(ROAD_TB = new Tile(ImageFix.getRotatedImage(getSprite(8, 0), 90), id++, ROAD_TILE));
		
		roadC.add(ROAD_B_TO_R = new Tile(getSprite(7, 0), id++, ROAD_TILE));
		
		roadC.add(ROAD_L_TO_B = new Tile(ImageFix.getRotatedImage(getSprite(7, 0), 90), id++, ROAD_TILE));
		roadC.add(ROAD_L_TO_T = new Tile(ImageFix.getRotatedImage(getSprite(7, 0), 180), id++, ROAD_TILE));
		roadC.add(ROAD_T_TO_R = new Tile(ImageFix.getRotatedImage(getSprite(7, 0), 270), id++, ROAD_TILE));

		corners.add(BL_WATER_CORNER = new Tile(ImageFix.getBuildRotatedImage(getAnimationSprites(0, 0, 4), getSprite(5, 0), 0), id++, WATER_TILE));
		corners.add(TL_WATER_CORNER = new Tile(ImageFix.getBuildRotatedImage(getAnimationSprites(0, 0, 4), getSprite(5, 0), 90), id++, WATER_TILE));
		corners.add(TR_WATER_CORNER = new Tile(ImageFix.getBuildRotatedImage(getAnimationSprites(0, 0, 4), getSprite(5, 0), 180), id++, WATER_TILE));
		corners.add(BR_WATER_CORNER = new Tile(ImageFix.getBuildRotatedImage(getAnimationSprites(0, 0, 4), getSprite(5, 0), 270), id++, WATER_TILE));

		beaches.add(T_WATER = new Tile(ImageFix.getBuildRotatedImage(getAnimationSprites(0, 0, 4), getSprite(6, 0), 0), id++, WATER_TILE));
		beaches.add(R_WATER = new Tile(ImageFix.getBuildRotatedImage(getAnimationSprites(0, 0, 4), getSprite(6, 0), 90), id++, WATER_TILE));
		beaches.add(B_WATER = new Tile(ImageFix.getBuildRotatedImage(getAnimationSprites(0, 0, 4), getSprite(6, 0), 180), id++, WATER_TILE));
		beaches.add(L_WATER = new Tile(ImageFix.getBuildRotatedImage(getAnimationSprites(0, 0, 4), getSprite(6, 0), 270), id++, WATER_TILE));

		islands.add(TL_ISLE = new Tile(ImageFix.getBuildRotatedImage(getAnimationSprites(0, 0, 4), getSprite(4, 0), 0), id++, WATER_TILE));
		islands.add(TR_ISLE = new Tile(ImageFix.getBuildRotatedImage(getAnimationSprites(0, 0, 4), getSprite(4, 0), 90), id++, WATER_TILE));
		islands.add(BR_ISLE = new Tile(ImageFix.getBuildRotatedImage(getAnimationSprites(0, 0, 4), getSprite(4, 0), 180), id++, WATER_TILE));
		islands.add(BL_ISLE = new Tile(ImageFix.getBuildRotatedImage(getAnimationSprites(0, 0, 4), getSprite(4, 0), 270), id++, WATER_TILE));
	
		pathStart.add(new Tile(getSprite(7, 2), -1, -1));
		pathEnd.add(new Tile(getSprite(8, 2), -2, -1));
		
		for(int y = 0; y < 4; y++) {
			houses.add(new Tile(getSprite(y, 4), id++, WATER_TILE));
		}
		
		tiles.addAll(grass);
		tiles.addAll(water);
		tiles.addAll(roadS);
		tiles.addAll(roadC);
		tiles.addAll(corners);
		tiles.addAll(beaches);
		tiles.addAll(islands);
		
		tiles.addAll(pathStart);
		tiles.addAll(pathEnd);
		
		tiles.addAll(houses);
	}
	/**
	 * Get tile by id
	 */
	public Tile getTile(int id) { 

		return tiles.get(id);
	}
	/**
	 * Get sprite by id
	 */
	public Image getSprite(int id) { 

		return tiles.get(id).getSprite();
	}
	/**
	 * Get sprite by x, y (index)
	 */
	private Image getSprite(int xIndex, int yIndex) { 

		return ImageFix.getSubImage(atlas, 32 * xIndex, 32 * yIndex, 32, 32);
	}
	/**
	 * Get animation sprite by id and animationIndex
	 */
	public Image getAnimationSprite(int id, int animationIndex) { 

		return tiles.get(id).getSprite(animationIndex); 
	}
	/**
	 * Get animation sprits by x, y (index) and amount
	 */
	private Image[] getAnimationSprites(int xIndex, int yIndex, int amount) { 

		Image[] images = new Image[amount];
		
		for(int i = 0; i < amount; i++) {
			images[i] = getSprite(xIndex + i, yIndex);
		}
		return images;
	}

	/**
	* Get the list of tiles
	 */
	public ArrayList<Tile> getTiles() { 

		return tiles;
	}

	/**
	* Get the list of straight road tiles
	 */
	public ArrayList<Tile> getRoadS() { 

		return roadS;
	}

	/**
	* Get the list of curved road tiles
	 */
	public ArrayList<Tile> getRoadC() { 

		return roadC;
	}

	/**
	* Get the list of corner tiles
	 */
	public ArrayList<Tile> getCorners() { 

		return corners;
	}

	/**
	* Get the list of beach tiles
	 */
	public ArrayList<Tile> getBeaches() { 

		return beaches;
	}

	/**
	* Get the list of island tiles
	 */
	public ArrayList<Tile> getIslands() { 

		return islands;
	}

	/**
	* Check if the sprite at the given id is an animation
	 */
	public boolean isSpriteAnimation(int spriteID) { 

		return tiles.get(spriteID).isAnimation();
	}

	/**
	* Get the list of grass tiles
	 */
	public ArrayList<Tile> getGrass() { 

		return grass;
	}

	/**
	* Get the list of water tiles
	 */
	public ArrayList<Tile> getWater() { 

		return water;
	}

	/**
	* Get the list of path start tiles
	 */
	public ArrayList<Tile> getPathStart() { 

		return pathStart;
	}

	/**
	* Get the list of path end tiles
	 */
	public ArrayList<Tile> getPathEnd() { 

		return pathEnd;
	}

	/**
	* Get the list of house tiles
	 */
	public ArrayList<Tile> getHouses() { 

		return houses;
	}
}
