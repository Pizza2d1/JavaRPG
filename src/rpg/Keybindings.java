package rpg;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JPanel;

import rpg.Player.facingDirection;

public class Keybindings {
	 /*
	 * Add buffered inputs for attacking. Add detection for holding down a key to keep moving at a constant pace (not worrying about acceleration)
	 */
	// List of keyevents: https://docs.oracle.com/javase/7/docs/api/java/awt/event/KeyEvent.html
	static int buffer = RPG_App.getCurrentMilliseconds();
	static int pre_time;
	static int new_time;
	
	static Player player;
	static Background background;
	static Enemy_TopDown enemy;
	
	public Keybindings(Player player, Background background, Enemy_TopDown enemy) {
		Keybindings.player = player;
		Keybindings.background = background;
		Keybindings.enemy = enemy;
	}
	
	static void action(int keyCode, JPanel background_panel, JPanel player_panel, JPanel enemies_panel) throws IOException {
		switch (keyCode) {
		case KeyEvent.VK_W:
			background.moveUp(background_panel, Constants.BACKGROUND_MOVE_SPEED);
			break;
		case KeyEvent.VK_S:
			background.moveDown(background_panel, Constants.BACKGROUND_MOVE_SPEED);
			break;
		case KeyEvent.VK_A:
			background.moveLeft(background_panel, Constants.BACKGROUND_MOVE_SPEED);
			break;
		case KeyEvent.VK_D:
			background.moveRight(background_panel, Constants.BACKGROUND_MOVE_SPEED);
			break;
		
		
		case KeyEvent.VK_UP:
			enemy.moveDown(enemies_panel, Constants.BACKGROUND_MOVE_SPEED);
			background.moveDown(background_panel, Constants.BACKGROUND_MOVE_SPEED);
			Player.facing = facingDirection.UP;
			checkCollision();
			break;
		case KeyEvent.VK_DOWN:
			enemy.moveUp(enemies_panel, Constants.BACKGROUND_MOVE_SPEED);
			background.moveUp(background_panel, Constants.BACKGROUND_MOVE_SPEED);
			Player.facing = facingDirection.DOWN;
			checkCollision();
			break;
		case KeyEvent.VK_LEFT:
			enemy.moveRight(enemies_panel, Constants.BACKGROUND_MOVE_SPEED);
			background.moveRight(background_panel, Constants.BACKGROUND_MOVE_SPEED);
			Player.facing = facingDirection.LEFT;
			checkCollision();
			break;
		case KeyEvent.VK_RIGHT:
			enemy.moveLeft(enemies_panel, Constants.BACKGROUND_MOVE_SPEED);
			background.moveLeft(background_panel, Constants.BACKGROUND_MOVE_SPEED);
			Player.facing = facingDirection.RIGHT;
			checkCollision();
			break;
		
		/*
		case KeyEvent.VK_UP:
			player.moveUp(player_panel, Constants.PLAYER_STEP);
			Player.facing = facingDirection.UP;
			checkCollision();
			break;
		case KeyEvent.VK_DOWN:
			player.moveDown(player_panel, Constants.PLAYER_STEP);
			Player.facing = facingDirection.DOWN;
			checkCollision();
			break;
		case KeyEvent.VK_LEFT:
			player.moveLeft(player_panel, Constants.PLAYER_STEP);
			Player.facing = facingDirection.LEFT;
			checkCollision();
			break;
		case KeyEvent.VK_RIGHT:
			player.moveRight(player_panel, Constants.PLAYER_STEP);
			Player.facing = facingDirection.RIGHT;
			checkCollision();
			break;
		*/

		case KeyEvent.VK_SPACE:
			pre_time = buffer;
			new_time = RPG_App.getCurrentMilliseconds();
			System.out.println(pre_time);		
			System.out.println(new_time);
			if (new_time < pre_time+Constants.SWING_TIME) {
				//System.out.println("Too fast");
			} else {
			    Thread taskThread = new Thread(() -> {
					Rectangle hurtbox = Player.swingSword(player_panel);
					System.out.println(RPG_App.enemies.size());
					for (int i = 0; i < RPG_App.enemies.size(); i++) {
					//for (Enemy_TopDown enemy_ent : RPG_App.enemies) {
						try {
							Player.checkHurtbox(Enemy_TopDown.enemy);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
			    });
			    taskThread.start();
				//System.out.println("swung");
				buffer = new_time;
			}
			//Player.swingSword(panel);
			break;
		default:
			break;
		}
	}
	
	public static void checkCollision() throws IOException {
		for (Enemy_TopDown enemy_ent : RPG_App.enemies) {
			Player.checkHurtbox(Enemy_TopDown.enemy);
		}
	}
}
