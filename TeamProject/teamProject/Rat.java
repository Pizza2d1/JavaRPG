package teamProject;
import java.util.Random;

import enemyEncounter.EnemyEncounter;

public class Rat extends SmallEnemy{
	static Random rand = new Random();
	/**
	 * Rat Monster Constructor
	 * Health: 10-20
	 * Defense: 0-3
	 * Attack: 1-3
	 * Movement: 2
	 */
	public Rat() {
		super(rand.nextInt(10, 21), rand.nextInt(0, 4), rand.nextInt(1, 4), 2);
	}
	/**
	 *Roll a d6.
	 *1-4 attacks
	 *5-6 nothing
	 */
	public  void enemyTurn() {
		
		int action = rand.nextInt(1, 7);
		if(action <= 4) {
			this.attack();
		}else {
			EnemyEncounter.setTextBox("Rat's attack misses.");
			EnemyEncounter.setPlayerTurn(true);
		}
	}
	
}
