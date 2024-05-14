package entity.tower;

import static utilities.Constants.Towers.*;

import entity.enemy.Enemy;
import managers.ProjectileManager;

/**
 * This class represents a tower in the game.
 * It serves as a base class for all types of towers and contains common elements and functionality.
 */
public abstract class Tower {

    /**
     * This tower's x position (Pixel)
     */
    private int x;

    /**
     * This tower's y position (Pixel)
     */
    private int y;

    /**
     * This tower's id
     */
    private int id;

    /**
     * This tower's type
     */
    private int towerType;

    /**
     * This tower's ATK (Attack) value
     */
    private int atk;

    /**
     * This tower's attack range
     */
    private float range;

    /**
     * This tower's attack cooldown
     */
    private float cooldown;

    /**
     * Time passed since this tower last attacked
     */
    private int cooldownTick;

    /**
     * This tower's tier
     */
    private int tier;

    /**
     * This tower's animation status
     */
    private int animationStatus = 0;

    /**
     * Time passed since this tower performed an ultimate
     */
    private int ultimateCooldownTick;

    /**
     * Initializes the tower with the specified attributes.
     *
     * @param x          the x position of the tower (pixel)
     * @param y          the y position of the tower (pixel)
     * @param id         the id of the tower
     * @param towerType  the type of the tower
     * @param atk        the ATK (attack) value of the tower
     * @param range      the attack range of the tower
     * @param cooldown   the attack cooldown of the tower
     */
    public Tower(int x, int y, int id, int towerType, int atk, float range, float cooldown) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.towerType = towerType;
        this.cooldownTick = (int) cooldown - 60;
        this.ultimateCooldownTick = 5 * 60;

        this.atk = atk;
        this.range = range;
        this.cooldown = cooldown;

        this.tier = 1;
    }

    /**
     * Get this tower's x position.
     *
     * @return the x position of the tower (pixel)
     */
    public int getX() {
        return x;
    }

    /**
     * Get this tower's y position.
     *
     * @return the y position of the tower (pixel)
     */
    public int getY() {
        return y;
    }

    /**
     * Get this tower's id.
     *
     * @return the id of the tower
     */
    public int getId() {
        return id;
    }

    /**
     * Get this tower's type.
     *
     * @return the type of the tower
     */
    public int getTowerType() {
        return towerType;
    }

    /**
     * Get this tower's ATK (Attack) value.
     *
     * @return the ATK value of the tower
     */
    public int getAtk() {
        return atk;
    }

    /**
     * Get this tower's attack range.
     *
     * @return the attack range of the tower
     */
    public float getRange() {
        return range;
    }

    /**
     * Get this tower's attack cooldown.
     *
     * @return the attack cooldown of the tower
     */
    public float getCooldown() {
        return cooldown;
    }

    /**
     * Check if the attack cooldown is over.
     *
     * @return true if the cooldown is over, false otherwise
     */
    public boolean isCooldownOver() {
        return cooldownTick >= this.cooldown;
    }

    /**
     * Check if the ultimate cooldown is over.
     *
     * @return true if the ultimate cooldown is over, false otherwise
     */
    public boolean isUltimateCooldownOver() {
        return ultimateCooldownTick >= 5 * 60;
    }

    /**
     * Update the ticks for the tower.
     */
    public void update() {
        cooldownTick++;
        ultimateCooldownTick++;
    }

    /**
     * Reset the attack cooldown for the tower.
     */
    public void resetCooldown() {
        cooldownTick = 0;
    }

    /**
     * Reset the ultimate cooldown for the tower.
     */
    public void resetUltimateCooldown() {
        ultimateCooldownTick = 0;
    }

    /**
     * Set the x position of the tower.
     *
     * @param newX the new x position of the tower (pixel)
     */
    public void setX(int newX) {
        x = newX;
    }

    /**
     * Set the y position of the tower.
     *
     * @param newY the new y position of the tower (pixel)
     */
    public void setY(int newY) {
        y = newY;
    }

    /**
     * Set the id of the tower.
     *
     * @param newId the new id of the tower
     */
    public void setId(int newId) {
        id = newId;
    }

    /**
     * Get the name of the tower.
     *
     * @return the name of the tower
     */
    public abstract String getName();

    /**
     * Perform an attack on the selected enemy.
     *
     * @param pm the projectile manager
     * @param e  the enemy to attack
     */
    public abstract void attack(ProjectileManager pm, Enemy e);

    /**
     * Perform the tower's ultimate ability.
     *
     * @param pm the projectile manager
     * @param e  the enemy to target with the ultimate
     */
    public abstract void performUltimate(ProjectileManager pm, Enemy e);

    /**
     * Get the cost of the tower.
     *
     * @return the cost of the tower
     */
    public int getCost() {
        return getConstantTowerCost(towerType);
    }

    /**
     * Get the upgrade cost of the tower.
     *
     * @return the upgrade cost of the tower
     */
    public int getUpgradeCost() {
        return (int) (getConstantTowerCost(towerType) * 0.3f);
    }

    /**
     * Get the sell price of the tower.
     *
     * @return the sell price of the tower
     */
    public int getSellPrice() {
        int upgradedPrice = (getTier() - 1) * getUpgradeCost();
        return (getConstantTowerCost(towerType) / 2) + upgradedPrice;
    }

    /**
     * Upgrade the tower to the next tier.
     */
    public void upgradeTower() {
        this.tier++;

        switch (towerType) {
            case PRINCESS:
                this.atk += 5;
                this.range += 20;
                this.cooldown -= 15;
                break;
            case CHEF:
                this.atk += 2;
                this.range += 20;
                this.cooldown -= 5;
                break;
            case OWNER:
                this.range += 20;
                this.cooldown -= 10;
                break;
        }
    }

    /**
     * Get the tier of the tower.
     *
     * @return the tier of the tower
     */
    public int getTier() {
        return tier;
    }

    /**
     * Get the animation status of the tower.
     *
     * @return the animation status of the tower
     */
    public int getAnimationStatus() {
        return animationStatus;
    }

    /**
     * Toggle the animation status of the tower.
     * If the current animation status is 1, it will be changed to 0,
     * and if the current animation status is 0, it will be changed to 1.
     */
    public void toggleAnimationStatus() {
        if (animationStatus == 1) {
            animationStatus = 0;
        } else {
            animationStatus = 1;
        }
    }
}
