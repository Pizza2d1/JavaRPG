package rpg;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class RPG_App extends JFrame{

	// Declare Objects
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JLayeredPane layeredPane = new JLayeredPane();
	static JPanel player_panel = new JPanel();
	static JLabel player = new JLabel("");
	static JPanel background_panel = new JPanel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new RPG_App();
					frame.addKeyListener(new KeyAdapter() {
						public void keyPressed(KeyEvent e) {
							int keyCode = e.getKeyCode();
							Keybindings.action(keyCode, background_panel, player_panel);
						}
					});
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	public RPG_App() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 250, Constants.SCREEN_SIZE_X, Constants.SCREEN_SIZE_Y);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));

		contentPane.add(layeredPane);
		layeredPane.setLayout(null);

		new Background(layeredPane, background_panel);
		new Player(layeredPane, player_panel);
	}
}
