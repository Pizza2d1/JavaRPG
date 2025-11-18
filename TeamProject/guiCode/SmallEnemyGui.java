package guiCode;

import java.util.Random;
import teamProject.*;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
/**
 * Contains the code to create gui for each of the smallEnemy class enemies.
 */
public class SmallEnemyGui extends JPanel {
	private Random rand = new Random();
	private int enemy = 1;
	private static JLabel enemyIcon = new JLabel();
	private static JLabel spawnedEnemyIcon = new JLabel();

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * Uses a count that slowly implements through the game to decide the difficulty of the enemy.
	 * Constructor used to create icons that would appear on the game map.
	 */
	public SmallEnemyGui(int count) {
		
		enemy = rand.nextInt(count);
		if(enemy <= 3) {
			spawnRat();
		}else if(enemy <= 7) {
			spawnSpider();
		}else {
			spawnWolf();
		}

	}
	/**
	 * Constructor used to create icons that would appear on the EnemyEncounter window during combat.
	 * @param The same one enemy class is passed between classes.
	 */
	public SmallEnemyGui(Enemy enemy) {
		if(enemy.getClass().getSimpleName().equals("Rat")) {
			ratEncounter(enemy);
		}else if(enemy.getClass().getSimpleName().equals("Spider")) {
			spiderEncounter(enemy);
		}else if(enemy.getClass().getSimpleName().equals("Wolf")) {
			wolfEncounter(enemy);
		}
	}
	
	
	/**
	 * The following classes create icons for EnemyEncounter and display stats.
	 * @param ogre
	 */
	public void wolfEncounter(Enemy wolf) {
		enemyIcon.setIcon(new ImageIcon(SmallEnemyGui.class.getResource("/img/wolfEncounter.png")));
		enemyIcon.setVisible(true);
		enemyIcon.setText(wolf.toString());
		add(enemyIcon);
	}
	
	public void ratEncounter(Enemy rat) {
		enemyIcon.setIcon(new ImageIcon(SmallEnemyGui.class.getResource("/img/ratEncounter.jpg")));
		enemyIcon.setVisible(true);
		enemyIcon.setText(rat.toString());
		add(enemyIcon);
	}
	
	public void spiderEncounter(Enemy spider) {
		enemyIcon.setIcon(new ImageIcon(SmallEnemyGui.class.getResource("/img/spiderEncounter.png")));
		enemyIcon.setVisible(true);
		enemyIcon.setText(spider.toString());
		add(enemyIcon);
	}
	
	/**
	 * The following classes create icons for the game map.
	 * TODO Currently these classes create Enemy classes, but right now they aren't used.
	 */
	public void spawnWolf() {
		spawnedEnemyIcon.setIcon(new ImageIcon(SmallEnemyGui.class.getResource("/img/wolf.png")));
		add(spawnedEnemyIcon);
		Wolf wolf = new Wolf();
		spawnedEnemyIcon.setVisible(true);
		spawnedEnemyIcon.setText(wolf.toString());
	}
	
	public void spawnRat() {
		spawnedEnemyIcon.setIcon(new ImageIcon(SmallEnemyGui.class.getResource("/img/rat.png")));
		add(spawnedEnemyIcon);
		Rat rat = new Rat();
		spawnedEnemyIcon.setVisible(true);
		spawnedEnemyIcon.setText(rat.toString());
	}
	
	public void spawnSpider() {
		spawnedEnemyIcon.setIcon(new ImageIcon(SmallEnemyGui.class.getResource("/img/spider.png")));
		add(spawnedEnemyIcon);
		spawnedEnemyIcon.setVisible(false);
		Spider spider = new Spider();
		spawnedEnemyIcon.setVisible(true);
		spawnedEnemyIcon.setText(spider.toString());
	}
	
	/**
	 * Used to update the icon text on EnemyEncounter whenever the enemy's stats are changed.
	 * @param enemy
	 */
	public static void setIconText(Enemy enemy) {
		enemyIcon.setText(enemy.toString());
	}

}
