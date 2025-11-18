package enemyEncounter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

/**
 * Contains the different types of spells and implements their levels. 1-5.
 */
public class Spells {
	/**
	 * TODO Create either special effect or resistances.
	 * Level 1: 10
	 * Level 2: 20
	 * Level 3: 35
	 * Level 4: 50
	 * Level 5: 70
	 * @param level
	 */
	public static void fireSpell(int level) {
		spellMessage("Fire", level);
		
		//TODO Code Actual Spell
	}
	/**
	 * TODO Create either special effect or resistances.
	 * Level 1: 10
	 * Level 2: 20
	 * Level 3: 35
	 * Level 4: 50
	 * Level 5: 70
	 * @param level
	 */
	public static void iceSpell(int level) {
		spellMessage("Ice", level);
		
		//TODO Code Actual Spell
	}
	/**
	 * TODO Scale to the player's health.
	 * Level 1: 10
	 * Level 2: 20
	 * Level 3: 35
	 * Level 4: 50
	 * Level 5: 70
	 * @param level
	 */
	public static void healSpell(int level) {
		spellMessage("Heal", level);
		
		//TODO Code Actual Spell
	}
	/**
	 * Level 1: 3
	 * Level 2: 5
	 * Level 3: 8
	 * Level 4: 12
	 * Level 5: 18
	 * @param level
	 */
	public static void attackBoostSpell(int level) {
		spellMessage("Attack Boost", level);
		
		//TODO Code Actual Spell
	}
	/**
	 * Level 1: 3
	 * Level 2: 5
	 * Level 3: 8
	 * Level 4: 12
	 * Level 5: 18
	 * @param level
	 */
	public static void defenseBoostSpell(int level) {
		spellMessage("Defense Boost", level);
		
		//TODO Code Actual Spell
	}
	/**
	 * Uses a timer to edit the text box with two messages 1.5 seconds apart. It then passes to the enemy's turn.
	 * @param spell
	 * @param level
	 */
	public static void spellMessage(String spell, int level) {
		EnemyEncounter.setTextBox("Casting " + spell + " spell.");
	
		Timer timer = new Timer(1500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EnemyEncounter.setTextBox("Casting level " + level + " " + spell + " spell");
				EnemyEncounter.nextTurn();
			}
		});
		timer.setRepeats(false);
		timer.start();
	}
	
	
}
