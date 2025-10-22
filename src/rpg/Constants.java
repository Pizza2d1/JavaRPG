package rpg;

import javax.swing.ImageIcon;

public class Constants {
	
	// GLOBAL
	final static int SCREEN_SIZE_X = 800;
	final static int SCREEN_SIZE_Y = 800;
	
	// PLAYER
	final static int PLAYER_MOVE_SPEED = 20;
	final static int PLAYER_SIZE = 40;
	final static int SWORD_DISTANCE = 20;

	
	final static ImageIcon blue = new ImageIcon(Background.class.getResource("/rpg/sprites/blue.png"));
	final static ImageIcon red = new ImageIcon(Background.class.getResource("/rpg/sprites/red.png"));
	final static ImageIcon bk = new ImageIcon(Background.class.getResource("/rpg/sprites/papa.png"));
	final static ImageIcon rc = new ImageIcon(Background.class.getResource("/rpg/sprites/rcircle.png"));
	final static ImageIcon sword = new ImageIcon(Background.class.getResource("/rpg/sprites/slash1.png"));



	
	// BACKGROUND
	final static int BACKGROUND_MOVE_SPEED = 10;
	final static int BLOCK_SIZE = 20;
	
	final static ImageIcon backgroundsrc = new ImageIcon(Background.class.getResource("/rpg/sprites/source.png"));

	
	// ENEMIES
}
