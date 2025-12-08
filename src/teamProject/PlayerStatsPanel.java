package teamProject;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
/**
 * Creates a panel displaying all of the player's stats.
 */
public class PlayerStatsPanel extends JPanel {
	JLabel lblLevel;
	JLabel lblHealth;
	JLabel lblDefense;
	JLabel lblAttack;
	JLabel lblXp;
	JLabel lblGap;
	JLabel lblFire;
	JLabel lblIce;
	JLabel lblHeal;
	JLabel lblDefenseBoost;
	JLabel lblAttackBoost;

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PlayerStatsPanel(PlayerCharacter player) {
		setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		//Creates each label displaying player's stats
		lblLevel = new JLabel("Level: " + player.getLevel());
		lblHealth = new JLabel("Health: " + player.getHealth() + "/" + player.getHealthLimit());
		lblDefense = new JLabel(String.format("Defense: %d + %d", player.getDefense(), player.getDefenseBoost()));
		lblAttack = new JLabel(String.format("Attack: %d + %d", player.getAttack(), player.getAttackBoost()));
		lblXp = new JLabel("XP: " + player.getXp() + "/" + player.getXpLimit());
		lblGap = new JLabel(" ");
		lblFire = new JLabel("Fire Spell: " + player.getFireSpell());
		lblIce = new JLabel("Ice Spell: " + player.getIceSpell());
		lblHeal = new JLabel("Heal Spell: " + player.getHealSpell());
		lblDefenseBoost = new JLabel("Defense Boost Spell: " + player.getDefenseBoostSpell() + "  ");
		lblAttackBoost = new JLabel("Attack Boost Spell: " + player.getAttackBoostSpell());
		
		//Sets font size to 14
		lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHealth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDefense.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAttack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblFire.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIce.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHeal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDefenseBoost.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAttackBoost.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		//Adds Each label to the panel
		this.add(lblLevel);
		this.add(lblHealth);
		this.add(lblDefense);
		this.add(lblAttack);
		this.add(lblXp);
		this.add(lblGap);
		this.add(lblFire);
		this.add(lblIce);
		this.add(lblHeal);
		this.add(lblDefenseBoost);
		this.add(lblAttackBoost);
	}
	/**
	 * Updates the health label to the player's stats.
	 * @param player
	 */
	public void setHealthLabel(PlayerCharacter player) {
		lblHealth.setText("Health: " + player.getHealth() + "/" + player.getHealthLimit());
	}
	/**
	 * Updates the defense label to the player's stats.
	 * @param player
	 */
	public void setDefenseLabel(PlayerCharacter player) {
		lblDefense.setText(String.format("Defense: %d + %d", player.getDefense(), player.getDefenseBoost()));
	}
	/**
	 * Updates the attack label to the player's stats.
	 * @param player
	 */
	public void setAttackLabel(PlayerCharacter player) {
		lblAttack.setText(String.format("Attack: %d + %d", player.getAttack(), player.getAttackBoost()));
	}
}
