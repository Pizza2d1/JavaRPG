package rpg;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
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
	static JLabel sword = new JLabel("");
	static facingDirection facing = facingDirection.UP; // Default facing
	
	public Player(JLayeredPane layeredPane, JPanel player_panel, int z_layer) {
		player_panel.setBackground(new Color(255, 255, 255));
		int startingPosx = (Constants.SCREEN_SIZE_X / 2) - (Constants.PLAYER_SIZE / 2);
		int startingPosy = (Constants.SCREEN_SIZE_Y / 2) - (Constants.PLAYER_SIZE / 2);
		player_panel.setBounds(startingPosx, startingPosy, Constants.PLAYER_SIZE + Constants.SWORD_DISTANCE*2, Constants.PLAYER_SIZE + Constants.SWORD_DISTANCE*2);
		layeredPane.setLayer(player_panel, z_layer);
		layeredPane.add(player_panel);
		player_panel.setLayout(null);

		player.setBounds(Constants.SWORD_DISTANCE, Constants.SWORD_DISTANCE, Constants.PLAYER_SIZE, Constants.PLAYER_SIZE);
		player.setIcon(Constants.blue);
		sword.setBounds(Constants.SWORD_SIZE, Constants.SWORD_SIZE, Constants.SWORD_SIZE, Constants.SWORD_SIZE);
		sword.setIcon(Constants.red);
		sword.setVisible(false);
		player_panel.setOpaque(false);
		player_panel.add(player);
		player_panel.add(sword);

	}
	// This ones for testing positions
	public Player(JLayeredPane layeredPane, JPanel player_panel, int z_layer, int startingPosx, int startingPosy) {
		player_panel.setBackground(new Color(255, 255, 255));
		player_panel.setBounds(startingPosx, startingPosy, Constants.PLAYER_SIZE + Constants.SWORD_DISTANCE*2, Constants.PLAYER_SIZE + Constants.SWORD_DISTANCE*2);
		layeredPane.setLayer(player_panel, z_layer);
		layeredPane.add(player_panel);
		player_panel.setLayout(null);

		player.setBounds(Constants.SWORD_DISTANCE, Constants.SWORD_DISTANCE, Constants.PLAYER_SIZE, Constants.PLAYER_SIZE);
		player.setIcon(Constants.blue);
		sword.setBounds(Constants.SWORD_SIZE, Constants.SWORD_SIZE, Constants.SWORD_SIZE, Constants.SWORD_SIZE);
		sword.setIcon(Constants.red);
		sword.setVisible(false);
		player_panel.setOpaque(false);
		player_panel.add(player);
		player_panel.add(sword);
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
	
	static Rectangle swingSword(JPanel player) {
		sword.setIcon(Constants.red);
		//Point playerLocation = player.getLocation(); // Where the player is located in reference to JFrame
		int pointx = Constants.SWORD_DISTANCE; // Where the player is located in reference to player_panel
		int pointy = Constants.SWORD_DISTANCE;
		//int change = (Constants.PLAYER_SIZE-Constants.SWORD_SIZE)/2; // Only works for square swords for now
		int changex = (Constants.PLAYER_SIZE-Constants.SWORD_SIZE_X)/2; // Needed to decide where to put the sword in case its a different size than the player
		int changey = (Constants.PLAYER_SIZE-Constants.SWORD_SIZE_Y)/2;
		//int dis_offset = (Constants.SWORD_DISTANCE/Constants.SWORD_SIZE_X); // For if the sword is long instead of wide, the sword won't merge with player
		//System.out.println(dis_offset);
		//System.out.println((Constants.SWORD_DISTANCE-Constants.SWORD_SIZE_X));
		//if (Constants.SWORD_DISTANCE==Constants.SWORD_SIZE_X) dis_offset =Constants.SWORD_DISTANCE;
		int dis_offset = ((Constants.PLAYER_SIZE-Constants.SWORD_DISTANCE)/2)*(Constants.SWORD_DISTANCE/Constants.SWORD_SIZE_X); // Good enough
		int dis_offsety = ((Constants.PLAYER_SIZE-Constants.SWORD_DISTANCE)/2)*(Constants.SWORD_DISTANCE/Constants.SWORD_SIZE_Y); // Good enough
		int tweak = 10; // stupid math can go suck a dick

		//dis_offset = 0;
		//System.out.println(changex);
		//System.out.println(changey);
		//System.out.println(dis_offset);
		//System.out.println(dis_offsety);

		switch (facing) {
		case facingDirection.UP:
			sword.setBounds(pointx+changex+tweak, pointy-Constants.SWORD_DISTANCE+changey-dis_offset, Constants.SWORD_SIZE_X, Constants.SWORD_SIZE_Y);
			//System.out.println("facing up");
			break;
		case facingDirection.DOWN:
			sword.setBounds(pointx+changex+tweak, pointy+Constants.SWORD_DISTANCE+changey+dis_offset, Constants.SWORD_SIZE_X, Constants.SWORD_SIZE_Y);
			//System.out.println("facing down");
			break;
		case facingDirection.LEFT:
			sword.setBounds(pointx-Constants.SWORD_DISTANCE+changey-dis_offset, pointy+changex, Constants.SWORD_SIZE_Y, Constants.SWORD_SIZE_X);
			//System.out.println("facing left");
			break;
		case facingDirection.RIGHT:
			sword.setBounds(pointx+Constants.SWORD_DISTANCE+changey+dis_offset, pointy+changex, Constants.SWORD_SIZE_Y, Constants.SWORD_SIZE_X);
			//System.out.println("facing right");
			break;
		}
		//System.out.println(String.format("Spawned sword at %d %d", pointx, pointy));
		int pointx2 = (int) Math.round(sword.getX());
		int pointy2 = (int) Math.round(sword.getY());
		//System.out.println(String.format("Actual location: %d %d", pointx2, pointy2));
		sword.setVisible(true);
		sleepy(Constants.SWING_TIME);
		sword.setVisible(false);;
		return sword.getBounds();
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
