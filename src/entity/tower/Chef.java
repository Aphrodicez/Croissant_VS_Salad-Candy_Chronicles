package entity.tower;

import static utilities.Constants.Towers.CHEF;
import static utilities.Constants.Towers.getConstantDefaultCooldown;
import static utilities.Constants.Towers.getConstantDefaultRange;
import static utilities.Constants.Towers.getConstantStartDamage;

import entity.enemy.Enemy;
import managers.ProjectileManager;

/**
 * The `Chef` class represents a tower of type "Chef".
 * It extends the `Tower` class and includes specific implementations for the `attack()` and `performUltimate()` methods.
 * The Chef tower specializes in launching projectiles at enemies and has the ability to perform an ultimate attack by launching multiple projectiles simultaneously.
 */
public class Chef extends Tower {

    /**
     * Constructs a `Chef` tower with the specified position and ID.
     *
     * @param x  the x position of the tower (pixel)
     * @param y  the y position of the tower (pixel)
     * @param id the ID of the tower
     */
    public Chef(int x, int y, int id) {
        super(x, y, id, CHEF, getConstantStartDamage(CHEF), getConstantDefaultRange(CHEF), getConstantDefaultCooldown(CHEF));
    }

    /**
     * Get the name of this tower.
     *
     * @return the name of the tower ("Chef")
     */
    @Override
    public String getName() {
        return "Chef";
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
     * Launches multiple projectiles at the enemy with decreasing strength based on the iteration.
     *
     * @param pm the projectile manager
     * @param e  the enemy to target with the ultimate
     */
    @Override
    public void performUltimate(ProjectileManager pm, Enemy e) {
        for (int i = 1; i <= 3; i++) {
            pm.newProjectile(this, e, (float) (1 - 0.1 * i));
        }
    }
}
