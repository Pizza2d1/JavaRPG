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
	private TheGame game;
	private JLabel textBox = new JLabel();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Enemy enemy;
	private boolean playerTurn = true;
	private static EnemyEncounter instance;
	
	private PlayerStatsPanel statsPanel;
	
	/**
	 * Create the frame.
	 * Type depicts the easy, normal, or hard enemy.
	 * className depicts if it is a small, medium, or large enemy.
	 */
	public EnemyEncounter(int type, String className, TheGame game) {
		this.game = game;
		instance = this;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setSize(600, 400);
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
		
		CombatPanel combatPanel = new CombatPanel(this, game);
		contentPane.add(combatPanel, BorderLayout.CENTER);
		
		statsPanel = new PlayerStatsPanel(game.getPlayer());
		contentPane.add(statsPanel, BorderLayout.EAST);
		
		textBox.setText("Battle Start!");
		textBox.setVerticalAlignment(SwingConstants.TOP);
		textBox.setOpaque(true);
		textBox.setMaximumSize(new Dimension(100, 70));
		textBox.setPreferredSize(new Dimension(100, 70));
		textBox.setBackground(new Color(255, 255, 255));
		add(textBox, BorderLayout.SOUTH);
		//Change Background and area. Make it show descriptive text of player actions and enemy actions.
		
	}
	/**
	 * Edits the player's health in the stats panel.
	 */
	public void setHealthLabel() {
		statsPanel.setHealthLabel(game.getPlayer());
	}
	
	/**
	 * Used to change the text in the text box at the bottom.
	 * @param text
	 */
	public void setTextBox(String text) {
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
	public boolean getPlayerTurn() {
		return playerTurn;
	}
	/**
	 * Used to set playerTurn to be true or false once the player or enemy takes their turn.
	 * @param b
	 */
	public void setPlayerTurn(boolean b) {
		playerTurn = b;
	}
	/**
	 * Implements a 1.5 second pause before the enemy takes their turn.
	 */
	public void nextTurn() {
		final EnemyEncounter encounter = this;
		final TheGame game = this.game;
		Timer timer = new Timer(1500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getEnemy().enemyTurn(encounter, game);
			}
		});
		timer.setRepeats(false);
		timer.start();
	}
	/**
	 * Heals the player
	 * @param heal
	 */
	public void healPlayer(int heal) {
		game.getPlayer().heal(heal);
		statsPanel.setHealthLabel(game.getPlayer());
		nextTurn();
	}
	/**
	 * Boosts player's defense
	 * @param boost
	 */
	public void boostDefense(int boost) {
		game.getPlayer().setDefenseBoost(boost);
		statsPanel.setDefenseLabel(game.getPlayer());
		nextTurn();
	}
	/**
	 * Boosts player's attack
	 * @param boost
	 */
	public void boostAttack(int boost) {
		game.getPlayer().setAttackBoost(boost);
		statsPanel.setAttackLabel(game.getPlayer());
		nextTurn();
	}
	/**
	 * Inflicts damage on the enemy, then updates the enemy's gui to display updated stats.
	 * @param damage
	 */
	public void damageEnemy(int damage) {
		enemy.setHealth(enemy.getHealth() - damage);
		if(enemy instanceof SmallEnemy) {
			SmallEnemyGui.setIconText(enemy);
		}else if(enemy instanceof MediumEnemy) {
			MediumEnemyGui.setIconText(enemy);
		}else if(enemy instanceof LargeEnemy) {
			LargeEnemyGui.setIconText(enemy);
		}
		if(enemy.getHealth() <= 0) {
			setTextBox("Enemy defeated!");
			this.enemyDefeated();
		}else {
			nextTurn();
		}
	}
	/**
	 * Used once the enemy's health reaches zero. Will pause for 1.5 seconds before closing the window and ending combat.
	 */
	public void enemyDefeated() {
		Timer timer = new Timer(1500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.getPlayer().setXP(EnemyEncounter.getEnemy().getXPYield());
				EnemyEncounter.getInstance().dispose();
				//game.encounter(1, "Small");
				//game.getPlayer().setXP(50);
				playerTurn = true;
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
	/**
	 * Closes the window and opens a game over window
	 */
	public void playerDefeated() {
		this.setTextBox("Player defeated!");
		Timer timer = new Timer(1500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EnemyEncounter.getInstance().dispose();
				game.dispose();
				GameOver gameOver = new GameOver();
				gameOver.setVisible(true);
			}
		});
		timer.setRepeats(false);
		timer.start();
	}
	/**
	 * Hands the stats panel to other methods to update.
	 * @return
	 */
	public PlayerStatsPanel getStatsPanel() {
		return statsPanel;
	}
}
