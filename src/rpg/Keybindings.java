package rpg;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class Keybindings {
	 /*
	 * Add buffered inputs for attacking. Add detection for holding down a key to keep moving at a constant pace (not worrying about acceleration)
	 */
	// List of keyevents: https://docs.oracle.com/javase/7/docs/api/java/awt/event/KeyEvent.html
	static int buffer = Player.getCurrentMilliseconds();
	static void action(int keyCode, JPanel background_panel, JPanel panel) {
		switch (keyCode) {
		case KeyEvent.VK_W:
			Background.moveBGUp(background_panel);
			break;
		case KeyEvent.VK_S:
			Background.moveBGDown(background_panel);
			break;
		case KeyEvent.VK_A:
			Background.moveBGLeft(background_panel);
			break;
		case KeyEvent.VK_D:
			Background.moveBGRight(background_panel);
			break;
		case KeyEvent.VK_UP:
			Player.moveUp(panel);
			break;
		case KeyEvent.VK_DOWN:
			Player.moveDown(panel);
			break;
		case KeyEvent.VK_LEFT:
			Player.moveLeft(panel);
			break;
		case KeyEvent.VK_RIGHT:
			Player.moveRight(panel);
			break;
		case KeyEvent.VK_SPACE:
			int pre_time = buffer;
			int new_time = Player.getCurrentMilliseconds();
			System.out.println(pre_time);		
			System.out.println(new_time);
			if (new_time < pre_time+Constants.SWING_TIME) {
				//System.out.println("Too fast");
			} else {
			    Thread taskThread = new Thread(() -> {
					Rectangle hurtbox = Player.swingSword(panel);
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
}
