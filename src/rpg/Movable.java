package rpg;

import java.awt.Point;

import javax.swing.JPanel;

public interface Movable {

	default void moveUp(JPanel panel, int speed) {
		Point location = panel.getLocation();
		panel.setLocation(pointX(location), pointY(location) - speed);
	}
	default void moveDown(JPanel panel, int speed) {
		Point location = panel.getLocation();
		panel.setLocation(pointX(location), pointY(location) + speed);
	}
	default void moveLeft(JPanel panel, int speed) {
		Point location = panel.getLocation();
		panel.setLocation(pointX(location) - speed, pointY(location));
	}
	default void moveRight(JPanel panel, int speed) {
		Point location = panel.getLocation();
		panel.setLocation(pointX(location) + speed, pointY(location));
	}
	static int pointX(Point location) {
		return (int) Math.round(location.getX());		
	}
	static int pointY(Point location) {
		return (int) Math.round(location.getY());		
	}
}
