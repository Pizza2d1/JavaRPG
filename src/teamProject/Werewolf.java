package teamProject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

import enemyEncounter.EnemyEncounter;
import guiCode.LargeEnemyGui;
import guiCode.TheGame;

public class Werewolf extends LargeEnemy{
	static Random rand = new Random();

	/**
	 * Werewolf Monster Constructor
	 * Health: 50-100
	 * Defense: 7-10
	 * Attack: 10-12
	 * Movement: 4
	 * xpYield: 22-32
	 * Resists fire. Possibly resists ice.
	 */
	public Werewolf() {
		super(rand.nextInt(50, 101), rand.nextInt(7, 11), rand.nextInt(10, 13), 4, true, rand.nextBoolean());
	}
	
	/**
	 * Increases attack 3-5
	 */
	public void roar(EnemyEncounter encounter) {
		int boost = rand.nextInt(3, 6);
		encounter.setTextBox("Werewolf roars and increases attack by " + boost);
		super.setAttack(getAttack() + boost);
		LargeEnemyGui.setIconText(this);
	}
	/**
	 * Roll d10
	 * 1-7 attack
	 * 8-10 roar
	 */
	public  void enemyTurn(EnemyEncounter encounter, TheGame game) {
		int action = rand.nextInt(1, 11);
		if(action <= 7) {
			this.attack(encounter, game);
		}else {
			this.roar(encounter);
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
