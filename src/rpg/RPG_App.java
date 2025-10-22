package rpg;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * @author Nathan Young
 */
public class RPG_App extends JFrame{
	
	// Load map (if exists)
	String map = "";
	
	// Declare Objects
	private static final long serialVersionUID = 1L; // For JFrame
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
							Keybindings.action(keyCode, background_panel, player_panel); // Put affected panels here
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

		// Initialize the panels with z layer values
		new Background(layeredPane, background_panel, 0, map);
		new Player(layeredPane, player_panel, 1, 0,0);
	}
	
	/*
	 * Methods go here (even if unused
	 */
	public static int getCurrentMilliseconds() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter Mformatter = DateTimeFormatter.ofPattern("mm");
		DateTimeFormatter Sformatter = DateTimeFormatter.ofPattern("ss");
		DateTimeFormatter mmformatter = DateTimeFormatter.ofPattern("SSS");
		String strMin = now.format(Mformatter);
		String strSec = now.format(Sformatter);
		String strMilli = now.format(mmformatter);
		int min = Integer.valueOf(strMin);
		int sec = Integer.valueOf(strSec);
		int milli = Integer.valueOf(strMilli);
		if (min == 0)
			min += 60;
		int time = ((min * 60 * 1000) + (sec * 1000) + milli);
		return time;
	}

	public static void sleepy(int milli) {
		try {
			// to sleep 10 seconds
			Thread.sleep(milli);
		} catch (InterruptedException epenis) {
			// recommended because catching InterruptedException clears interrupt flag
			Thread.currentThread().interrupt();
			// you probably want to quit if the thread is interrupted
			return;
		}
	}
}
