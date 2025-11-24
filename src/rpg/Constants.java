package rpg;

import javax.swing.ImageIcon;

public class Constants {
	
	// GLOBAL
	final static int WORLD_SIZE_X = 1600;
	final static int WORLD_SIZE_Y = 1000;
	final static int SCREEN_SIZE_X = 500;
	final static int SCREEN_SIZE_Y = 500;

	
	// PLAYER
	final static ImageIcon PLAYER_ICON = new ImageIcon(Background.class.getResource("/rpg/sprites/bk.png"));
	final static int PLAYER_STEP = 20;
	final static int PLAYER_SIZE = 40;
	final static int SWORD_DISTANCE = 40;
	final static int SWORD_SIZE = 80;
	final static int SWORD_SIZE_X = 120;
	final static int SWORD_SIZE_Y = 40;	
	final static int SWING_TIME = 400; // In milliseconds



	
	final static ImageIcon blue = new ImageIcon(Background.class.getResource("/rpg/sprites/blue.png"));
	final static ImageIcon red = new ImageIcon(Background.class.getResource("/rpg/sprites/red.png"));
	final static ImageIcon sand = new ImageIcon(Background.class.getResource("/rpg/sprites/sand.png"));
	final static ImageIcon grass = new ImageIcon(Background.class.getResource("/rpg/sprites/grass.png"));
	final static ImageIcon bk = new ImageIcon(Background.class.getResource("/rpg/sprites/papa.png"));
	final static ImageIcon wolf = new ImageIcon(Background.class.getResource("/rpg/sprites/wolfTD.png"));	
	final static ImageIcon rat = new ImageIcon(Background.class.getResource("/rpg/sprites/ratTD.png"));	
	final static ImageIcon rc = new ImageIcon(Background.class.getResource("/rpg/sprites/rcircle.png"));
	final static ImageIcon swordR = new ImageIcon(Background.class.getResource("/rpg/sprites/slash1.png"));
	final static ImageIcon swordL = new ImageIcon(Background.class.getResource("/rpg/sprites/slash2.png"));
	final static ImageIcon swordU = new ImageIcon(Background.class.getResource("/rpg/sprites/slash3.png"));
	final static ImageIcon swordD = new ImageIcon(Background.class.getResource("/rpg/sprites/slash4.png"));




	
	// BACKGROUND
	final static int BACKGROUND_MOVE_SPEED = 10;
	final static int BLOCK_SIZE = 20;
	
	final static ImageIcon backgroundsrc = new ImageIcon(Background.class.getResource("/rpg/sprites/source.png"));

	
	// ENEMIES
	final static int ENEMY_SIZE = 40;
	final static int ENEMY_HEALTH = 100;
	final static int ENEMY_DAMAGE = 15;
	final static int ENEMY_STEP = 5; // Distance
	final static int ENEMY_PACE = 50; // Time (milliseconds)
}
