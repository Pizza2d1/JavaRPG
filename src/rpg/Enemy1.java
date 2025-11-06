package rpg;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


public class Enemy1 implements Movable {

	static JLabel enemy = new JLabel("");		

	public Enemy1(JLayeredPane layeredPane, JPanel enemy_panel, int z_layer, int startx, int starty) {
		enemy_panel.setBackground(new Color(255, 255, 255));
		int startingPosx = (Constants.SCREEN_SIZE_X / 2) - (Constants.PLAYER_SIZE / 2);
		int startingPosy = (Constants.SCREEN_SIZE_Y / 2) - (Constants.PLAYER_SIZE / 2);
		enemy_panel.setBounds(startingPosx, startingPosy, Constants.PLAYER_SIZE + Constants.SWORD_DISTANCE*2, Constants.PLAYER_SIZE + Constants.SWORD_DISTANCE*2);
		layeredPane.setLayer(enemy_panel, z_layer);
		layeredPane.add(enemy_panel);
		enemy_panel.setLayout(null);

		enemy.setBounds(startx, starty, Constants.ENEMY_SIZE,Constants.ENEMY_SIZE);
		enemy.setIcon(Constants.blue);

		enemy_panel.setOpaque(false);
		enemy_panel.add(enemy);
	}
	 
}
