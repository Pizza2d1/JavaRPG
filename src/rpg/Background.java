package rpg;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class Background.
 */
public class Background implements Movable {

	// public Background(JLayeredPane layeredPane, JPanel background_panel, int
	// z_layer) {
	// background_panel.setBounds(0, 0, Constants.SCREEN_SIZE_X,
	// Constants.SCREEN_SIZE_Y);
	// layeredPane.setLayer(background_panel, z_layer);
	// layeredPane.add(background_panel);
	// background_panel.setLayout(null);

	// for (int i = -40; i < Constants.SCREEN_SIZE_X + 40; i += 20) {
	// for (int j = -40; j < Constants.SCREEN_SIZE_Y + 40; j += 20) {
	// backgroundPiece(background_panel, i, j, Constants.backgroundsrc);
	// }
	// }
	// }

	boolean test = false;

	/**
	 * Instantiates a new background.
	 *
	 * @param layeredPane      the layered pane
	 * @param background_panel the background panel
	 * @param z_layer          the z layer
	 * @param map              the map
	 */
	public Background(JLayeredPane layeredPane, JPanel background_panel, int z_layer, String map) {
		if (test) {
			background_panel.setBounds((Constants.SCREEN_SIZE_X - Constants.WORLD_SIZE_X) / 2,
					(Constants.SCREEN_SIZE_X - Constants.WORLD_SIZE_Y) / 2, Constants.WORLD_SIZE_X,
					Constants.WORLD_SIZE_Y);
		} else {
			background_panel.setBounds(0, 0, Constants.WORLD_SIZE_X, Constants.WORLD_SIZE_Y);
		}
		layeredPane.setLayer(background_panel, z_layer);
		layeredPane.add(background_panel);
		background_panel.setLayout(null);

		if (map != "") {
			String[] parts;
			parts = map.split(",");
			for (String part : parts) {
				String[] part2s = part.split("_");

				System.out.println("X: " + part2s[0]);
				System.out.println("Y: " + part2s[1]);
				// System.out.println("Icon: " + part2s[2]);
				int x = Integer.valueOf(part2s[0]);
				int y = Integer.valueOf(part2s[1]);
				String iconID = part2s[2];

				Icon BGIcon;
				switch (iconID) {
				case "B":
					BGIcon = Constants.blue;
					break;
				case "R":
					BGIcon = Constants.red;
					break;
				case "S":
					BGIcon = Constants.backgroundsrc;
					break;
				case "A":
					BGIcon = Constants.sand;
					break;
				case "G":
					BGIcon = Constants.grass;
					break;
				default:
					BGIcon = Constants.backgroundsrc;
					break;
				}

				backgroundPiece(background_panel, x, y, BGIcon);
			}
		} else {
			for (int i = 0; i < Constants.WORLD_SIZE_X; i += Constants.BLOCK_SIZE) {
				for (int j = 0; j < Constants.WORLD_SIZE_Y; j += Constants.BLOCK_SIZE) {
					backgroundPiece(background_panel, i, j, Constants.backgroundsrc);
				}
			}
		}
	}

	/**
	 * Background block that is rendered.
	 *
	 * @param panel the panel
	 * @param x     the x
	 * @param y     the y
	 * @param icon  the icon
	 */
	private void backgroundPiece(JPanel panel, int x, int y, Icon icon) {
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(x, y, 20, 20);
		lblNewLabel.setIcon(icon);
		panel.add(lblNewLabel);
	}

}
