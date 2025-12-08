package teamProject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

import enemyEncounter.EnemyEncounter;
import guiCode.LargeEnemyGui;
import guiCode.TheGame;

public class Dragon extends LargeEnemy{
	static Random rand = new Random();
	private EnemyEncounter encounter;
	
	/**
	 * Dragon Monster Constructor
	 * Health: 200-300
	 * Defense: 10-18
	 * Attack: 15-20
	 * Movement: 4
	 * xpYield: 45-68
	 * Resists fire and ice
	 */
	public Dragon() {
		super(rand.nextInt(200, 301), rand.nextInt(10, 19), rand.nextInt(15, 21), 4, true, true);
	}
	/**
	 * Special attack. Still undecided on effects.
	 */
	public void fireBreath(EnemyEncounter encounter, PlayerCharacter player) {
		encounter.setTextBox("Dragon breathes fire and deals " + super.getAttack() + " damage");
		int damage = this.getAttack();
		player.setHealth(damage);
		encounter.setHealthLabel();
		if(player.getHealth() <= 0) {
			encounter.playerDefeated();
		}
		LargeEnemyGui.setIconText(this);
	}
	/**
	 * Roll d10
	 * 1-8 attack
	 * 9-10 fireBreath
	 */
	public  void enemyTurn(EnemyEncounter encounter, TheGame game) {
		this.encounter = encounter;
		int action = rand.nextInt(1, 11);
		if(action <= 8) {
			this.attack(encounter, game);
		}else {
			this.fireBreath(encounter, game.getPlayer());
		}
		final EnemyEncounter encounter1 = this.encounter;
		Timer timer = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				encounter1.setTextBox("Your turn.");
				encounter1.setPlayerTurn(true);
			}
		});
		timer.setRepeats(false);
		timer.start();
	}
}
