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
	
	int currentMove = 0; // keeps track of the players' turns
					// x will go on every even number
					// o will go on every odd number
					// x always go first 
					//when it reaches 9 the game is over because all of the boxes are filled
	 
	JLabel xScoreLabel = new JLabel();
	JLabel oScoreLabel = new JLabel();
	int xScore = 0;
	int oScore = 0;  
	
	
	int currentI = 0, currentJ = 0; // indexes of the clicked button
	JButton board[][] = new JButton[3][3]; // the board will consist of nine buttons
		
	
		
	public Game () {
		
		JFrame frame = new JFrame();
		
		JPanel panel = new JPanel ();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // arranges the elements vertically
		
		xScoreLabel = new JLabel(Integer.toString(xScore));
		oScoreLabel = new JLabel(Integer.toString(oScore));
		
		JPanel boardPanels[] = new JPanel[3]; 
		for (int i = 0; i < 3; i ++) {
			boardPanels[i] = new JPanel();
		} 
		
			
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j ++) {
				
				board[i][j] = new JButton(); // creating every button
				board[i][j].setText("-"); 
				boardPanels[i].add(board[i][j]); // for example we are adding buttons [0][0], [0][1], [0][2] to board panel [0]
				board[i][j].addActionListener(
					
						new ActionListener() {
					
					@Override
	public void actionPerformed(ActionEvent e) {
				
				JButton currentButton = (JButton) e.getSource();
						
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j ++) {
				if (e.getSource().equals(board[i][j]) && board[currentI][currentJ].getText().equals("-")) {
					currentMove++;
					board[currentI][currentJ] = currentButton; // the clicked button is the one to perform
					if(currentMove % 2 == 1) { // when the current count is an odd number X is on turn 
						board[currentI][currentJ].setText("X"); // therefore X starts each game
		            }
		            if(currentMove % 2 == 0) { // when the current count is an even number O is on turn 
		            	board[currentI][currentJ].setText("O");
		            }
		        }   
				}
			 	}
		
	} 
					
				}); 

			}
	 	}
		
			
		
		for (int i = 0; i < 3; i ++) {
			panel.add(boardPanels[i]); // adding the board panels (which represent the rows) 
		}
		
		panel.add(clearScores);
		panel.add(xScoreLabel);
		panel.add(oScoreLabel);
		
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
			 new Game();
	}

	
	
	public JButton[][] getXY (JButton[][] board[][]) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j ++) {
				currentI = i;
				currentJ = j;
			}
		}
		return board[currentI][currentJ];
		
	}
	
	
		
//		// check results and find out whether there is a winner 
//		boolean haveWinner = false; 
//		 
//		// check the rows and the columns 
//		for (int n = 0; n < 3; n++) {
//			
//			int m = 0;
//				if ((board[n][m] == board[n][m + 1] && board[n][m + 1] == board[n][m + 2]) ||
//					(board[m][n] == board[m + 1][n] && board[m + 1][n] == board[m + 2][n])) {
//						haveWinner = true;
//						if (board[n][m].toString() == "X") {
//							result.setName("The winner is X"); // the label result shows who the player is
//							xScore++;
//						} else {
//							result.setName("The winner is O"); // the label result shows who the player is
//							oScore++;
//						} 
//						
//						break;
//					}
//		} 
//		// check the diagonals 
//		   int n = 0;
//		   int m = 0; 
//		   
//		   if ( !haveWinner && 
//				(board[n][m] == board[m + 1][n + 1] && board[m + 1][n + 1] == board[m + 2][n + 2]) ||
//				(board[n][m + 2] == board[m + 1][n + 1] && board[m + 1][n + 1] == board[m][n + 2])) {
//			  	
//					    haveWinner = true;
//					    if (board[n][m].toString() == "X") {
//							result.setName("The winner is X"); // the label result shows who the player is
//							xScore++; // increasing the score of the winner 
//						} else {
//							result.setName("The winner is O"); // the label result shows who the player is
//							oScore++;
//						} 					    
//		} 
//		
//		   if ( !haveWinner ) {
//			   result.setName("Tie!"); // there is no winner
//		   } 
//		
//		

 
	
	@Override
	public void actionPerformed(ActionEvent e) {
        		
	}

	} 



		

