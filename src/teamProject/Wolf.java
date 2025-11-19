package teamProject;
import java.util.Random;

import enemyEncounter.EnemyEncounter;
import guiCode.SmallEnemyGui;

public class Wolf extends SmallEnemy{
	static Random rand = new Random();
	/**
	 * Wolf Monster Constructor
	 * Health: 25-40
	 * Defense: 3-7
	 * Attack: 5-10
	 * Move: 3
	 */
	public Wolf() {
		super(rand.nextInt(25, 41), rand.nextInt(3, 8), rand.nextInt(5, 11), 3);
	}
	
	/**
	 * Increases attack 1-3
	 */
	public void howl() {
		int boost = rand.nextInt(1, 4);
		EnemyEncounter.setTextBox("Wolf howls. Attack increases by " + boost);
		super.setAttack(getAttack() + boost);
		SmallEnemyGui.setIconText(this);
		EnemyEncounter.setPlayerTurn(true);
	}
	/**
	 * Roll d6
	 * 1-4 attack
	 * 5-6 howl
	 */
	public  void enemyTurn() {
		int action = rand.nextInt(1, 7);
		if(action <= 4) {
			this.attack();
		}else {
			this.howl();
		}
	}
}
