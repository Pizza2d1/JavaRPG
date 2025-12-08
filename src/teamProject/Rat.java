package teamProject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

import enemyEncounter.EnemyEncounter;
import guiCode.TheGame;

public class Rat extends SmallEnemy{
	static Random rand = new Random();
	/**
	 * Rat Monster Constructor
	 * Health: 10-20
	 * Defense: 0-3
	 * Attack: 1-3
	 * Movement: 2
	 * xpYield: 2-8
	 * Zero resistances
	 */
	public Rat() {
		super(rand.nextInt(10, 21), rand.nextInt(0, 4), rand.nextInt(1, 4), 2, false, false);
	}
	/**
	 *Roll a d6.
	 *1-4 attacks
	 *5-6 nothing
	 *
	 *66% hit rate
	 */
	public  void enemyTurn(EnemyEncounter encounter, TheGame game) {
		
		int action = rand.nextInt(1, 7);
		if(action <= 4) {
			this.attack(encounter, game);
		}else {
			encounter.setTextBox("Rat's attack misses.");
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
