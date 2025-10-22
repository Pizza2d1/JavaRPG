package worldBuilder;

import java.awt.EventQueue;
import java.awt.List;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import rpg.Constants;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.math.BigInteger;

public class WorldBuilder extends JFrame {

	static boolean test = false;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int WORLD_SIZE_X = 800;
	private int WORLD_SIZE_Y = 800;
	private int BLOCK_SIZE = 20;
	private int WIDTH = WORLD_SIZE_X / BLOCK_SIZE; // For indexing hashmap
	Map<Integer, JLabel> map = new HashMap<>();
	ImageIcon source = new ImageIcon(WorldBuilder.class.getResource("/rpg/sprites/source.png"));
	ImageIcon blue = new ImageIcon(WorldBuilder.class.getResource("/rpg/sprites/blue.png"));
	ImageIcon red = new ImageIcon(WorldBuilder.class.getResource("/rpg/sprites/red.png"));

	/**
	 * Launch the application.
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

	private String getMap() {
		StringBuilder output = new StringBuilder();
		int pos = 0;
		for (int y = 0; y < WORLD_SIZE_X; y += BLOCK_SIZE) {
			for (int x = 0; x < WORLD_SIZE_X; x += BLOCK_SIZE) {
				String penis = map.get(pos).getIcon().toString();
				File f = new File(penis);
				String penis2 = f.getName();
				output.append(String.format("%d_%d_%s", x, y, penis2));
				output.append(",");
				pos++;
			}
		}
		String outputstr = new StringBuilder(output).toString();
		outputstr = outputstr.substring(0, outputstr.length() - 1); // remove trailing comma
		return outputstr;
	}

	private JLabel backgroundPiece(JPanel panel, int x, int y) {
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(x, y, BLOCK_SIZE, BLOCK_SIZE);
		if (!test)
			lblNewLabel.setIcon(source); // Set default block
		panel.add(lblNewLabel);
		return lblNewLabel;
	}

	private int getIndex(int x, int y) {
		return (x + (y * WIDTH));
	}

	private int getX(int index) {
		return index % WIDTH;
	}

	private int getY(int index) {
		return (index - (index % WIDTH)) / WIDTH;
	}

	private void changeBlock(int x, int y) {
		JLabel block = map.get(getIndex(Math.floorDiv(x, BLOCK_SIZE), Math.floorDiv(y, BLOCK_SIZE)));

		if (block.getIcon().equals(source)) {
			block.setIcon(blue);
		} else if (block.getIcon().equals(blue)) {
			block.setIcon(red);
		} else if (block.getIcon().equals(red)) {
			block.setIcon(source);
		}

		System.out.println();
		System.out.println(getMap());

	}

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
