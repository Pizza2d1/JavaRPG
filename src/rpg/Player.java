package rpg;

import java.awt.Color;
import java.awt.Point;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Player{

	static JLabel player = new JLabel("");
	
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
	}

	static void moveDown(JPanel player) {
		Point playerLocation = player.getLocation();
		int pointx = (int) Math.round(playerLocation.getX());
		int pointy = (int) Math.round(playerLocation.getY());
		player.setLocation(pointx, pointy + Constants.PLAYER_MOVE_SPEED);
	}

	static void moveLeft(JPanel player) {
		Point playerLocation = player.getLocation();
		int pointx = (int) Math.round(playerLocation.getX());
		int pointy = (int) Math.round(playerLocation.getY());
		player.setLocation(pointx - Constants.PLAYER_MOVE_SPEED, pointy);
	}

	static void moveRight(JPanel player) {
		Point playerLocation = player.getLocation();
		int pointx = (int) Math.round(playerLocation.getX());
		int pointy = (int) Math.round(playerLocation.getY());
		player.setLocation(pointx + Constants.PLAYER_MOVE_SPEED, pointy);
	}
}
