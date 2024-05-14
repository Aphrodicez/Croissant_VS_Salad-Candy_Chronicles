package entity.enemy;

import static utilities.Constants.Enemies.CABBAGE;

/**
 * This class represents the Cabbage enemy type.
 */
public class Cabbage extends Enemy {

    /**
     * Constructor for creating a Cabbage enemy.
     * Initializes the fields of the Cabbage enemy based on the provided parameters.
     * 
     * @param x          The x position (in pixels) of the Cabbage enemy in the game.
     * @param y          The y position (in pixels) of the Cabbage enemy in the game.
     * @param id         The id of the Cabbage enemy in the enemyList.
     * @param waveIndex  The index of the wave this Cabbage enemy belongs to.
     */
    public Cabbage(float x, float y, int id, int waveIndex) {
        super(x, y, id, CABBAGE, waveIndex);
    }
}
