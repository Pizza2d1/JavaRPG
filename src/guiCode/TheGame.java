package guiCode;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import teamProject.PlayerCharacter;

import enemyEncounter.EnemyEncounter;

public class TheGame extends JFrame {
	private static int smallCount = 1;
	private static int mediumCount = 1;
	private static int largeCount = 1;
	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	private EnemyEncounter encounter;
	
	private static PlayerCharacter player = new PlayerCharacter();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TheGame frame = new TheGame();
					frame.setVisible(true);
					frame.encounter(1, "Small");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		//spawnEnemy(1);
		//spawnEnemy(2);
		//spawnEnemy(3);
//		spawnEnemy(1);
//		spawnEnemy(1);
//		spawnEnemy(1);
//		spawnEnemy(1);
//		spawnEnemy(1);
//		spawnEnemy(1);
//		spawnEnemy(1);
//		spawnEnemy(1);

		//encounter(1, "Small");
		
		//player.setXP(10);
	}

	/**
	 * Create the frame.
	 */
	public TheGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
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
	public void spawnEnemy(int type) {
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
	public void encounter(int enemy, String size) {
		encounter = new EnemyEncounter(enemy, size, this);
		encounter.setVisible(true);
	}
	/**
	 * Returns the player to avoid using static variables and methods, which causes the game to freeze.
	 * @return
	 */
	public PlayerCharacter getPlayer() {
		return player;
	}

}
