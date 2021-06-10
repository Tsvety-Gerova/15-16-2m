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
    boolean isFilled = false; // checks if all of the fields are filled - the
                                // game has ended
    JButton startGame = new JButton("Start Game");
    JButton playAgain = new JButton("Play Again"); // will set the scores of
                                                        // x and o to 0;
    int currentMove = 0; // keeps track of the players' turns
    // x will go on every even number
    // o will go on every odd number
    // x always go first
    // when it reaches 9 the game is over because all of the boxes are filled
    JLabel xScoreLabel = new JLabel();
    JLabel oScoreLabel = new JLabel();
    int xScore = 0;
    int oScore = 0;
    int currentI = -1, currentJ = -1; // indexes of the clicked button
    JButton board[][] = new JButton[3][3]; // the board will consist of nine
                                            // buttons
    public Game() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // arranges the
                                                                    // elements
                                                                    // vertically
//        xScoreLabel = new JLabel(Integer.toString(xScore));
//        oScoreLabel = new JLabel(Integer.toString(oScore));
        JPanel boardPanels[] = new JPanel[3];
        for (int i = 0; i < 3; i++) {
            boardPanels[i] = new JPanel();
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = new JButton(); // creating every button
                board[i][j].setText("-");
                boardPanels[i].add(board[i][j]); // for example we are adding
                                                    // buttons [0][0], [0][1],
                                                    // [0][2] to board panel [0]
                board[i][j].addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton currentButton = (JButton) e.getSource();
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                if (currentButton.equals(board[i][j])) {
                                    currentI = i;
                                    currentJ = j;
                                    if (board[currentI][currentJ].getText().equals("-")) {
                                        currentMove++;
                                        if (currentMove % 2 == 1) {
                                            board[currentI][currentJ].setText("X"); // therefore
                                                                                    // X
                                                                                    // starts
                                                                                    // each
                                                                                    // game
                                        } else { // when the
                                                    // current count
                                                    // is an even
                                                    // number O is
                                                    // on turn
                                            board[currentI][currentJ].setText("O");
                                        }
                                    }
                                }
                            }
                        }
                        checkResults();
                    } 
                });
            }
        }
        for (int i = 0; i < 3; i++) {
            panel.add(boardPanels[i]); // adding the board panels (which
                                        // represent the rows)
        }
        //panel.add(playAgain);
        //panel.add(xScoreLabel);
        //panel.add(oScoreLabel);
        panel.add(result);
        frame.add(panel, BorderLayout.CENTER); // add panel to the frame
      
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tic Tac Toe");
        frame.pack(); // set the window to match a certain size
        frame.setVisible(true); // set the window to be visible
    }
    public static void main(String[] args) {
        new Game();
    }
    public JButton[][] getXY(JButton[][] board[][]) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                currentI = i;
                currentJ = j;
            }
        }
        return board[currentI][currentJ];
    }
    
    // // check results and find out whether there is a winner
    
   
    int outcome  = -2; 
    public int checkResults() {
       
        // tie = -1
        // x wins = 0
        // o wins = 1
        // check the rows and the columns
        for (int n = 0; n < 3; n++) {
            int m = 0;
            if ( (  board[n][m].getText().equals(board[n][m + 1].getText())
                    && board[n][m + 1].getText().equals(board[n][m + 2].getText()))
                    || (board[m][n].getText().equals(board[m + 1][n].getText()) 
                    && board[m + 1][n].getText().equals(board[m + 2][n].getText()) ) ) {
 
                if (board[n][m].getText().equals("X") || board[m][n].getText().equals("X")) {
                	
                	outcome = 0; // x wins
                break;    
                } else {
                	
                	outcome = 1; // 0 wins if outcome = 1

                }
                
                break;
                
            } else {
            	outcome = -1; // there is no winner 
            } 
            break;
        }
        
        // check the diagonals
        int n = 0;
        int m = 0;
        if ((board[n][m].getText().equals(board[m + 1][n + 1].getText()) 
        		&& board[m + 1][n + 1].getText().equals(board[m + 2][n + 2].getText()))
                || (board[n][m + 2].getText().equals(board[m + 1][n + 1].getText()) 
                && board[m + 1][n + 1].getText().equals(board[m][n + 2].getText()))) {
        	
            if (board[n + 1][m + 1].getText().equals("X")) {
            	outcome = 0;
            } else if (board[n + 1][m + 1].getText().equals("O")){
            	outcome = 1;           
            }
            
            }  else {
        	outcome = -1; // tie
        } 
    
        

    if (outcome == 0) {
    	result.setText("X wins");
    } else if (outcome == 1) {
    	result.setText("O wins");
//    	xScore++;
//      xScoreLabel.setText(Integer.toString(xScore));
    } else {
    	result.setText("Tie");
    	//oScore++;
        //oScoreLabel.setText(Integer.toString(oScore));
    }
	return outcome;
    }   	
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	
    }
    
}