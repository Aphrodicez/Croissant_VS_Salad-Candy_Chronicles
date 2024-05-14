package entity.tower;

import static utilities.Constants.Towers.*;

import entity.enemy.Enemy;
import managers.ProjectileManager;

/**
 * The `Princess` class represents a tower of type "Princess".
 * It extends the `Tower` class and includes specific implementations for the `attack()` and `performUltimate()` methods.
 */
public class Princess extends Tower {

    /**
     * Constructs a `Princess` tower with the specified position and ID.
     *
     * @param x  the x position of the tower (pixel)
     * @param y  the y position of the tower (pixel)
     * @param id the ID of the tower
     */
    public Princess(int x, int y, int id) {
        super(x, y, id, PRINCESS, getConstantStartDamage(PRINCESS), getConstantDefaultRange(PRINCESS), getConstantDefaultCooldown(PRINCESS));
    }

    /**
     * Get the name of this tower.
     *
     * @return the name of the tower ("Princess")
     */
    @Override
    public String getName() {
        return "Princess";
    }

    /**
     * Perform an attack on the selected enemy.
     * Creates a new projectile to attack the enemy and, if the tower's tier is at least 2 and the ultimate cooldown is over,
     * performs the tower's ultimate ability.
     *
     * @param pm the projectile manager
     * @param e  the enemy to attack
     */
    @Override
    public void attack(ProjectileManager pm, Enemy e) {
        pm.newProjectile(this, e, 1);
        if (this.getTier() >= 2 && isUltimateCooldownOver()) {
            performUltimate(pm, e);
            resetUltimateCooldown();
        }
    }

    /**
     * Perform the tower's ultimate ability.
     * Activates the princess's ultimate ability by calling the `princessUltimate()` method of the projectile manager.
     *
     * @param pm the projectile manager
     * @param e  the enemy to target with the ultimate
     */
    @Override
    public void performUltimate(ProjectileManager pm, Enemy e) {
        pm.princessUltimate(this);
    }
}
