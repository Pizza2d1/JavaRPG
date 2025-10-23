package rpg;

import javax.swing.JPanel;

public interface Actions {
	
	// We aren't using this for now until we can make sure this ACTUALLY makes code easier to use
	
	// General movement
	void moveUp(JPanel panel);
	void moveDown(JPanel panel);
	void moveLeft(JPanel panel);
	void moveRight(JPanel panel);
}
