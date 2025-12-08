package teamProject;

import enemyEncounter.Spell;

/**
 * Contains all of the players stats, as well as leveling up. Max level = 20.
 * Level 1 stats
 * Health = 20
 * Defense = 0
 * Attack = 2
 * xpLimit = x
 * 
 */
public class PlayerCharacter {
	
	//Stat increments with leveling up:
	private int[] healthLevels = {20, 20, 20, 30, 30, 30, 40, 40, 40, 50, 50, 50, 50, 60, 60, 60, 70, 70, 80, 100, 999};
	private int[] defenseLevels = {0, 1, 1, 2, 2, 2, 3, 4, 5, 5, 7, 8, 8, 9, 9, 9, 10, 10, 12, 15, 99};
	private int[] attackLevels = {2, 3, 5, 5, 6, 7, 8, 10, 10, 10, 14, 17, 20, 23, 25, 30, 30, 30, 35, 40, 99};
	private int[] xpLimitLevels = {10, 15, 20, 27, 35, 42, 50, 60, 70, 80, 90, 100, 115, 130, 150, 170, 190, 220, 250, 9999};
	
	private int level;
	private int health;
	private int healthLimit;
	private int defense;
	private int defenseBoost;
	private int attack;
	private int attackBoost;
	private int xp;
	private int xpLimit;
	
	private int skillPoints;
	private int fireSpell;
	private int iceSpell;
	private int healSpell;
	private int defenseBoostSpell;
	private int attackBoostSpell;
	
	/**
	 * Player starts at level one with base stats.
	 */
	public PlayerCharacter() {
		level = 1;
		levelUp(level);
		
		skillPoints = 0;
		fireSpell = 1;
		iceSpell = 1;
		healSpell = 1;
		defenseBoostSpell = 1;
		attackBoostSpell = 1;
	}
	
	/**
	 * Levels up the character. Stats are updated using the arrays of stats.
	 * XP is set back to zero and the XPlimit increases.
	 * The player heals to full health and gains one skill point.
	 * @param level
	 */
	public void levelUp(int level) {
		int index = level-=1;
		health = healthLevels[index];
		healthLimit = healthLevels[index];
		defense = defenseLevels[index];
		attack = attackLevels[index];
		xp = 0;
		xpLimit = xpLimitLevels[index];
		skillPoints++;
	}
	/**
	 * The following methods are getters and setters.
	 * @return
	 */
	public int getLevel() {
		return level;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int damage) {
		health -= damage;
	}
	
	public int getHealthLimit() {
		return healthLimit;
	}
	
	public int getDefense() {
		return defense;
	}
	
	public int getDefenseBoost() {
		return defenseBoost;
	}
	
	public void setDefenseBoost(int boost) {
		defenseBoost = boost;
	}
	
	public int getAttack() {
		return attack;
	}
	
	public int getAttackBoost() {
		return attackBoost;
	}
	
	public void setAttackBoost(int boost) {
		attackBoost = boost;
	}
	
	public int getXp() {
		return xp;
	}
	/**
	 * If increased xp is equal to or exceeds the limit, then the player levels up and opens the level up window.
	 * @param xpYield
	 */
	public void setXP(int xpYield) {
		xp += xpYield;
		if(xp >= xpLimit){
			level++;
			this.levelUp(level);
			LevelUpWindow levelUpWindow = new LevelUpWindow(this);
			levelUpWindow.setVisible(true);
		}
	}
	
	public int getXpLimit() {
		return xpLimit;
	}
	
	public int getSkillPoints() {
		return skillPoints;
	}
	
	public void useSkillPoints() {
		skillPoints--;
	}
	
	public int getFireSpell() {
		return fireSpell;
	}
	
	public int getIceSpell() {
		return iceSpell;
	}
	
	public int getHealSpell() {
		return healSpell;
	}
	
	public int getDefenseBoostSpell() {
		return defenseBoostSpell;
	}
	
	public int getAttackBoostSpell() {
		return attackBoostSpell;
	}
	/**
	 * Levels up whichever spell is passed to the method.
	 * @param spell
	 */
	public void levelUpSpell(Spell spell) {
		switch(spell) {
		case Spell.FIRE: fireSpell++; break;
		case Spell.ICE: iceSpell++; break;
		case Spell.HEAL: healSpell++; break;
		case Spell.ATTACK_BOOST: attackBoostSpell++; break;
		case Spell.DEFENSE_BOOST: defenseBoostSpell++; break;
		}
		
	}
	/**
	 * Heals the player, up to the character's maximum health.
	 * @param heal
	 */
	public void heal(int heal) {
		health += heal;
		if(health > healthLimit) {
			health = healthLimit;
		}
	}
}
