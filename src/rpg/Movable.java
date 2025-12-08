package rpg;

import java.awt.Point;

import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * The Interface Movable.
 */
public interface Movable {

	/**
	 * Move up.
	 *
	 * @param panel the panel
	 * @param speed the speed
	 */
	default void moveUp(JPanel panel, int speed) {
		Point location = panel.getLocation();
		panel.setLocation(pointX(location), pointY(location) - speed);
	}
	
	/**
	 * Move down.
	 *
	 * @param panel the panel
	 * @param speed the speed
	 */
	default void moveDown(JPanel panel, int speed) {
		Point location = panel.getLocation();
		panel.setLocation(pointX(location), pointY(location) + speed);
	}
	
	/**
	 * Move left.
	 *
	 * @param panel the panel
	 * @param speed the speed
	 */
	default void moveLeft(JPanel panel, int speed) {
		Point location = panel.getLocation();
		panel.setLocation(pointX(location) - speed, pointY(location));
	}
	
	/**
	 * Move right.
	 *
	 * @param panel the panel
	 * @param speed the speed
	 */
	default void moveRight(JPanel panel, int speed) {
		Point location = panel.getLocation();
		panel.setLocation(pointX(location) + speed, pointY(location));
	}
	
	/**
	 * Point X.
	 *
	 * @param location the location
	 * @return the int
	 */
	static int pointX(Point location) {
		return (int) Math.round(location.getX());		
	}
	
	/**
	 * Point Y.
	 *
	 * @param location the location
	 * @return the int
	 */
	static int pointY(Point location) {
		return (int) Math.round(location.getY());		
	}
}
