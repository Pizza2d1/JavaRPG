package teamProject;
import java.util.Random;

import enemyEncounter.EnemyEncounter;
import guiCode.LargeEnemyGui;

public class Werewolf extends LargeEnemy{
	static Random rand = new Random();

	/**
	 * Werewolf Monster Constructor
	 * Health: 50-100
	 * Defense: 7-10
	 * Attack: 10-12
	 * Movement: 4
	 */
	public Werewolf() {
		super(rand.nextInt(50, 101), rand.nextInt(7, 11), rand.nextInt(10, 13), 4);
	}
	
	/**
	 * Increases attack 3-5
	 */
	public void roar() {
		int boost = rand.nextInt(3, 6);
		EnemyEncounter.setTextBox("Werewolf roars and increases attack by " + boost);
		super.setAttack(getAttack() + boost);
		LargeEnemyGui.setIconText(this);
		EnemyEncounter.setPlayerTurn(true);
	}
	/**
	 * Roll d10
	 * 1-7 attack
	 * 8-10 roar
	 */
	public  void enemyTurn() {
		int action = rand.nextInt(1, 11);
		if(action <= 7) {
			this.attack();
		}else {
			this.roar();
		}
	}
}
