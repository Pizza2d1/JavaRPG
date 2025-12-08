package teamProject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

import enemyEncounter.EnemyEncounter;
import guiCode.TheGame;

public class Skeleton extends MediumEnemy{
	static Random rand = new Random();
	
	/**
	 * Skeleton Monster Constructor
	 * Health: 20-30
	 * Defense: 4-8
	 * Attack: 4-8
	 * Movement: 2
	 * xpYield: 10-19
	 * Resists ice.
	 */
	public Skeleton() {
		super(rand.nextInt(20, 31), rand.nextInt(4, 9), rand.nextInt(4, 9), 2, false, true);
	}
	/**
	 * Roll d8
	 * 1-6 attack
	 * 7-8 nothing
	 * 
	 * 75% hit rate
	 */
	public  void enemyTurn(EnemyEncounter encounter, TheGame game) {
		
		int action = rand.nextInt(1, 9);
		if(action <= 6) {
			this.attack(encounter, game);
		}else {
			encounter.setTextBox("Skeleton's attack misses.");
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
