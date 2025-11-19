package teamProject;
import java.util.Random;

import enemyEncounter.EnemyEncounter;

public class Ogre extends LargeEnemy{
	static Random rand = new Random();
	
	/**
	 * Ogre Monster Constructor
	 * Health: 60-80
	 * Defense: 5-10
	 * Attack: 8-12
	 * Movement: 2
	 */
	public Ogre() {
		super(rand.nextInt(60, 81), rand.nextInt(5, 11), rand.nextInt(8, 13), 2);
	}
	
	/**
	 * Roll d10
	 * 1-8 attack
	 * 9-10 nothing
	 */
	public  void enemyTurn() {
		
		int action = rand.nextInt(1, 11);
		if(action <= 8) {
			this.attack();
		}else {
			EnemyEncounter.setTextBox("Ogre's attack misses");
			EnemyEncounter.setPlayerTurn(true);
		}
	}
}
