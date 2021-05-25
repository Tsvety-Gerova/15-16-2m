import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToe extends JFrame implements ActionListener{
	
	JLabel whoIsOnTurn = new JLabel("X is on turn"); // shows which player's turn it is
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
	
	
	
	JButton fieldButtons[][] = new JButton[3][3]; // the field will consist of five buttons	
	   
	public TicTacToe() {
		
		JFrame frame = new JFrame();
		
		JPanel panel = new JPanel ();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // arranges the elements vertically
		
		JPanel[] boardPanels = new JPanel[3];// the rows
		boardPanels[0] = new JPanel();
		boardPanels[1] = new JPanel();
		boardPanels[2] = new JPanel();

		
		// adding the elements to the panels
		
		//panel.add(startGame, BorderLayout.CENTER);
		panel.add(whoIsOnTurn, BorderLayout.CENTER); 

		// adding the buttons of the field to the panel 
	 	
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j ++) {
				fieldButtons[i][j] = new JButton(); // creating every button
                fieldButtons[i][j].setText("-"); 
				boardPanels[i].add(fieldButtons[i][j]);
                fieldButtons[i][j].addActionListener(this); 

			}
	 	}
	 	
		panel.add(result);
		
		// setting the text of the label so that it matches the current score of each player
		xScoreLabel = new JLabel(Integer.toString(xScore));
		oScoreLabel = new JLabel(Integer.toString(oScore));
		
		
		//startGame.addActionListener(this);
		//clearScores.addActionListener(this);
		
		frame.add(panel, BorderLayout.CENTER); // add panel to the frame
		panel.add(boardPanels[0], BorderLayout.CENTER); // add panel to the frame
		panel.add(boardPanels[1], BorderLayout.CENTER); // add panel to the frame
		panel.add(boardPanels[2], BorderLayout.CENTER); // add panel to the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tic Tac Toe");
		frame.pack(); // set the window to match a certain size
		frame.setVisible(true); // set the window to be visible
		
	}

	
	
	public static void main(String[] args) {
           new TicTacToe();
	}


      // the button "Start Game" is clicked 
	@Override
	public void actionPerformed(ActionEvent e) {
			
		
		for (int i = 0; i < 3; i++) {
             for(int j = 0; j < 3; j++) {
            	 if (e.getSource().equals(fieldButtons[i][j]) && fieldButtons[i][j].getText() != "-") {
			currentMove++;
					if (currentMove % 2 == 1) { // if it is an odd number (1,3,5...) it is X's turn
				whoIsOnTurn.setName("X is on turn");
				fieldButtons[i][j].setName("O");
		}   else if (currentMove % 2 == 0) {
			whoIsOnTurn.setName("O is on turn"); // on even numbers it is O's turn 
			fieldButtons[i][j].setName("X");

		} 
//		
             }
		 }
             
		 }

	
	
		boolean haveWinner = false; 
		
		for (int n = 0; n < 3; n++) {
			
			int m = 0;
				if ((fieldButtons[n][m] == fieldButtons[n][m + 1] && fieldButtons[n][m + 1] == fieldButtons[n][m + 2]) ||
					(fieldButtons[m][n] == fieldButtons[m + 1][n] && fieldButtons[m + 1][n] == fieldButtons[m + 2][n])) {
						haveWinner = true;
						if (fieldButtons[n][m].getName() == "X") {
							result.setName("The winner is X"); // the label result shows who the player is
							xScore++;
						} else {
							result.setName("The winner is O"); // the label result shows who the player is
							oScore++;
						} 
						
						break;
					}
		}
		   int n = 0;
		   int m = 0; 
		   
		   if ( !haveWinner && 
				(fieldButtons[n][m] == fieldButtons[m + 1][n + 1] && fieldButtons[m + 1][n + 1] == fieldButtons[m + 2][n + 2]) ||
				(fieldButtons[n][m + 2] == fieldButtons[m + 1][n + 1] && fieldButtons[m + 1][n + 1] == fieldButtons[m][n + 2])) {
			  	
					    haveWinner = true;
					    if (fieldButtons[n][m].getName() == "X") {
							result.setName("The winner is X"); // the label result shows who the player is
							xScore++; // increasing the score of the winner 
						} else {
							result.setName("The winner is O"); // the label result shows who the player is
							oScore++;
						} 					    
		} 
		
		   if ( !haveWinner ) {
			   result.setName("Tie!"); // there is no winner
		   }
	}


  public static void ClickedButton(JButton buttons[][], int move) {
	  
	  for (int i = 0; i < 3; i++) {
          for(int j = 0; j < 3; j++) {
         	 if (e.getSource().equals(buttons[i][j]) && buttons[i][j].getText() != "-") {
			move++;
					if (move % 2 == 1) { // if it is an odd number (1,3,5...) it is X's turn
				
						buttons[i][j].setName("O");
		}   else if (move % 2 == 0) {
			 // on even numbers it is O's turn 
			buttons[i][j].setName("X");

		} 
//		
          }
		 }
  } 
	

