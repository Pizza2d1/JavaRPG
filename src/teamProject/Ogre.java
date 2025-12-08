package teamProject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

import enemyEncounter.EnemyEncounter;
import guiCode.TheGame;

public class Ogre extends LargeEnemy{
	static Random rand = new Random();
	
	/**
	 * Ogre Monster Constructor
	 * Health: 60-80
	 * Defense: 5-10
	 * Attack: 8-12
	 * Movement: 2
	 * xpYield: 19-30
	 * Resists fire and ice
	 */
	public Ogre() {
		super(rand.nextInt(60, 81), rand.nextInt(5, 11), rand.nextInt(8, 13), 2, true, true);
	}
	
	/**
	 * Roll d10
	 * 1-8 attack
	 * 9-10 nothing
	 * 
	 * 80% hit rate.
	 */
	public void enemyTurn(EnemyEncounter encounter, TheGame game) {
		
		int action = rand.nextInt(1, 11);
		if(action <= 8) {
			this.attack(encounter, game);
		}else {
			encounter.setTextBox("Ogre's attack misses");
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
