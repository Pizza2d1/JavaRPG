package teamProject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

import enemyEncounter.EnemyEncounter;
import guiCode.SmallEnemyGui;
import guiCode.TheGame;

public class Spider extends SmallEnemy{
	static Random rand = new Random();
	
	/**
	 * Spider Monster Constructor
	 * Health: 15-30
	 * Defense: 1-5
	 * Attack: 3-7
	 * Move: 3
	 * xpYield: 5-15
	 * Possibly resists ice.
	 */
	public Spider() {
		super(rand.nextInt(15, 31), rand.nextInt(1, 6), rand.nextInt(3, 8), 3, false, rand.nextBoolean());
	}
	/**
	 * Increases defense 1-2
	 */
	public void silk(EnemyEncounter encounter) {
		int boost = rand.nextInt(1, 3);
		encounter.setTextBox("Spider spins silk. Defense increases by " + boost);
		super.setDefense(getDefense() + boost);
		SmallEnemyGui.setIconText(this);
		encounter.setPlayerTurn(true);
	}
	/**
	 * Roll a d6
	 * 1-3 attack
	 * 4-5 silk
	 * 6 nothing
	 * 
	 * 83.3% hit rate
	 */
	public  void enemyTurn(EnemyEncounter encounter, TheGame game) {
		
		int action = rand.nextInt(1, 7);
		if(action <= 3) {
			this.attack(encounter, game);
		}else if(action <= 5) {
			this.silk(encounter);
		}else {
			encounter.setTextBox("Spider's attack misses");
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
