package teamProject;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import enemyEncounter.Spell;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Window that displays when the player levels up. Displays new stats, and the ability to upgrade stats.
 */
public class LevelUpWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblSpellUpgrade;
	
	/**
	 * Create the frame.
	 */
	public LevelUpWindow(PlayerCharacter player) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setSize(550, 300);
				
		
		JLabel lblLevelUp = new JLabel("Level Up!");
		lblLevelUp.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblLevelUp.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblLevelUp.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblLevelUp, BorderLayout.NORTH);
		
		JPanel centerPanel = newCenterPanel(player);
		contentPane.add(centerPanel, BorderLayout.CENTER);
		
		JButton closeBtn = newCloseBtn();
		contentPane.add(closeBtn, BorderLayout.SOUTH);
		
		PlayerStatsPanel leftPanel = new PlayerStatsPanel(player);
		contentPane.add(leftPanel, BorderLayout.WEST);
	}
	/**
	 * Button used to close the window when the player is done. There is no need to upgrade a spell beforehand.
	 * @return
	 */
	private JButton newCloseBtn() {
		JButton closeBtn = new JButton("DONE");
		closeBtn.setMaximumSize(new Dimension(100, 50));
		closeBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				LevelUpWindow.this.dispose();
			}
		});
		return closeBtn;
	}
	/**
	 * Creates the central panel containing the spell upgrade buttons.
	 * @param player
	 * @return
	 */
	private JPanel newCenterPanel(PlayerCharacter player) {
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		lblSpellUpgrade = new JLabel("Select a spell to upgrade: (Skill Points: " + player.getSkillPoints() + ")");
		lblSpellUpgrade.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		lblSpellUpgrade.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblSpellUpgrade);
		JButton fireBtn = newFireButton(player);
		JButton iceBtn = newIceButton(player);
		JButton healBtn = newHealButton(player);
		JButton attackBoostBtn = newAttackBoostButton(player);
		JButton defenseBoostBtn = newDefenseBoostButton(player);
		panel.add(fireBtn);
		panel.add(iceBtn);
		panel.add(healBtn);
		panel.add(defenseBoostBtn);
		panel.add(attackBoostBtn);
		return panel;
	}
	/**
	 * The following methods create the buttons to upgrade spells using Skill Points.
	 * @param player
	 * @return
	 */
	private JButton newDefenseBoostButton(PlayerCharacter player) {
		String message = "";
		switch(player.getDefenseBoostSpell()) {
		case 1: message = "Defense Boost 1 -> Defense Boost 2"; break;
		case 2: message = "Defense Boost 2 -> Defense Boost 3";	break;
		case 3: message = "Defense Boost 3 -> Defense Boost 4";	break;
		case 4: message = "Defense Boost 4 -> Defense Boost 5";	break;
		case 5: message = "Defense Boost 5"; break;
		}
		JButton defenseBoostBtn = new JButton(message);
		defenseBoostBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(player.getDefenseBoostSpell() < 5 && player.getSkillPoints() > 0) {
					player.levelUpSpell(Spell.DEFENSE_BOOST);
					player.useSkillPoints();
					defenseBoostBtn.setText("Defense Boost " + player.getDefenseBoostSpell());
					updateUpgradeLabel(player);
				}
			}
		});
		defenseBoostBtn.setMaximumSize(new Dimension(290, 30));
		return defenseBoostBtn;
	}

	private JButton newAttackBoostButton(PlayerCharacter player) {
		String message = "";
		switch(player.getAttackBoostSpell()) {
		case 1: message = "Attack Boost 1 -> Attack Boost 2"; break;
		case 2: message = "Attack Boost 2 -> Attack Boost 3"; break;
		case 3: message = "Attack Boost 3 -> Attack Boost 4"; break;
		case 4: message = "Attack Boost 4 -> Attack Boost 5"; break;
		case 5: message = "Attack Boost 5"; break;
		}
		JButton attackBoostBtn = new JButton(message);
		attackBoostBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(player.getAttackBoostSpell() < 5 && player.getSkillPoints() > 0) {
					player.levelUpSpell(Spell.ATTACK_BOOST);
					player.useSkillPoints();
					updateUpgradeLabel(player);
					attackBoostBtn.setText("Attack Boost " + player.getAttackBoostSpell());
				}
			}
		});
		attackBoostBtn.setMaximumSize(new Dimension(290, 30));
		return attackBoostBtn;
	}

	private JButton newHealButton(PlayerCharacter player) {
		String message = "";
		switch(player.getHealSpell()) {
		case 1: message = "Heal 1 -> Heal 2"; break;
		case 2: message = "Heal 2 -> Heal 3"; break;
		case 3: message = "Heal 3 -> Heal 4"; break;
		case 4: message = "Heal 4 -> Heal 5"; break;
		case 5: message = "Heal 5"; break;
		}
		JButton healBtn = new JButton(message);
		healBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(player.getHealSpell() < 5 && player.getSkillPoints() > 0) {
					player.levelUpSpell(Spell.HEAL);
					player.useSkillPoints();
					updateUpgradeLabel(player);
					healBtn.setText("Heal " + player.getHealSpell());
				}
			}
		});
		healBtn.setMaximumSize(new Dimension(290, 30));
		return healBtn;
	}

	private JButton newIceButton(PlayerCharacter player) {
		String message = "";
		switch(player.getIceSpell()) {
		case 1: message = "Ice 1 -> Ice 2"; break;
		case 2: message = "Ice 2 -> Ice 3"; break;
		case 3: message = "Ice 3 -> Ice 4"; break;
		case 4: message = "Ice 4 -> Ice 5"; break;
		case 5: message = "Ice 5"; break;
		}
		JButton iceBtn = new JButton(message);
		iceBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(player.getIceSpell() < 5 && player.getSkillPoints() > 0) {
					player.levelUpSpell(Spell.ICE);
					player.useSkillPoints();
					updateUpgradeLabel(player);
					iceBtn.setText("Ice " + player.getIceSpell());
				}
			}
		});
		iceBtn.setMaximumSize(new Dimension(290, 30));
		return iceBtn;
	}

	private JButton newFireButton(PlayerCharacter player) {
		String message = "";
		switch(player.getFireSpell()) {
		case 1: message = "Fire 1 -> Fire 2"; break;
		case 2: message = "Fire 2 -> Fire 3"; break;
		case 3: message = "Fire 3 -> Fire 4"; break;
		case 4: message = "Fire 4 -> Fire 5"; break;
		case 5: message = "Fire 5"; break;
		}
		JButton fireBtn = new JButton(message);
		fireBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(player.getFireSpell() < 5 && player.getSkillPoints() > 0) {
					player.levelUpSpell(Spell.FIRE);
					player.useSkillPoints();
					updateUpgradeLabel(player);
					fireBtn.setText("Fire " + player.getFireSpell());
				}
			}
		});
		fireBtn.setMaximumSize(new Dimension(290, 30));
		return fireBtn;
	}
	
	/**
	 * Updates the upgrade label to display current amount of skill points.
	 * @param player
	 */
	private void updateUpgradeLabel(PlayerCharacter player) {
		lblSpellUpgrade.setText("Select a spell to upgrade: (Skill Points: " + player.getSkillPoints() + ")");
	}
}
