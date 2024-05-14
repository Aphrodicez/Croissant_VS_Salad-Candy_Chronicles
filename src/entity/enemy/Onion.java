package entity.enemy;

import static utilities.Constants.Enemies.ONION;

/**
 * This class represents the Onion enemy type.
 */
public class Onion extends Enemy {

    /**
     * Constructor for creating an Onion enemy.
     * Initializes the fields of the Onion enemy based on the provided parameters.
     * 
     * @param x          The x position (in pixels) of the Onion enemy in the game.
     * @param y          The y position (in pixels) of the Onion enemy in the game.
     * @param id         The id of the Onion enemy in the enemyList.
     * @param waveIndex  The index of the wave this Onion enemy belongs to.
     */
    public Onion(float x, float y, int id, int waveIndex) {
        super(x, y, id, ONION, waveIndex);
    }
}
