package guiCode;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Random;
import teamProject.*;
/**
 * Contains the code to create gui for each of the largeEnemy class enemies.
 */
public class LargeEnemyGui extends JPanel {
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
	public LargeEnemyGui(int count) {
		enemy = rand.nextInt(count);
		if(enemy <= 3) {
			spawnOgre();
		}else if(enemy <= 7) {
			spawnWerewolf();
		}else {
			spawnDragon();
		}
	}
	/**
	 * Constructor used to create icons that would appear on the EnemyEncounter window during combat.
	 * @param The same one enemy class is passed between classes.
	 */
	public LargeEnemyGui(Enemy enemy) {
		if(enemy instanceof Ogre) {
			ogreEncounter(enemy);
		}else if(enemy instanceof Werewolf) {
			werewolfEncounter(enemy);
		}else if(enemy instanceof Dragon) {
			dragonEncounter(enemy);
		}
	}
	/**
	 * The following classes create icons for EnemyEncounter and display stats.
	 * @param ogre
	 */
	public void ogreEncounter(Enemy ogre) {
		enemyIcon.setIcon(new ImageIcon(SmallEnemyGui.class.getResource("/img/ogreEncounter.png")));
		enemyIcon.setVisible(true);
		enemyIcon.setText(ogre.toString());
		add(enemyIcon);
	}
	
	public void werewolfEncounter(Enemy werewolf) {
		enemyIcon.setIcon(new ImageIcon(SmallEnemyGui.class.getResource("/img/werewolfEncounter.png")));
		enemyIcon.setVisible(true);
		enemyIcon.setText(werewolf.toString());
		add(enemyIcon);
	}
	
	public void dragonEncounter(Enemy dragon) {
		enemyIcon.setIcon(new ImageIcon(SmallEnemyGui.class.getResource("/img/dragonEncounter.png")));
		enemyIcon.setVisible(true);
		enemyIcon.setText(dragon.toString());
		add(enemyIcon);
	}
	
	/**
	 * The following classes create icons for the game map.
	 * TODO Currently these classes create Enemy classes, but right now they aren't used.
	 */
	public void spawnOgre() {
		spawnedEnemyIcon.setIcon(new ImageIcon(SmallEnemyGui.class.getResource("/img/ogre.png")));
		add(spawnedEnemyIcon);
		Ogre ogre = new Ogre();
		spawnedEnemyIcon.setVisible(true);
		spawnedEnemyIcon.setText(ogre.toString());
	}
	public void spawnWerewolf() {
		spawnedEnemyIcon.setIcon(new ImageIcon(SmallEnemyGui.class.getResource("/img/werewolf.png")));
		add(spawnedEnemyIcon);
		Werewolf werewolf = new Werewolf();
		spawnedEnemyIcon.setVisible(true);
		spawnedEnemyIcon.setText(werewolf.toString());
	}
	public void spawnDragon() {
		spawnedEnemyIcon.setIcon(new ImageIcon(SmallEnemyGui.class.getResource("/img/dragon.png")));
		add(spawnedEnemyIcon);
		Dragon dragon = new Dragon();
		spawnedEnemyIcon.setVisible(true);
		spawnedEnemyIcon.setText(dragon.toString());
	}
	
	/**
	 * Used to update the icon text on EnemyEncounter whenever the enemy's stats are changed.
	 * @param enemy
	 */
	public static void setIconText(Enemy enemy) {
		enemyIcon.setText(enemy.toString());
	}
}
