package enemyEncounter;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * A window that contains five buttons for five different spells.
 */
public class SpellWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 * @param five digits that represent spell levels.
	 */
	public SpellWindow(int fireLvl, int iceLvl, int healLvl, int attBoostLvl, int defBoostLvl) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(300, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JButton fire = fireBtn(fireLvl);
		contentPane.add(fire);
		
		JButton ice = iceBtn(iceLvl);
		contentPane.add(ice);
		
		JButton heal = healBtn(healLvl);
		contentPane.add(heal);
		
		JButton attackBoost = attackBoostBtn(attBoostLvl);
		contentPane.add(attackBoost);
		
		JButton defenseBoost = defenseBoostBtn(defBoostLvl);
		contentPane.add(defenseBoost);

	}
	/**
	 * The following methods create the five different buttons according the their level.
	 * After any of the buttons are pressed, the window is closed. The player can only select one spell.
	 * @param level
	 */
	private JButton defenseBoostBtn(int level) {
		String name;
		if(level == 1) {
			name = "Defense Boost I";
		}else if(level == 2) {
			name = "Defense Boost II";
		}else if(level == 3) {
			name = "Defense Boost III";
		}else if(level == 4) {
			name = "Defense Boost IV";
		}else {
			name = "Defense Boost V";
		}
		JButton defenseBoost = new JButton(name);
		defenseBoost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Spells.defenseBoostSpell(level);
				SpellWindow.this.dispose();
			}
		});
		defenseBoost.setMaximumSize(new Dimension(290, 30));
		return defenseBoost;
	}

	private JButton attackBoostBtn(int level) {
		String name;
		if(level == 1) {
			name = "Attack Boost I";
		}else if(level == 2) {
			name = "Attack Boost II";
		}else if(level == 3) {
			name = "Attack Boost III";
		}else if(level == 4) {
			name = "Attack Boost IV";
		}else {
			name = "Attack Boost V";
		}
		JButton attackBoost = new JButton(name);
		attackBoost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Spells.attackBoostSpell(level);
				SpellWindow.this.dispose();
			}
		});
		attackBoost.setMaximumSize(new Dimension(290, 30));
		return attackBoost;
	}

	private JButton healBtn(int level) {
		String name;
		if(level == 1) {
			name = "Heal I";
		}else if(level == 2) {
			name = "Heal II";
		}else if(level == 3) {
			name = "Heal III";
		}else if(level == 4) {
			name = "Heal IV";
		}else {
			name = "Heal V";
		}
		JButton heal = new JButton(name);
		heal.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Spells.healSpell(level);
				SpellWindow.this.dispose();
			}
		});
		heal.setMaximumSize(new Dimension(290, 30));
		return heal;
	}

	private JButton iceBtn(int level) {
		String name;
		if(level == 1) {
			name = "Ice I";
		}else if(level == 2) {
			name = "Ice II";
		}else if(level == 3) {
			name = "Ice III";
		}else if(level == 4) {
			name = "Ice IV";
		}else {
			name = "Ice V";
		}
		JButton ice = new JButton(name);
		ice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Spells.iceSpell(level);
				SpellWindow.this.dispose();
			}
		});
		ice.setMaximumSize(new Dimension(290, 30));
		return ice;
	}

	private JButton fireBtn(int level) {
		String name;
		if(level == 1) {
			name = "Fire I";
		}else if(level == 2) {
			name = "Fire II";
		}else if(level == 3) {
			name = "Fire III";
		}else if(level == 4) {
			name = "Fire IV";
		}else {
			name = "Fire V";
		}
		JButton fire = new JButton(name);
		fire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SpellWindow.this.dispose();
				Spells.fireSpell(level);
			}
		});
		fire.setMaximumSize(new Dimension(290, 30));
		return fire;
	}

}
