package teamProject;
import java.util.Random;

import enemyEncounter.EnemyEncounter;
import guiCode.LargeEnemyGui;

public class Dragon extends LargeEnemy{
	static Random rand = new Random();
	
	/**
	 * Dragon Monster Constructor
	 * Health: 200-300
	 * Defense: 10-18
	 * Attack: 15-20
	 * Movement: 4
	 */
	public Dragon() {
		super(rand.nextInt(200, 301), rand.nextInt(10, 19), rand.nextInt(15, 21), 4);
	}
	/**
	 * Special attack. Still undecided on effects.
	 */
	public void fireBreath() {
		//TODO Ignores player defense?
		EnemyEncounter.setTextBox("Dragon breathes fire and deals " + super.getAttack() + " damage");
		LargeEnemyGui.setIconText(this);
		EnemyEncounter.setPlayerTurn(true);
	}
	/**
	 * Roll d10
	 * 1-8 attack
	 * 9-10 fireBreath
	 */
	public  void enemyTurn() {
		int action = rand.nextInt(1, 11);
		if(action <= 8) {
			this.attack();
		}else {
			this.fireBreath();
		}
	}
}
