package worldBuilder;

import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.ImageIcon;

// TODO: Auto-generated Javadoc
/**
 * The Class WorldBuilder.
 */
public class WorldBuilder extends JFrame {

	/** The test. */
	static boolean test = false;

	/** The map key. */
	private int map_key = 1;

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The content pane. */
	private JPanel contentPane;

	/** The world size x. */
	private int WORLD_SIZE_X = 1600;

	/** The world size y. */
	private int WORLD_SIZE_Y = 1000;

	/** The block size. */
	private int BLOCK_SIZE = 20;

	/** The width. */
	private int WIDTH = WORLD_SIZE_X / BLOCK_SIZE; // For indexing hashmap

	/** The map. */
	Map<Integer, JLabel> map = new HashMap<>();

	/** The source. */
	ImageIcon source = new ImageIcon(WorldBuilder.class.getResource("/rpg/sprites/source.png"));

	/** The blue. */
	ImageIcon blue = new ImageIcon(WorldBuilder.class.getResource("/rpg/sprites/blue.png"));

	/** The red. */
	ImageIcon red = new ImageIcon(WorldBuilder.class.getResource("/rpg/sprites/red.png"));

	/** The sand. */
	ImageIcon sand = new ImageIcon(WorldBuilder.class.getResource("/rpg/sprites/sand.png"));

	/** The grass. */
	ImageIcon grass = new ImageIcon(WorldBuilder.class.getResource("/rpg/sprites/grass.png"));

	/**
	 * Launch the application.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorldBuilder frame = new WorldBuilder();
					frame.setVisible(true);
					if (test) {
						frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public WorldBuilder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, WORLD_SIZE_X, WORLD_SIZE_Y);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, WORLD_SIZE_X, WORLD_SIZE_Y);
		contentPane.add(panel);
		panel.setLayout(null);

		// Add blocks to frame and hashmap
		int index = 0;
		for (int y = 0; y < WORLD_SIZE_X; y += BLOCK_SIZE) {
			for (int x = 0; x < WORLD_SIZE_X; x += BLOCK_SIZE) {
				JLabel blockPanel = backgroundPiece(panel, x, y);
				map.put(index, blockPanel);
				System.out.println("Added block to index: " + index);
				index++;
			}
		}
		mouse(contentPane); // Init mouse detection
		// System.out.println(getMap());
	}

	/**
	 * Gets the map.
	 *
	 * @return the map
	 */
	private String getMap() {
		StringBuilder output = new StringBuilder();
		int pos = 0;
		for (int y = 0; y < WORLD_SIZE_X; y += BLOCK_SIZE) {
			for (int x = 0; x < WORLD_SIZE_X; x += BLOCK_SIZE) {
				String penis = map.get(pos).getIcon().toString();
				File f = new File(penis);
				String penis2 = f.getName();
				char IconID = 'S'; // default as source

				switch (penis2) {
				case "red.png":
					IconID = 'R';
					break;
				case "blue.png":
					IconID = 'B';
					break;
				case "source.png":
					IconID = 'S';
					break;
				case "sand.png":
					IconID = 'A';
					break;
				case "grass.png":
					IconID = 'G';
					break;
				}

				output.append(String.format("%d_%d_%s", x, y, IconID));
				output.append(",");
				pos++;
			}
		}
		String outputstr = new StringBuilder(output).toString();
		outputstr = outputstr.substring(0, outputstr.length() - 1); // remove trailing comma
		return outputstr;
	}

	/**
	 * Background piece.
	 *
	 * @param panel the panel
	 * @param x     the x
	 * @param y     the y
	 * @return the j label
	 */
	private JLabel backgroundPiece(JPanel panel, int x, int y) {
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(x, y, BLOCK_SIZE, BLOCK_SIZE);
		if (!test)
			lblNewLabel.setIcon(grass); // Set default block
		panel.add(lblNewLabel);
		return lblNewLabel;
	}

	/**
	 * Gets the index.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the index
	 */
	private int getIndex(int x, int y) {
		return (x + (y * WIDTH));
	}

	/**
	 * Gets the x.
	 *
	 * @param index the index
	 * @return the x
	 */
	private int getX(int index) {
		return index % WIDTH;
	}

	/**
	 * Gets the y.
	 *
	 * @param index the index
	 * @return the y
	 */
	private int getY(int index) {
		return (index - (index % WIDTH)) / WIDTH;
	}

	/**
	 * Change block.
	 *
	 * @param x the x
	 * @param y the y
	 */
	private void changeBlock(int x, int y) {
		JLabel block = map.get(getIndex(Math.floorDiv(x, BLOCK_SIZE), Math.floorDiv(y, BLOCK_SIZE)));

		if (block.getIcon().equals(source)) {
			block.setIcon(blue);
		} else if (block.getIcon().equals(blue)) {
			block.setIcon(red);
		} else if (block.getIcon().equals(red)) {
			block.setIcon(grass);
		} else if (block.getIcon().equals(grass)) {
			block.setIcon(sand);
		} else if (block.getIcon().equals(sand)) {
			block.setIcon(source);
		}

		// System.out.println();

		File file = new File(String.format("map_%d.txt", map_key));
		try {
			PrintWriter writer = new PrintWriter(file);
			writer.println(getMap());
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}

		// System.out.println(getMap());

	}

	/**
	 * Mouse.
	 *
	 * @param contentPane the content pane
	 */
	private void mouse(JPanel contentPane) {
		contentPane.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeBlock(e.getX(), e.getY());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}
}
