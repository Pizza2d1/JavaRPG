package rpg;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Player implements Movable {
	
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
		//player_panel.setBackground(new Color(255, 255, 255));
		int startingPosx = (Constants.SCREEN_SIZE_X  / 2) - ((Constants.PLAYER_SIZE / 2) + Constants.SWORD_DISTANCE/2);
		int startingPosy = (Constants.SCREEN_SIZE_Y  / 2) - ((Constants.PLAYER_SIZE / 2) + Constants.SWORD_DISTANCE/2);
		System.out.println(startingPosx + " " + startingPosy);
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
	
	static Rectangle swingSword(JPanel player) {
		sword.setIcon(Constants.red);
		int pointx = Constants.SWORD_DISTANCE; // Where the player is located in reference to player_panel
		int pointy = Constants.SWORD_DISTANCE;
		int changex = (Constants.PLAYER_SIZE-Constants.SWORD_SIZE_X)/2; // Needed to decide where to put the sword in case its a different size than the player
		int changey = (Constants.PLAYER_SIZE-Constants.SWORD_SIZE_Y)/2;
		int dis_offset = ((Constants.PLAYER_SIZE-Constants.SWORD_DISTANCE)/2)*(Constants.SWORD_DISTANCE/Constants.SWORD_SIZE_X); // Good enough
		int tweak = 10; // stupid math can go suck a dick

		//dis_offset = 0;

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
		
		sword.setVisible(true);
		RPG_App.sleepy(Constants.SWING_TIME);
		sword.setVisible(false);;
		return sword.getBounds();
	}
	
	public static void checkHurtbox(Rectangle hurtbox) {
		// TODO use Rectangle object to check to see if there is a colliding enemy hitbox
	}


}
