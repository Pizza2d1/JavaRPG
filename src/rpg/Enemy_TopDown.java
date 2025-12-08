package rpg;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


// TODO: Auto-generated Javadoc
/**
 * The Class Enemy_TopDown.
 */
public class Enemy_TopDown implements Movable {

	/** The enemy. */
	static JLabel enemy = new JLabel("");		

	/**
	 * Instantiates a new enemy top down.
	 *
	 * @param layeredPane the layered pane
	 * @param enemy_panel the enemy panel
	 * @param z_layer the z layer
	 * @param startx the startx
	 * @param starty the starty
	 */
	public Enemy_TopDown(JLayeredPane layeredPane, JPanel enemy_panel, int z_layer, int startx, int starty) {
		enemy_panel.setBackground(new Color(255, 255, 255));
		int startingPosx = (Constants.WORLD_SIZE_X / 2) - (Constants.PLAYER_SIZE / 2);
		int startingPosy = (Constants.WORLD_SIZE_Y / 2) - (Constants.PLAYER_SIZE / 2);
		enemy_panel.setBounds(startingPosx, startingPosy, Constants.PLAYER_SIZE + Constants.SWORD_DISTANCE*2, Constants.PLAYER_SIZE + Constants.SWORD_DISTANCE*2);
		layeredPane.setLayer(enemy_panel, z_layer);
		layeredPane.add(enemy_panel);
		enemy_panel.setLayout(null);

		enemy.setBounds(startx, starty, Constants.ENEMY_SIZE,Constants.ENEMY_SIZE);
		enemy.setIcon(Constants.wolf);

		enemy_panel.setOpaque(false);
		enemy_panel.add(enemy);
	}
	 
	/**
	 * Instantiates a new enemy top down.
	 *
	 * @param layeredPane the layered pane
	 * @param enemy_panel the enemy panel
	 * @param z_layer the z layer
	 */
	public Enemy_TopDown(JLayeredPane layeredPane, JPanel enemy_panel, int z_layer) {
		enemy_panel.setBackground(new Color(255, 255, 255));
		int startingPosx = (Constants.SCREEN_SIZE_X  / 2) - ((Constants.PLAYER_SIZE / 2) + Constants.SWORD_DISTANCE/2);
		int startingPosy = (Constants.SCREEN_SIZE_Y  / 2) - ((Constants.PLAYER_SIZE / 2) + Constants.SWORD_DISTANCE/2);
		enemy_panel.setBounds(startingPosx, startingPosy, Constants.PLAYER_SIZE + Constants.SWORD_DISTANCE*2, Constants.PLAYER_SIZE + Constants.SWORD_DISTANCE*2);
		layeredPane.setLayer(enemy_panel, z_layer);
		layeredPane.add(enemy_panel);
		enemy_panel.setLayout(null);

		enemy.setBounds(startingPosx, startingPosy, Constants.ENEMY_SIZE,Constants.ENEMY_SIZE);
		enemy.setIcon(Constants.wolf);

		enemy_panel.setOpaque(false);
		enemy_panel.add(enemy);
	}
	 
}
