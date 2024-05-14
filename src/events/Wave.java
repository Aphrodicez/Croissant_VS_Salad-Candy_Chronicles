package events;

import java.util.ArrayList;

/**
 * Represents a wave of enemies in the game.
 * A wave consists of a list of enemies that are spawned together.
 */
public class Wave {
	
	/**
	 * List of enemies in the wave.
	 */
	private ArrayList<Integer> enemyList;
	
	/**
	 * Initializes the wave with the specified list of enemies.
	 *
	 * @param enemyList the list of enemies in the wave
	 */
	public Wave(ArrayList<Integer> enemyList) {
		this.enemyList = enemyList;
	}

	/**
	 * Retrieves the list of enemies in the wave.
	 *
	 * @return the list of enemies in the wave
	 */
	public ArrayList<Integer> getEnemyList() {
		return enemyList;
	}
}