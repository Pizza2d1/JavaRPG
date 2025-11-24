package guiCode;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import enemyEncounter.EnemyEncounter;
/**
 * This class is mainly used as a test class to ensure my other files work.
 * Contains two initiating methods for either spawning an enemy or beginning combat.
 */
public class TheGame extends JFrame {
	private static int smallCount = 1;
	private static int mediumCount = 1;
	private static int largeCount = 1;
	private static final long serialVersionUID = 1L;
	private static JPanel contentPane = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TheGame frame = new TheGame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		spawnEnemy(1);
		spawnEnemy(2);
		spawnEnemy(3);
//		spawnEnemy(1);
//		spawnEnemy(1);
//		spawnEnemy(1);
//		spawnEnemy(1);
//		spawnEnemy(1);
//		spawnEnemy(1);
//		spawnEnemy(1);
//		spawnEnemy(1);
		
		encounter(3, "Small");
	}

	/**
	 * Create the frame.
	 */
	public TheGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
	}
	/**
	 * Spawns an enemy
	 * @param type corresponds to spawning a small, medium, or large enemy
	 * 1 - small
	 * 2 - medium
	 * 3 - large
	 */
	public static void spawnEnemy(int type) {
		if(type == 1) {
			SmallEnemyGui smallEnemy = new SmallEnemyGui(smallCount);
			contentPane.add(smallEnemy);
			smallCount+=3;
		}else if(type == 2) {
			MediumEnemyGui mediumEnemy = new MediumEnemyGui(mediumCount);
			contentPane.add(mediumEnemy);
			mediumCount+=3;
		}else if(type == 3) {
			LargeEnemyGui largeEnemy = new LargeEnemyGui(largeCount);
			contentPane.add(largeEnemy);
			largeCount+=3;
		}
	}
	
	/**
	 * When the player approaches the enemy, this class goes to EnemyEncounter with a number, saying what it is.
	 */
	public static void encounter(int enemy, String size) {
		EnemyEncounter encounter = new EnemyEncounter(enemy, size);
		encounter.setVisible(true);
	}

}

