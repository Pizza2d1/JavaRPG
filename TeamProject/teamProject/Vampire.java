package teamProject;
import java.util.Random;

import enemyEncounter.EnemyEncounter;
import guiCode.MediumEnemyGui;

public class Vampire extends MediumEnemy{
	static Random rand = new Random();

	/**
	 * Vampire Monster Constructor
	 * Health: 40-60
	 * Defense: 5-9
	 * Attack: 7-12
	 * Movement: 2
	 */
	public Vampire() {
		super(rand.nextInt(40, 61), rand.nextInt(5, 10), rand.nextInt(7, 13), 2);
	}
	
	/**
	 * Attacks and heals the same amount.
	 */
	public void suckBlood() {
		//TODO Change to do attack and heal the same amount of attack.
		EnemyEncounter.setTextBox("Vampire sucks blood and deals " + this.getAttack() + " damage. Vampire heals " + this.getAttack() + " health.");
		super.setHealth(getHealth() + super.getAttack());
		MediumEnemyGui.setIconText(this);
		EnemyEncounter.setPlayerTurn(true);
	}
	/**
	 * Roll d8
	 * 1-6 attack
	 * 7-8 suckBlood
	 */
	public  void enemyTurn() {
		int action = rand.nextInt(1, 9);
		if(action <= 6) {
			this.attack();
		}else {
			this.suckBlood();
		}
	}
}
