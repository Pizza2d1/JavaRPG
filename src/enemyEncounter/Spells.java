package enemyEncounter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import teamProject.PlayerCharacter;

/**
 * Contains the different types of spells and implements their levels. 1-5.
 */
public class Spells {
	private EnemyEncounter encounter;
	/**
	 * TODO Create either special effect or resistances.
	 * TODO Change all spells to be factors of player stats.
	 * Level 1: 10 - 1.25x
	 * Level 2: 20 - 1.5x
	 * Level 3: 30 - 1.75x
	 * Level 4: 45 - 2x
	 * Level 5: 60 - 2.5x
	 * @param level
	 */
	public void fireSpell(EnemyEncounter encounter, PlayerCharacter player, int level) {
		this.encounter = encounter;
		Spell spell = Spell.FIRE;
		double baseDamage = 0;
		switch (level) {
		case 1: baseDamage = player.getAttack() * 1.25; break;
		case 2: baseDamage = player.getAttack() * 1.5; break;
		case 3: baseDamage = player.getAttack() * 1.75; break;
		case 4: baseDamage = player.getAttack() * 2; break;
		case 5: baseDamage = player.getAttack() * 2.5; break;
		}
		final int damage;
		final String resistance;
		if(EnemyEncounter.getEnemy().getResistFire()) {
			damage = (int)baseDamage/2;
			resistance = String.format(" %s resists fire.", EnemyEncounter.getEnemy().getClass().getSimpleName());
		}else {
			if((int)baseDamage <= player.getAttack()) {
				damage = (int)baseDamage + 1;
			}else {
				damage = (int)baseDamage;
			}
			resistance = "";
		}
		spellMessage(spell, level, resistance, damage);
		final EnemyEncounter encounter1 = this.encounter;
		Timer timer = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				encounter1.damageEnemy(damage);
			}
		});
		timer.setRepeats(false);
		timer.start();
	}
	/**
	 * TODO Create either special effect or resistances.
	 * Level 1: 10 - 1.25x
	 * Level 2: 20 - 1.5x
	 * Level 3: 30 - 1.75x
	 * Level 4: 45 - 2x
	 * Level 5: 60 - 2.5x
	 * @param level
	 */
	public void iceSpell(EnemyEncounter encounter, PlayerCharacter player, int level) {
		this.encounter = encounter;
		Spell spell = Spell.ICE;
		double baseDamage = 0;
		switch (level) {
		case 1: baseDamage = player.getAttack() * 1.25; break;
		case 2: baseDamage = player.getAttack() * 1.5; break;
		case 3: baseDamage = player.getAttack() * 1.75; break;
		case 4: baseDamage = player.getAttack() * 2; break;
		case 5: baseDamage = player.getAttack() * 2.5; break;
		}
		final int damage;
		final String resistance;
		if(EnemyEncounter.getEnemy().getResistIce()) {
			damage = (int)baseDamage / 2;
			resistance = String.format(" %s resists ice.", EnemyEncounter.getEnemy().getClass().getSimpleName());
		}else {
			if((int)baseDamage <= player.getAttack()){
				damage = (int)baseDamage + 1;
			}else {
				damage = (int)baseDamage;
			}
			resistance = "";
		}
		spellMessage(spell, level, resistance, damage);
		final EnemyEncounter encounter1 = this.encounter;
		Timer timer = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				encounter1.damageEnemy(damage);
			}
		});
		timer.setRepeats(false);
		timer.start();
	}
	/**
	 * TODO Scale to the player's health.
	 * Level 1: 10 - 0.5x
	 * Level 2: 20 - 0.6
	 * Level 3: 35 - 0.7
	 * Level 4: 50 - 0.8
	 * Level 5: 70 - 1x
	 * @param level
	 */
	public void healSpell(EnemyEncounter encounter, PlayerCharacter player, int level) {
		this.encounter = encounter;
		Spell spell = Spell.HEAL;
		double baseHeal = 0;
		switch (level) {
		case 1: baseHeal = player.getHealthLimit() * 0.5; break;
		case 2: baseHeal = player.getHealthLimit() * 0.6; break;
		case 3: baseHeal = player.getHealthLimit() * 0.7; break;
		case 4: baseHeal = player.getHealthLimit() * 0.8; break;
		case 5: baseHeal = player.getHealthLimit() * 1; break;
		}
		final int heal = (int)baseHeal;
		final String blank = null;
		final EnemyEncounter encounter1 = encounter;
		spellMessage(spell, level, blank, heal);
		Timer timer = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				encounter1.healPlayer(heal);
				//TODO
			}
		});
		timer.setRepeats(false);
		timer.start();
	}
	/**
	 * Level 1: 3 - 0.5x
	 * Level 2: 5 - 0.6x
	 * Level 3: 8 - 0.7x
	 * Level 4: 10 - 0.8x
	 * Level 5: 15 - 1x
	 * @param level
	 */
	public void attackBoostSpell(EnemyEncounter encounter, PlayerCharacter player, int level) {
		this.encounter = encounter;
		Spell spell = Spell.ATTACK_BOOST;
		double baseBoost = 0;
		switch (level) {
		case 1: baseBoost = player.getAttack() * 0.5; break;
		case 2: baseBoost = player.getAttack() * 0.6; break;
		case 3: baseBoost = player.getAttack() * 0.7; break;
		case 4: baseBoost = player.getAttack() * 0.8; break;
		case 5: baseBoost = player.getAttack() * 1; break;
		}
		final int boost;
		if((int)baseBoost <= 1) {
			boost = 2;
		}else {
			boost = (int)baseBoost;
		}
		final String blank = null;
		final EnemyEncounter encounter1 = encounter;
		spellMessage(spell, level, blank, boost);
		Timer timer = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				encounter1.boostAttack(boost);
				//TODO
			}
		});
		timer.setRepeats(false);
		timer.start();
		//TODO Code Actual Spell
	}
	/**
	 * Level 1: 3 - 0.5x
	 * Level 2: 5 - 0.6x
	 * Level 3: 8 - 0.7x
	 * Level 4: 10 - 0.8x
	 * Level 5: 15 - 1x
	 * @param level
	 */
	public void defenseBoostSpell(EnemyEncounter encounter, PlayerCharacter player, int level) {
		this.encounter = encounter;
		Spell spell = Spell.DEFENSE_BOOST;
		double baseBoost = 0;
		switch (level) {
		case 1: baseBoost = player.getDefense() * 0.5; break;
		case 2: baseBoost = player.getDefense() * 0.6; break;
		case 3: baseBoost = player.getDefense() * 0.7; break;
		case 4: baseBoost = player.getDefense() * 0.8; break;
		case 5: baseBoost = player.getDefense() * 1; break;
		}
		final int boost;
		if((int)baseBoost <= 1) {
			boost = 2;
		}else {
			boost = (int)baseBoost;
		}
		final String blank = null;
		final EnemyEncounter encounter1 = encounter;
		spellMessage(spell, level, blank, boost);
		Timer timer = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				encounter1.boostDefense(boost);
				//TODO
			}
		});
		timer.setRepeats(false);
		timer.start();
		//TODO Code Actual Spell
	}
	/**
	 * Uses a timer to edit the text box with two messages 1.5 seconds apart. It then passes to the enemy's turn.
	 * @param spell
	 * @param level
	 */
	public void spellMessage(Spell spell, int level, String resistance, int effect) {
		encounter.setTextBox("Casting level " + level + " "+ spell + " spell.");
	
		Timer timer = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch(spell) {
				case Spell.FIRE:
					encounter.setTextBox(String.format("Casting level %d %s spell.%s Deals %d damage!", level, spell, resistance, effect));
					break;
				case Spell.ICE:
					encounter.setTextBox(String.format("Casting level %d %s spell.%s Deals %d damage!", level, spell, resistance, effect));
					break;
				case Spell.HEAL:
					encounter.setTextBox(String.format("Casting level %d %s spell. Heals %d health!", level, spell, effect));
					break;
				case Spell.DEFENSE_BOOST:
					encounter.setTextBox(String.format("Casting level %d %s spell. +%d defense!", level, spell, effect));
					break;
				case Spell.ATTACK_BOOST:
					encounter.setTextBox(String.format("Casting level %d %s spell. +%d attack!", level, spell, effect));
					break;
				}
			}
		});
		timer.setRepeats(false);
		timer.start();
	}
}