package rpg;

import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class Keybindings {
	/*
	 * Add buffered inputs for attacking. Add detection for holding down a key to keep moving at a constant pace (not worrying about acceleration)
	 */
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
		default:
			break;
		}
	}
}
