package rpg;

import java.awt.Color;
import java.awt.Point;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Player{
	
	enum facingDirection {
		UP,
		DOWN,
		LEFT,
		RIGHT
	}

	static JLabel player = new JLabel("");
	static facingDirection facing = facingDirection.UP; // Default facing
	
	public Player(JLayeredPane layeredPane, JPanel player_panel, int z_layer) {
		player_panel.setBackground(new Color(255, 255, 255));
		int startingPosx = (Constants.SCREEN_SIZE_X / 2) - (Constants.PLAYER_SIZE / 2);
		int startingPosy = (Constants.SCREEN_SIZE_Y / 2) - (Constants.PLAYER_SIZE / 2);
		player_panel.setBounds(startingPosx, startingPosy, Constants.PLAYER_SIZE, Constants.PLAYER_SIZE);
		layeredPane.setLayer(player_panel, z_layer);
		layeredPane.add(player_panel);
		player_panel.setLayout(null);

		player.setBounds(0, 0, Constants.PLAYER_SIZE, Constants.PLAYER_SIZE);
		player.setIcon(Constants.blue);
		player_panel.setOpaque(false);
		player_panel.add(player);
	}
	// This ones for testing positions
	public Player(JLayeredPane layeredPane, JPanel player_panel, int z_layer, int startingPosx, int startingPosy) {
		player_panel.setBackground(new Color(255, 255, 255));
		player_panel.setBounds(startingPosx, startingPosy, Constants.PLAYER_SIZE, Constants.PLAYER_SIZE);
		layeredPane.setLayer(player_panel, z_layer);
		layeredPane.add(player_panel);
		player_panel.setLayout(null);

		player.setBounds(0, 0, Constants.PLAYER_SIZE, Constants.PLAYER_SIZE);
		player.setIcon(Constants.red);
		player_panel.setOpaque(false);
		player_panel.add(player);
	}
	
	/*
	 * METHODS GO HERE
	 */

	static void moveUp(JPanel panel) {
		Point playerLocation = panel.getLocation();
		int pointx = (int) Math.round(playerLocation.getX());
		int pointy = (int) Math.round(playerLocation.getY());
		panel.setLocation(pointx, pointy - Constants.PLAYER_MOVE_SPEED);
		facing = facingDirection.UP;
	}

	static void moveDown(JPanel player) {
		Point playerLocation = player.getLocation();
		int pointx = (int) Math.round(playerLocation.getX());
		int pointy = (int) Math.round(playerLocation.getY());
		player.setLocation(pointx, pointy + Constants.PLAYER_MOVE_SPEED);
		facing = facingDirection.DOWN;
	}

	static void moveLeft(JPanel player) {
		Point playerLocation = player.getLocation();
		int pointx = (int) Math.round(playerLocation.getX());
		int pointy = (int) Math.round(playerLocation.getY());
		player.setLocation(pointx - Constants.PLAYER_MOVE_SPEED, pointy);
		facing = facingDirection.LEFT;
	}

	static void moveRight(JPanel player) {
		Point playerLocation = player.getLocation();
		int pointx = (int) Math.round(playerLocation.getX());
		int pointy = (int) Math.round(playerLocation.getY());
		player.setLocation(pointx + Constants.PLAYER_MOVE_SPEED, pointy);
		facing = facingDirection.RIGHT;
	}
	
	static void swingSword(JPanel player) {
		JLabel sword = new JLabel("");
		sword.setIcon(Constants.sword);
		Point playerLocation = player.getLocation();
		int pointx = (int) Math.round(playerLocation.getX());
		int pointy = (int) Math.round(playerLocation.getY());
		switch (facing) {
		case facingDirection.UP:
			sword.setLocation(pointx, pointy-Constants.SWORD_DISTANCE);
			break;
		case facingDirection.DOWN:
			sword.setLocation(pointx, pointy+Constants.SWORD_DISTANCE);
			break;
		case facingDirection.LEFT:
			sword.setLocation(pointx-Constants.SWORD_DISTANCE, pointy);
			break;
		case facingDirection.RIGHT:
			sword.setLocation(pointx+Constants.SWORD_DISTANCE, pointy);
			break;
		}
		sleepy(1000);
		sword = null;
	}
	
	
	
	public static int getCurrentMilliseconds() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter Mformatter = DateTimeFormatter.ofPattern("mm");
		DateTimeFormatter Sformatter = DateTimeFormatter.ofPattern("ss");
		DateTimeFormatter mmformatter = DateTimeFormatter.ofPattern("SSS");
		String strMin = now.format(Mformatter);
		String strSec = now.format(Sformatter);
		String strMilli = now.format(mmformatter);
		int min = Integer.valueOf(strMin);
		int sec = Integer.valueOf(strSec);
		int milli = Integer.valueOf(strMilli);
		if (min == 0)
			min += 60;
		int time = ((min * 60 * 1000) + (sec * 1000) + milli);
		return time;
	}

	public static void sleepy(int milli) {
		try {
			// to sleep 10 seconds
			Thread.sleep(milli);
		} catch (InterruptedException epenis) {
			// recommended because catching InterruptedException clears interrupt flag
			Thread.currentThread().interrupt();
			// you probably want to quit if the thread is interrupted
			return;
		}
	}

}
