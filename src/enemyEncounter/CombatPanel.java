package enemyEncounter;

import javax.swing.JPanel;

import guiCode.LargeEnemyGui;
import guiCode.MediumEnemyGui;
import guiCode.SmallEnemyGui;
import guiCode.TheGame;
import teamProject.SmallEnemy;
import teamProject.MediumEnemy;
import teamProject.LargeEnemy;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

/**
 * The combat panel containing the attack and special buttons.
 */
public class CombatPanel extends JPanel {
	private int cooldown = 0;
	private int boostDuration = 0;
	JButton special = new JButton("Special");

	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	public CombatPanel(EnemyEncounter encounter, TheGame game) {
		setLayout(new BorderLayout(0, 0));
		
		newActionPanel(encounter, game);
	}

	/**
	 * Creates the panel containing both attack and special buttons.
	 * @param encounter
	 * @param game
	 */
	private void newActionPanel(EnemyEncounter encounter, TheGame game) {
		JPanel actionPanel = new JPanel();
		add(actionPanel, BorderLayout.NORTH);
		
		JButton attack = attackBtn(encounter, game);
		actionPanel.add(attack);
		
		special = specialBtn(encounter, game);
		actionPanel.add(special);
	}
		
/**
 * Creates the special attack button that opens the Spell Window, then activates a 5 turn cooldown.
 */
	private JButton specialBtn(EnemyEncounter encounter, TheGame game) {
		special.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(encounter.getPlayerTurn() && cooldown <= 0) {
					int fire = game.getPlayer().getFireSpell();
					int ice = game.getPlayer().getIceSpell();
					int heal = game.getPlayer().getHealSpell();
					int defense = game.getPlayer().getDefenseBoostSpell();
					int attack = game.getPlayer().getAttackBoostSpell();
					SpellWindow spellWindow = new SpellWindow(encounter, game.getPlayer(), fire, ice, heal, defense, attack);
					spellWindow.setVisible(true);
					encounter.setPlayerTurn(false);
					cooldown = 5;
					boostDuration = 3;
					special.setBackground(new Color(128, 128, 128));					
				}
			}
		});
		special.setFont(new Font("Tahoma", Font.PLAIN, 22));
		special.setBackground(new Color(0, 0, 255));
		return special;
	}
/**
 * Creates the normal attack button that damages the enemy. It slowly brings the cooldown for special attacks down.
 */
	private JButton attackBtn(EnemyEncounter encounter, TheGame game) {
		JButton attack = new JButton("Attack");
		attack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(encounter.getPlayerTurn()) {
					int damage = game.getPlayer().getAttack() + game.getPlayer().getAttackBoost() - EnemyEncounter.getEnemy().getDefense();
					if(damage <= 0) {
						damage = 1;
					}
					encounter.setTextBox("You attack and deal " + damage + " damage.");
					encounter.setPlayerTurn(false);
					
					EnemyEncounter.getEnemy().setHealth(EnemyEncounter.getEnemy().getHealth() - damage);
					if(EnemyEncounter.getEnemy() instanceof SmallEnemy) {
						SmallEnemyGui.setIconText(EnemyEncounter.getEnemy());
					}else if(EnemyEncounter.getEnemy() instanceof MediumEnemy) {
						MediumEnemyGui.setIconText(EnemyEncounter.getEnemy());
					}else if(EnemyEncounter.getEnemy() instanceof LargeEnemy){
						LargeEnemyGui.setIconText(EnemyEncounter.getEnemy());
					}
					if(EnemyEncounter.getEnemy().getHealth() <= 0) {
						encounter.setTextBox("Enemy defeated!");
						encounter.enemyDefeated();
					}else {
						encounter.nextTurn();
					}
					cooldown--;
					boostDuration--;
					if(cooldown <= 0) {
						special.setBackground(new Color(0, 0, 255));
					}
					if(boostDuration <= 0) {
						game.getPlayer().setAttackBoost(0);
						game.getPlayer().setDefenseBoost(0);
						encounter.getStatsPanel().setAttackLabel(game.getPlayer());
						encounter.getStatsPanel().setDefenseLabel(game.getPlayer());
					}
				}
			}
		});
		attack.setFont(new Font("Tahoma", Font.PLAIN, 22));
		attack.setBackground(new Color(255, 0, 0));
		return attack;
	}
}
