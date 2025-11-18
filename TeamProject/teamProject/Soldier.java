package teamProject;
import java.util.Random;

import enemyEncounter.EnemyEncounter;

public class Soldier extends MediumEnemy{
	static Random rand = new Random();
	
	/**
	 * Soldier Monster Constructor
	 * Health: 50-70
	 * Defense: 7-10
	 * Attack: 9-11
	 * Movement: 2
	 */
	public Soldier() {
		super(rand.nextInt(50, 71), rand.nextInt(7, 11), rand.nextInt(9, 12), 2);
	}
	/**
	 * roll d8
	 * 1-7 attack
	 * 8 nothing
	 */
	public  void enemyTurn() {
		int action = rand.nextInt(1, 9);
		if(action <= 7) {
			this.attack();
		}else {
			EnemyEncounter.setTextBox("Soldier's attack misses.");
			EnemyEncounter.setPlayerTurn(true);
		}
	}
}
