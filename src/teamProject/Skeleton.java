package teamProject;
import java.util.Random;

import enemyEncounter.EnemyEncounter;

public class Skeleton extends MediumEnemy{
	static Random rand = new Random();
	
	/**
	 * Skeleton Monster Constructor
	 * Health: 20-30
	 * Defense: 4-8
	 * Attack: 4-8
	 * Movement: 2
	 */
	public Skeleton() {
		super(rand.nextInt(20, 31), rand.nextInt(4, 9), rand.nextInt(4, 9), 2);
	}
	/**
	 * Roll d8
	 * 1-6 attack
	 * 7-8 nothing
	 */
	public  void enemyTurn() {
		
		int action = rand.nextInt(1, 9);
		if(action <= 6) {
			this.attack();
		}else {
			EnemyEncounter.setTextBox("Skeleton's attack misses.");
			EnemyEncounter.setPlayerTurn(true);
		}
	}
}
