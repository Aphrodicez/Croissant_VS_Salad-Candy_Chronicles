package entity.tower;

import static utilities.Constants.Towers.OWNER;
import static utilities.Constants.Towers.getConstantDefaultCooldown;
import static utilities.Constants.Towers.getConstantDefaultRange;
import static utilities.Constants.Towers.getConstantStartDamage;

import entity.enemy.Enemy;
import managers.ProjectileManager;

/**
 * The `Owner` class represents a tower of type "Owner".
 * It extends the `Tower` class and includes specific implementations for the `attack()` and `performUltimate()` methods.
 * The Owner tower specializes in performing its ultimate ability and does not have a regular attack.
 */
public class Owner extends Tower {
	
	/**
	 * Constructs an `Owner` tower with the specified position and ID.
	 *
	 * @param x  the x position of the tower (pixel)
	 * @param y  the y position of the tower (pixel)
	 * @param id the ID of the tower
	 */
	public Owner(int x, int y, int id) {
		super(x, y, id, OWNER, getConstantStartDamage(OWNER), getConstantDefaultRange(OWNER), getConstantDefaultCooldown(OWNER));
	}

	/**
	 * Get the name of this tower.
	 *
	 * @return the name of the tower ("Owner")
	 */
	@Override
	public String getName() {
		return "Owner";
	}

	/**
	 * Perform an attack on the selected enemy.
	 * Since the Owner tower does not have a regular attack, it directly performs its ultimate ability.
	 *
	 * @param pm the projectile manager
	 * @param e  the enemy to attack
	 */
	@Override
	public void attack(ProjectileManager pm, Enemy e) {
		performUltimate(pm, e);
	}

	/**
	 * Perform the tower's ultimate ability.
	 * Calls the `ownerUltimate()` method of the projectile manager.
	 *
	 * @param pm the projectile manager
	 * @param e  the enemy to target with the ultimate
	 */
	@Override
	public void performUltimate(ProjectileManager pm, Enemy e) {
		pm.ownerUltimate(this);
	}
}
