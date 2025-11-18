package guiCode;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Random;
import teamProject.*;
/**
 * Contains the code to create gui for each of the mediumEnemy class enemies.
 */
public class MediumEnemyGui extends JPanel {
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
	public MediumEnemyGui(int count) {
		enemy = rand.nextInt(count);
		if(enemy <= 3) {
			spawnSkeleton();
		}else if(enemy <= 7) {
			spawnVampire();
		}else {
			spawnSoldier();
		}
	}
	/**
	 * Constructor used to create icons that would appear on the EnemyEncounter window during combat.
	 * @param The same one enemy class is passed between classes.
	 */
	public MediumEnemyGui(Enemy enemy) {
		if(enemy.getClass().getSimpleName().equals("Skeleton")) {
			skeletonEncounter(enemy);
		}else if(enemy.getClass().getSimpleName().equals("Vampire")) {
			vampireEncounter(enemy);
		}else if(enemy.getClass().getSimpleName().equals("Soldier")) {
			soldierEncounter(enemy);
		}
	}
	/**
	 * The following classes create icons for EnemyEncounter and display stats.
	 * @param ogre
	 */
	public void skeletonEncounter(Enemy skeleton) {
		//TODO setIcon
		enemyIcon.setVisible(true);
		enemyIcon.setText(skeleton.toString());
		add(enemyIcon);
	}
	
	public void vampireEncounter(Enemy vampire) {
		//TODO setIcon
		enemyIcon.setVisible(true);
		enemyIcon.setText(vampire.toString());
		add(enemyIcon);
	}
	
	public void soldierEncounter(Enemy soldier) {
		//TODO setIcon
		enemyIcon.setVisible(true);
		enemyIcon.setText(soldier.toString());
		add(enemyIcon);
	}
	
	/**
	 * The following classes create icons for the game map.
	 * TODO Currently these classes create Enemy classes, but right now they aren't used.
	 */
	public void spawnSkeleton() {
		spawnedEnemyIcon.setIcon(new ImageIcon(SmallEnemyGui.class.getResource("/img/skeleton.png")));
		add(spawnedEnemyIcon);
		Skeleton skeleton = new Skeleton();
		spawnedEnemyIcon.setVisible(true);
		spawnedEnemyIcon.setText(skeleton.toString());
	}
	public void spawnVampire() {
		spawnedEnemyIcon.setIcon(new ImageIcon(SmallEnemyGui.class.getResource("/img/vampire.png")));
		add(spawnedEnemyIcon);
		Vampire vampire = new Vampire();
		spawnedEnemyIcon.setVisible(true);
		spawnedEnemyIcon.setText(vampire.toString());
	}
	public void spawnSoldier() {
		spawnedEnemyIcon.setIcon(new ImageIcon(SmallEnemyGui.class.getResource("/img/soldier.png")));
		add(spawnedEnemyIcon);
		Soldier soldier = new Soldier();
		spawnedEnemyIcon.setVisible(true);
		spawnedEnemyIcon.setText(soldier.toString());
	}
	
	/**
	 * Used to update the icon text on EnemyEncounter whenever the enemy's stats are changed.
	 * @param enemy
	 */
	public static void setIconText(Enemy enemy) {
		enemyIcon.setText(enemy.toString());
	}
}
