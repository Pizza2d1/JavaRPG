package rpg;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Background {

	ImageIcon backgroundsrc = new ImageIcon(Background.class.getResource("/rpg/source.png"));

	public Background(JLayeredPane layeredPane, JPanel background_panel) {
		background_panel.setBounds(0, 0, Constants.SCREEN_SIZE_X, Constants.SCREEN_SIZE_Y);
		layeredPane.setLayer(background_panel, 1);
		layeredPane.add(background_panel);
		background_panel.setLayout(null);

		for (int i = -40; i < Constants.SCREEN_SIZE_X + 40; i += 20) {
			for (int j = -40; j < Constants.SCREEN_SIZE_Y + 40; j += 20) {
				backgroundPiece(background_panel, i, j);
			}
		}

	}

	private void backgroundPiece(JPanel panel, int x, int y) {
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(x, y, 20, 20);
		lblNewLabel.setIcon(backgroundsrc);
		panel.add(lblNewLabel);
	}

	static void moveBGUp(JPanel background) {
		Point backgroundLocation = background.getLocation();
		int pointx = (int) Math.round(backgroundLocation.getX());
		int pointy = (int) Math.round(backgroundLocation.getY());
		background.setLocation(pointx, pointy - Constants.BACKGROUND_MOVE_SPEED);
	}

	static void moveBGDown(JPanel background) {
		Point backgroundLocation = background.getLocation();
		int pointx = (int) Math.round(backgroundLocation.getX());
		int pointy = (int) Math.round(backgroundLocation.getY());
		background.setLocation(pointx, pointy + Constants.BACKGROUND_MOVE_SPEED);
	}

	static void moveBGLeft(JPanel background) {
		Point backgroundLocation = background.getLocation();
		int pointx = (int) Math.round(backgroundLocation.getX());
		int pointy = (int) Math.round(backgroundLocation.getY());
		background.setLocation(pointx - Constants.BACKGROUND_MOVE_SPEED, pointy);
	}

	static void moveBGRight(JPanel background) {
		Point backgroundLocation = background.getLocation();
		int pointx = (int) Math.round(backgroundLocation.getX());
		int pointy = (int) Math.round(backgroundLocation.getY());
		background.setLocation(pointx + Constants.BACKGROUND_MOVE_SPEED, pointy);
	}

}
