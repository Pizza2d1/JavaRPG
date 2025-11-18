package enemyEncounter;

import guiCode.*;
import teamProject.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

/**
 * The window that depicts the combat sequence against an enemy.
 */
public class EnemyEncounter extends JFrame {
	private static JLabel textBox = new JLabel();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Enemy enemy;
	private static boolean playerTurn = true;
	private static EnemyEncounter instance;
	
	/**
	 * Create the frame.
	 * Type depicts the easy, normal, or hard enemy.
	 * className depicts if it is a small, medium, or large enemy.
	 */
	public EnemyEncounter(int type, String className) {
		instance = this;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		if(className.equals("Small")) {
			if(type == 1) {
				createRat();
			}else if(type == 2) {
				createSpider();
			}else {
				createWolf();
			}
		}else if(className.equals("Medium")) {
			if(type == 1) {
				createSkeleton();
			}else if(type == 2) {
				createSoldier();
			}else {
				createVampire();
			}
		}else if(className.equals("Large")) {
			if(type == 1) {
				createOgre();
			}else if(type == 2) {
				createWerewolf();
			}else {
				createDragon();
			}
		}
		
		CombatPanel combatPanel = new CombatPanel();
		contentPane.add(combatPanel, BorderLayout.CENTER);
		
		textBox.setText("Battle Start!");
		textBox.setVerticalAlignment(SwingConstants.TOP);
		textBox.setOpaque(true);
		textBox.setMaximumSize(new Dimension(100, 70));
		textBox.setPreferredSize(new Dimension(100, 70));
		textBox.setBackground(new Color(255, 255, 255));
		add(textBox, BorderLayout.SOUTH);
		//Change Background and area. Make it show descriptive text of player actions and enemy actions.
		
		//TODO Add panel including player's stats. Or include in combatPanel.
	}
	/**
	 * Used to change the text in the text box at the bottom.
	 * @param text
	 */
	public static void setTextBox(String text) {
		textBox.setText(text);
	}
	
	/**
	 * The following methods create different types of enemies as depicted in the constructor.
	 */
	public void createRat() {
		enemy = new Rat();
		SmallEnemyGui rat = new SmallEnemyGui(enemy);
		contentPane.add(rat, BorderLayout.NORTH);
		rat.setVisible(true);
	}
	public void createSpider() {
		enemy = new Spider();
		SmallEnemyGui spider = new SmallEnemyGui(enemy);
		contentPane.add(spider, BorderLayout.NORTH);
	}
	public void createWolf() {
		enemy = new Wolf();
		SmallEnemyGui wolf = new SmallEnemyGui(enemy);
		contentPane.add(wolf, BorderLayout.NORTH);
	}
	public void createSkeleton() {
		enemy = new Skeleton();
		MediumEnemyGui skeleton = new MediumEnemyGui(enemy);
		contentPane.add(skeleton, BorderLayout.NORTH);
	}
	public void createVampire() {
		enemy = new Vampire();
		MediumEnemyGui vampire = new MediumEnemyGui(enemy);
		contentPane.add(vampire, BorderLayout.NORTH);
	}
	public void createSoldier() {
		enemy = new Soldier();
		MediumEnemyGui soldier = new MediumEnemyGui(enemy);
		contentPane.add(soldier, BorderLayout.NORTH);
	}
	public void createOgre() {
		enemy = new Ogre();
		LargeEnemyGui ogre = new LargeEnemyGui(enemy);
		contentPane.add(ogre, BorderLayout.NORTH);
	}
	public void createWerewolf() {
		enemy = new Werewolf();
		LargeEnemyGui werewolf = new LargeEnemyGui(enemy);
		contentPane.add(werewolf, BorderLayout.NORTH);
	}
	public void createDragon() {
		enemy = new Dragon();
		LargeEnemyGui dragon = new LargeEnemyGui(enemy);
		contentPane.add(dragon, BorderLayout.NORTH);
	}
	
/**
 * Used to get the enemy and pass it through different classes. There is only one enemy.
 * @return
 */
	public static Enemy getEnemy() {
		return enemy;
	}
	/**
	 * Used to get whether it is the player's turn or not. If playerTurn is false, the buttons will not work.
	 * @return
	 */
	public static boolean getPlayerTurn() {
		return playerTurn;
	}
	/**
	 * Used to set playerTurn to be true or false once the player or enemy takes their turn.
	 * @param b
	 */
	public static void setPlayerTurn(boolean b) {
		playerTurn = b;
	}
	/**
	 * Impliments a 1.5 second pause before the enemy takes their turn.
	 */
	public static void nextTurn() {
		Timer timer = new Timer(1500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getEnemy().enemyTurn();
			}
		});
		timer.setRepeats(false);
		timer.start();
	}
	/**
	 * Used once the enemy's health reaches zero. Will pause for 1.5 seconds before closing the window and ending combat.
	 */
	public static void enemyDefeated() {
		Timer timer = new Timer(1500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO Give the player the xpYield and potentially level up.
				EnemyEncounter.getInstance().dispose();
			}
		});
		timer.setRepeats(false);
		timer.start();
	}
	
	/**
	 * Added simply for the enemyDefeated to help close the window.
	 * @return
	 */
	public static EnemyEncounter getInstance() {
		return instance;
	}
}
