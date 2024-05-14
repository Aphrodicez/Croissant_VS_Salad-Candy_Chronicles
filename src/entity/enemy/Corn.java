package entity.enemy;

import static utilities.Constants.Enemies.CORN;

/**
 * This class represents the Corn enemy type.
 */
public class Corn extends Enemy {
	
    /**
     * Constructor for creating a Corn enemy.
     * Initializes the fields of the Corn enemy based on the provided parameters.
     * 
     * @param x          The x position (in pixels) of the Corn enemy in the game.
     * @param y          The y position (in pixels) of the Corn enemy in the game.
     * @param id         The ID of the Corn enemy in the enemyList.
     * @param waveIndex  The index of the wave this Corn enemy belongs to.
     */
    public Corn(float x, float y, int id, int waveIndex) {
        super(x, y, id, CORN, waveIndex);
    }
}