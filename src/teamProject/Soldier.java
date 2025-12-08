package teamProject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

import enemyEncounter.EnemyEncounter;
import guiCode.TheGame;

public class Soldier extends MediumEnemy{
	static Random rand = new Random();
	
	/**
	 * Soldier Monster Constructor
	 * Health: 50-70
	 * Defense: 7-10
	 * Attack: 9-11
	 * Movement: 2
	 * xpYield: 21-28
	 * Possibly resists fire and/or ice
	 */
	public Soldier() {
		super(rand.nextInt(50, 71), rand.nextInt(7, 11), rand.nextInt(9, 12), 2, rand.nextBoolean(), rand.nextBoolean());
	}
	/**
	 * roll d8
	 * 1-7 attack
	 * 8 nothing
	 * 
	 * 87.5% hit rate
	 */
	public  void enemyTurn(EnemyEncounter encounter, TheGame game) {
		int action = rand.nextInt(1, 9);
		if(action <= 7) {
			this.attack(encounter, game);
		}else {
			encounter.setTextBox("Soldier's attack misses.");
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
