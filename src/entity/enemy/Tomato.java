package entity.enemy;

import static utilities.Constants.Enemies.TOMATO;

/**
 * This class represents the Tomato enemy type.
 */
public class Tomato extends Enemy {

    /**
     * Constructor for creating a Tomato enemy.
     * Initializes the fields of the Tomato enemy based on the provided parameters.
     * 
     * @param x          The x position (in pixels) of the Tomato enemy in the game.
     * @param y          The y position (in pixels) of the Tomato enemy in the game.
     * @param id         The ID of the Tomato enemy in the enemyList.
     * @param waveIndex  The index of the wave this Tomato enemy belongs to.
     */
    public Tomato(float x, float y, int ID, int waveIndex) {
        super(x, y, ID, TOMATO, waveIndex);
    }
}
