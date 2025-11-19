package teamProject;
import java.util.Random;

import enemyEncounter.EnemyEncounter;
import guiCode.SmallEnemyGui;

public class Spider extends SmallEnemy{
	static Random rand = new Random();
	
	/**
	 * Spider Monster Constructor
	 * Health: 15-30
	 * Defense: 1-5
	 * Attack: 3-7
	 * Move: 3
	 */
	public Spider() {
		super(rand.nextInt(15, 31), rand.nextInt(1, 6), rand.nextInt(3, 8), 3);
	}
	/**
	 * Increases defense 1-2
	 */
	public void silk() {
		int boost = rand.nextInt(1, 3);
		EnemyEncounter.setTextBox("Spider spins silk. Defense increases by " + boost);
		super.setDefense(getDefense() + boost);
		SmallEnemyGui.setIconText(this);
		EnemyEncounter.setPlayerTurn(true);
	}
	/**
	 * Roll a d6
	 * 1-3 attack
	 * 4-5 silk
	 * 6 nothing
	 */
	public  void enemyTurn() {
		
		int action = rand.nextInt(1, 7);
		if(action <= 3) {
			this.attack();
		}else if(action <= 5) {
			this.silk();
		}else {
			EnemyEncounter.setTextBox("Spider's attack misses");
			EnemyEncounter.setPlayerTurn(true);
		}
	}
}
