package rpg;

import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * The Interface Actions.
 */
public interface Actions {
	
	// General movement
	/**
	 * Move up.
	 *
	 * @param panel the panel
	 */
	void moveUp(JPanel panel);
	
	/**
	 * Move down.
	 *
	 * @param panel the panel
	 */
	void moveDown(JPanel panel);
	
	/**
	 * Move left.
	 *
	 * @param panel the panel
	 */
	void moveLeft(JPanel panel);
	
	/**
	 * Move right.
	 *
	 * @param panel the panel
	 */
	void moveRight(JPanel panel);
}
