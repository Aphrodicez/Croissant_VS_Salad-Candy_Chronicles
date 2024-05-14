package managers;

import java.util.ArrayList;
import java.util.Random;

import events.Wave;
import scenes.Playing;


 /**
 * The class Wave manager
 */ 
public class WaveManager {
	
	@SuppressWarnings("unused")
	/**
	 * Represent Playing Class
	 */
	private Playing playing;
	/**
	 * List of waves
	 */
	private ArrayList<Wave> waves = new ArrayList<>();
	/**
	 * Time need to spawn new enemy 
	 */
	private int enemySpawnTickLimit = 60 * 1;
	/**
	 * Last time an enemy spawn
	 */
	private int enemySpawnTick = 60;
	/**
	 * Enemy index counter
	 */
	private int enemyIndex;
	/**
	 * Wave's index counter
	 */
	private int waveIndex;
	/**
	 * Time need to get a new wave
	 */
	private int waveTickLimit = 60 * 5;
	/**
	 * Last time a new wave occur
	 */
	private int waveTick = 0;
	/**
	 * Wave time running
	 */
	private boolean waveStartTimer;
	/**
	 * Wave's wait time is over
	 */
	private boolean waveTickTimerOver;
	/**
	 * Size of waves list
	 */
	private int waveSize;
	/**
	 * Represent random class
	 */
	Random random;
	
	/**
	 * Initialize fields 
	 * Call create waves
	 */
	public WaveManager(Playing playing) { 

		this.playing  = playing;
		this.waveSize = 5;
		this.random = new Random();
		createWaves();
	}
	/**
	 * Update ticks
	 */
	public void update() { 

		if(enemySpawnTick < enemySpawnTickLimit) {
			enemySpawnTick++;
		}
		
		if(waveStartTimer) {
			waveTick++;
			if(waveTick >= waveTickLimit) {
				waveTickTimerOver = true;
			}
		}
	}
	/**
	 * Increase waveIndex
	 */
	public void increaseWaveIndex() { 

		waveIndex++;
		waveTick = 0;
		waveTickTimerOver = false;
		waveStartTimer = false;
		waveSize += random.nextInt(3);
		createWaves();
	}
	/**
	 * Get next enemy's id
	 */
	public int getNextEnemy() { 

		enemySpawnTick = 0;
		return waves.get(waveIndex).getEnemyList().get(enemyIndex++);
	}
	/**
	 * Create a new wave
	 */
	private void createWaves() { 

		ArrayList<Integer> wave = new ArrayList<>();
		for(int i = 0; i < waveSize; i++) {
			wave.add(random.nextInt(3));
		}
		waves.add(new Wave(wave));
	}
	/**
	 * Get list of waves
	 */
	public ArrayList<Wave> getWaves() { 

		return waves;
	}
	/**
	 * Check if it's time for new enemy
	 */
	public boolean isTimeForNewEnemy() { 

		return enemySpawnTick >= enemySpawnTickLimit;
	}
	/**
	 * Check if there is enemy left in wave
	 */
	public boolean isThereEnemyLeftInWave() { 

		return enemyIndex < waves.get(waveIndex).getEnemyList().size();
	}
	/**
	 * Check if there is more waves
	 */
	public boolean isThereMoreWaves() { 

		return true;
	}
	/**
	 * Start wave timer
	 */
	public void startWaveTimer() { 

		waveStartTimer = true;
	}
	/**
	 * Return if wave timer is over 
	 */
	public boolean isWaveTimerOver() { 

		return waveTickTimerOver;
	}
	/**
	 * Reset enemyIndex counter
	 */
	public void resetEnemyIndex() { 

		enemyIndex = 0;
	}
	/**
	 * Get current wave's Index
	 */
	public int getWaveIndex() { 

		return waveIndex;
	}
	/**
	 * Get time left before new wave
	 */
	public float getTimeLeft() { 

		float ticksLeft = waveTickLimit - waveTick;
		return ticksLeft / 60.0f;
	}
	/**
	 * Returm if isWaveTimerStarted
	 */
	public boolean isWaveTimerStarted() { 

		return waveStartTimer;
	}
	/**
	 * Clear waves list
	 * Create a new wave
	 * Rest fields
	 */
	public void reset() { 

		waves.clear();
		createWaves();
		enemyIndex = 0;
		waveIndex = 0;
		waveStartTimer = false;
		waveTickTimerOver = false;
		waveTick = 0;
		enemySpawnTick = enemySpawnTickLimit;
		waveSize = 5;
	}
}
