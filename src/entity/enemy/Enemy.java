package entity.enemy;

import static utilities.Constants.Direction.*;

import javafx.scene.shape.Rectangle;
import utilities.Constants;

/**
 * This class represents the base class for all the enemies in the game.
 * It contains common elements and functionalities for enemies.
 */
public class Enemy {

    /**
     * This enemy's x position in pixels.
     */
    private float x;

    /**
     * This enemy's y position in pixels.
     */
    private float y;

    /**
     * This enemy's ID.
     */
    private int id;

    /**
     * This enemy's type.
     */
    private int enemyType;

    /**
     * This enemy's wave index.
     */
    private int waveIndex;

    /**
     * Flag indicating if the enemy is alive.
     */
    private boolean alive;

    /**
     * This enemy's maximum health.
     */
    private int maxHealth;

    /**
     * This enemy's current health.
     */
    private int health;

    /**
     * This enemy's speed.
     */
    private float speed;

    /**
     * This enemy's health bar width.
     */
    private int barWidth;

    /**
     * This enemy's hitbox.
     */
    private Rectangle bounds;

    /**
     * The last movement direction of this enemy.
     */
    private int lastDir;

    /**
     * Time passed since this enemy got slowed.
     */
    private int slowTick = 2 * 60;

    /**
     * The limit of slow tick.
     */
    private int slowTickLimit = 2 * 60;

    /**
     * Initializes the enemy with the specified parameters.
     *
     * @param x          The x position in pixels of the enemy.
     * @param y          The y position in pixels of the enemy.
     * @param id         The id of the enemy.
     * @param enemyType  The type of the enemy.
     * @param waveIndex  The index of the wave this enemy belongs to.
     */
    public Enemy(float x, float y, int id, int enemyType, int waveIndex) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.enemyType = enemyType;
        this.waveIndex = waveIndex;
        this.alive = true;

        this.maxHealth = Constants.Enemies.getConstantStartHealth(enemyType) + 50 * waveIndex;
        this.speed = Constants.Enemies.getConstantSpeed(enemyType) + 0.1f * waveIndex;

        this.health = this.maxHealth;
        this.barWidth = 20;
        this.bounds = new Rectangle((int) x, (int) y, 32, 32);
        this.lastDir = -1;
    }

    /**
     * Retrieves the speed of the enemy.
     *
     * @return The speed of the enemy.
     */
    public float getSpeed() {
        return speed;
    }

    /**
     * Decreases the enemy's health by the specified amount.
     *
     * @param damage The amount of damage to inflict on the enemy.
     */
    public void hurt(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            alive = false;
        }
    }

    /**
     * Moves the enemy in the specified direction.
     *
     * @param dir The direction to move the enemy.
     */
    public void move(int dir) {
        this.lastDir = dir;

        float currentSpeed = speed;

        if (isSlowed()) {
            slowTick++;
            currentSpeed *= 0.5f;
        }

        switch (dir) {
            case LEFT:
                this.x -= currentSpeed;
                break;
            case RIGHT:
                this.x += currentSpeed;
                break;
            case UP:
                this.y -= currentSpeed;
                break;
            case DOWN:
                this.y += currentSpeed;
                break;
        }
        updateHitbox();
    }

    /**
     * Updates the hitbox of the enemy.
     */
    private void updateHitbox() {
        this.bounds.setX((int) x);
        this.bounds.setY((int) y);
    }

    /**
     * Resets the slow tick of the enemy.
     */
    public void slow() {
        this.slowTick = 0;
    }

    /**
     * Sets the alive state of the enemy to false.
     */
    public void kill() {
        this.alive = false;
    }

    /**
     * Checks if the enemy is currently slowed.
     *
     * @return true if the enemy is slowed, false otherwise.
     */
    public boolean isSlowed() {
        return slowTick < slowTickLimit;
    }

    /**
     * Retrieves the ratio of the enemy's current health to its maximum health.
     *
     * @return The ratio of current health to maximum health.
     */
    public float getHealthBarFloat() {
        return (float) health / maxHealth;
    }

    /**
     * Sets the position of the enemy.
     *
     * @param x The x position in pixels.
     * @param y The y position in pixels.
     */
    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Sets the health of the enemy.
     *
     * @param health The health value to set.
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Retrieves the x position of the enemy.
     *
     * @return The x position in pixels.
     */
    public float getX() {
        return x;
    }

    /**
     * Retrieves the y position of the enemy.
     *
     * @return The y position in pixels.
     */
    public float getY() {
        return y;
    }

    /**
     * Retrieves the ID of the enemy.
     *
     * @return The ID of the enemy.
     */
    public int getId() {
        return id;
    }

    /**
     * Retrieves the type of the enemy.
     *
     * @return The type of the enemy.
     */
    public int getEnemyType() {
        return enemyType;
    }

    /**
     * Retrieves the index of the wave this enemy belongs to.
     *
     * @return The wave index of the enemy.
     */
    public int getWaveIndex() {
        return waveIndex;
    }

    /**
     * Checks if the enemy is alive.
     *
     * @return true if the enemy is alive, false otherwise.
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * Retrieves the maximum health of the enemy.
     *
     * @return The maximum health of the enemy.
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     * Retrieves the current health of the enemy.
     *
     * @return The current health of the enemy.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Retrieves the width of the enemy's health bar.
     *
     * @return The width of the health bar.
     */
    public int getBarWidth() {
        return barWidth;
    }

    /**
     * Retrieves the hitbox of the enemy.
     *
     * @return The hitbox of the enemy.
     */
    public Rectangle getBounds() {
        return bounds;
    }

    /**
     * Retrieves the last movement direction of the enemy.
     *
     * @return The last movement direction of the enemy.
     */
    public int getLastDir() {
        return lastDir;
    }

    /**
     * Retrieves the value of the slow tick.
     *
     * @return The value of the slow tick.
     */
    public int getSlowTick() {
        return slowTick;
    }

    /**
     * Retrieves the limit of the slow tick.
     *
     * @return The limit of the slow tick.
     */
    public int getSlowTickLimit() {
        return slowTickLimit;
    }
}
