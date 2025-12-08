package teamProject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

import enemyEncounter.EnemyEncounter;
import guiCode.MediumEnemyGui;
import guiCode.TheGame;

public class Vampire extends MediumEnemy{
	static Random rand = new Random();

	/**
	 * Vampire Monster Constructor
	 * Health: 40-60
	 * Defense: 5-9
	 * Attack: 7-12
	 * Movement: 2
	 * xpYield: 16-27
	 * Resists ice. Possibly resists fire.
	 */
	public Vampire() {
		super(rand.nextInt(40, 61), rand.nextInt(5, 10), rand.nextInt(7, 13), 2, rand.nextBoolean(), true);
	}
	
	/**
	 * Attacks and heals the same amount.
	 */
	public void suckBlood(EnemyEncounter encounter, TheGame game) {
		//TODO Change to do attack and heal the same amount of attack.
		int damage = this.getAttack() - (game.getPlayer().getDefense() + game.getPlayer().getDefenseBoost());
		encounter.setTextBox("Vampire sucks blood and deals " + damage + " damage. Vampire heals " + damage + " health.");
		super.setHealth(getHealth() + super.getAttack());
		MediumEnemyGui.setIconText(this);
		game.getPlayer().setHealth(damage);
		encounter.setHealthLabel();
		if(game.getPlayer().getHealth() <= 0) {
			encounter.playerDefeated();
		}
	}
	/**
	 * Roll d8
	 * 1-6 attack
	 * 7-8 suckBlood
	 */
	public  void enemyTurn(EnemyEncounter encounter, TheGame game) {
		int action = rand.nextInt(1, 9);
		if(action <= 6) {
			this.attack(encounter, game);
		}else {
			this.suckBlood(encounter, game);
		}
		Timer timer = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				encounter.setTextBox("Your turn.");
				encounter.setPlayerTurn(true);
			}
		});
		timer.setRepeats(false);
		timer.start();
	}
}
