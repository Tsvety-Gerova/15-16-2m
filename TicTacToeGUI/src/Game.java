import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game extends JFrame implements ActionListener {

	JLabel result = new JLabel(" "); // will play the result of the game 
	boolean isFilled = false; // checks if all of the fields are filled - the game has ended
	JButton startGame = new JButton("Start Game");
	JButton clearScores = new JButton("Clear scores"); // will set the scores of x and o to 0;
	
	int currentMove = 1; // keeps track of the players' turns
					// x will go on every even number
					// o will go on every odd number
					// x always go first 
					//when it reaches 9 the game is over because all of the boxes are filled
	 
	JLabel xScoreLabel = new JLabel();
	JLabel oScoreLabel = new JLabel();
	int xScore = 0;
	int oScore = 0;  
	
	public Game () {
		
		JFrame frame = new JFrame();
		
		JPanel panel = new JPanel ();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // arranges the elements vertically
		
		xScoreLabel = new JLabel(Integer.toString(xScore));
		oScoreLabel = new JLabel(Integer.toString(oScore));
		
		JButton board[][] = new JButton[3][3]; // the field will consist of five buttons	
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j ++) {
				board[i][j] = new JButton(); // creating every button
				board[i][j].setText("-"); 
				panel.add(board[i][j]);
				board[i][j].addActionListener(this); 

			}
	 	}
		
		frame.add(panel, BorderLayout.CENTER); // add panel to the frame
//		panel.add(boardPanels[0], BorderLayout.CENTER); // add panel to the frame
//		panel.add(boardPanels[1], BorderLayout.CENTER); // add panel to the frame
//		panel.add(boardPanels[2], BorderLayout.CENTER); // add panel to the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tic Tac Toe");
		frame.pack(); // set the window to match a certain size
		frame.setVisible(true); // set the window to be visible
		
	}
	
	public static void main(String[] args) {

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
