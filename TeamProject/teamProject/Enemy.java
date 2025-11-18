package teamProject;

import enemyEncounter.*;
/**
 * Superclass of all enemies. Divides into SmallEnemy, MediumEnemy, and LargeEnemy.
 */
public abstract class Enemy {
	private int health;
	private int defense;
	private int attack;
	private int movement;
	private int xpYield;
	/**
	 * Assigns all of the stats and uses the stats to calculate xpYield.
	 * @param hp
	 * @param def
	 * @param att
	 * @param move
	 */
	protected Enemy(int hp, int def, int att, int move) {
		this.health = hp;
		this.defense = def;
		this.attack = att;
		this.movement = move;
		this.xpYield = (hp/10) + att + def;
	}
	/**
	 * Abstract method passed to each enemy individually to take their turn.
	 */
	public abstract void enemyTurn();
	/**
	 * Enemy does a basic attack using their attack stat.
	 */
	public void attack() {
		//return attack;
		EnemyEncounter.setTextBox(this.getClass().getSimpleName() + " attacks and deals " + this.getAttack() + " damage");
		EnemyEncounter.setPlayerTurn(true);
		//TODO Code enemy's attack on the player's health
	}
	
	public int move() {
		return movement;
	}
	/**
	 * Displays the three main stats. Health, Attack, Defense.
	 */
	@Override
	public String toString() {
		return String.format("Health:%d   Attack:%d   Defense:%d", health, attack, defense);
	}
	
	/**
	 * Getters and Setters
	 */
	public void setAttack(int att) {
		this.attack = att;
	}
	
	public int getAttack() {
		return attack;
	}
	
	public void setDefense(int def) {
		this.defense = def;
	}
	
	public int getDefense() {
		return defense;
	}
	
	public void setHealth(int hp) {
		this.health = hp;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getXPYield() {
		return xpYield;
	}
}
