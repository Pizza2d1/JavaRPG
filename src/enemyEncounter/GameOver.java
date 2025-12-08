package enemyEncounter;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class GameOver extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public GameOver() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(200, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		JLabel gameOver = newGameOver();
		
		contentPane.add(gameOver);
		setContentPane(contentPane);

	}
	/**
	 * Creates the Game Over label
	 * @return
	 */
	private JLabel newGameOver() {
		JLabel gameOver = new JLabel("Game Over");
		gameOver.setBounds(112, 100, 215, 41);
		gameOver.setFont(new Font("Stencil", Font.PLAIN, 40));
		return gameOver;
	}

}
