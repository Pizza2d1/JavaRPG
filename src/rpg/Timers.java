package rpg;


import java.util.List;

import javax.swing.JPanel;


public class Timers implements Runnable {

	enum State {
		CIRCLING,
		DIAMOND,
		UP,
		DOWN,
		LEFT,
		RIGHT
	}
	
	
	@Override
	public void run() { // Using this run method is pretty much mandatory
		State movement = State.DOWN; // Default facing

		List<Enemy1> enemies = RPG_App.enemies;
		Enemy1 test_enemy = RPG_App.test_enemy;

		JPanel enemies_panel = RPG_App.enemies_panel;

		switch (movement) {
		case UP:
			test_enemy.moveUp(enemies_panel, Constants.ENEMY_STEP);
			break;
		case DOWN:
			test_enemy.moveDown(enemies_panel, Constants.ENEMY_STEP);
			break;
		case LEFT:
			test_enemy.moveLeft(enemies_panel, Constants.ENEMY_STEP);
			break;
		case RIGHT:
			test_enemy.moveRight(enemies_panel, Constants.ENEMY_STEP);
			break;
		default:
			break;
		}
		
		
		//for (Enemy1 enemy : enemies) enemy.moveUp(enemies_panel, Constants.ENEMY_SPEED);
		
		
	}
	public void stateMoveCircles(Enemy1 test_enemy, JPanel enemies_panel) {
	}
	public void stateMoveDiagonals(Enemy1 test_enemy, JPanel enemies_panel) {
	}
}
