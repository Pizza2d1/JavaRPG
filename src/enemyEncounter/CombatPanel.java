package enemyEncounter;

import javax.swing.JPanel;

import guiCode.LargeEnemyGui;
import guiCode.MediumEnemyGui;
import guiCode.SmallEnemyGui;

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
	JButton special = new JButton("Special");

	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	public CombatPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel actionPanel = new JPanel();
		add(actionPanel, BorderLayout.CENTER);
		
		JButton attack = attackBtn();
		actionPanel.add(attack);
		
		special = specialBtn();
		actionPanel.add(special);
	}
		
/**
 * Creates the special attack button that opens the Spell Window, then activates a 3 turn cooldown.
 */
	private JButton specialBtn() {
		special.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(EnemyEncounter.getPlayerTurn() && cooldown <= 0) {
					SpellWindow spellWindow = new SpellWindow(1, 1, 1, 1, 1);
					//TODO getters for spell levels
					spellWindow.setVisible(true);
					EnemyEncounter.setPlayerTurn(false);
					cooldown = 3;
					special.setBackground(new Color(128, 128, 128));
					//TODO Implement pauses
					
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
	private JButton attackBtn() {
		JButton attack = new JButton("Attack");
		attack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(EnemyEncounter.getPlayerTurn()) {
					EnemyEncounter.setTextBox("You attack and deal " + 7 + " damage.");
					EnemyEncounter.setPlayerTurn(false);
					//TODO implement player's attack stat.
					EnemyEncounter.getEnemy().setHealth(EnemyEncounter.getEnemy().getHealth() - 7);
					//TODO Change from small, medium, or large
					SmallEnemyGui.setIconText(EnemyEncounter.getEnemy());
					MediumEnemyGui.setIconText(EnemyEncounter.getEnemy());
					LargeEnemyGui.setIconText(EnemyEncounter.getEnemy());
					if(EnemyEncounter.getEnemy().getHealth() <= 0) {
						EnemyEncounter.setTextBox("Enemy defeated!");
						EnemyEncounter.enemyDefeated();
					}else {
						EnemyEncounter.nextTurn();
					}
					cooldown--;
					if(cooldown <= 0) {
						special.setBackground(new Color(0, 0, 255));
					}
				}
			}
		});
		attack.setFont(new Font("Tahoma", Font.PLAIN, 22));
		attack.setBackground(new Color(255, 0, 0));
		return attack;
	}
}
