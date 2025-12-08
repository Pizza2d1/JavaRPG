package teamProject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

import enemyEncounter.EnemyEncounter;
import guiCode.SmallEnemyGui;
import guiCode.TheGame;

public class Wolf extends SmallEnemy{
	static Random rand = new Random();
	/**
	 * Wolf Monster Constructor
	 * Health: 25-40
	 * Defense: 3-7
	 * Attack: 5-10
	 * Move: 3
	 * xpYield: 10-21
	 * Possibly resists fire.
	 */
	public Wolf() {
		super(rand.nextInt(25, 41), rand.nextInt(3, 8), rand.nextInt(5, 11), 3, rand.nextBoolean(), false);
	}
	
	/**
	 * Increases attack 1-3
	 */
	public void howl(EnemyEncounter encounter) {
		int boost = rand.nextInt(1, 4);
		encounter.setTextBox("Wolf howls. Attack increases by " + boost);
		super.setAttack(getAttack() + boost);
		SmallEnemyGui.setIconText(this);
	}
	/**
	 * Roll d6
	 * 1-4 attack
	 * 5-6 howl
	 */
	public  void enemyTurn(EnemyEncounter encounter, TheGame game) {
		int action = rand.nextInt(1, 7);
		if(action <= 4) {
			this.attack(encounter, game);
		}else {
			this.howl(encounter);
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
