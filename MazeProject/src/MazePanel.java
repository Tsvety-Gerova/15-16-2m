
import java.awt.Color;
import java.awt.Graphics;
import java.io.FileNotFoundException;

import javax.swing.JPanel;

class MazePanel extends JPanel {
	
// displayPath will show whether the exit of the maze is visible or not
	boolean displayPath = false;
	
	Maze m;
	int margin = 3;
	
    // in this constructor we will find the path from one point to another
	// when we load one maze we will know immediately where the exit is
	// here is where the path is being calculated
	public MazePanel() {	
			
		try {
				m = new Maze ("src/mazes.txt"); // maze is loading as a file 

				//we print the maze before and after the changes to see how the program is working 
				// print maze before 
				for(int i = 0; i < m.maze.length; i++) { 
					for(int j = 0; j < m.maze[i].length; j++ ) { 
						System.out.print(m.maze[i][j]);
					}		
					System.out.println();
				} 

				if (MazeSolver.solveMaze (m)) {
					System.out.println("You won!");
				} else { 
					System.out.println("No path");
				}
				
				// print maze after 
				for(int i = 0; i < m.maze.length; i++) { 
					for(int j = 0; j < m.maze[i].length; j++ ) { 
						System.out.print(m.maze[i][j]); 
					}
					System.out.println();
					} 
						
			} catch (FileNotFoundException e) { 
						// TODO Auto-generated catch block 
						e.printStackTrace(); }
				}
	
	// the two methods findPath and cleanPath will only control the visual side
	// they do not calculate the path 
	// we don't need them to calculate it every time when we use the method
		
	public void findPath() {
		displayPath = true;
		repaint();
	}

	public void cleanPath() {
		displayPath = false;
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//draws a rectangle at coordinates 0 and 0 with height and width 10
		// all 0s are white squares
		// all 1s are plain white squares
		// the path is represented by black squares	
		
		int width = getWidth() / m.maze[0].length - margin; // -2 - for space 
		int height = getHeight() / m.maze.length - margin; // now we want the number of rows
		g.setColor(Color.WHITE);
		for (int i = 0; i < m.maze.length; i++) {// x is controlled by j; y - by i
			for (int j = 0; j < m.maze[i].length; j++) {
				if (m.maze[i][j] == 1) {
				g.fillRect(margin + j * (width + margin), margin + i * (height * margin), width, height);  
			}else if (m.maze[i][j] == 2){
				g.setColor(Color.RED);// we will set the target square (the exit) to be red
				g.fillRect(margin + j * (width + margin), margin + i * (height * margin), width, height); 
				g.setColor(Color.WHITE); // and then return it to white  
			}
			}
		}

		// System.out.print(m.maze[i][j]);.
		if (displayPath) {
		g.setColor(Color.BLACK);
		for (Position p : m.path) {// path keeps all steps from the entry to the exit
			// the black squares represent the path 
			// x and y keep the coordinates (row and column) of the square
			// x keeps track of the moves to the right
			// y keeps track of the moves downwards
			// for each position we draw a black square
			// the squares of the path are kept in a stack 
				g.fillRect(margin + p.x * (width + margin), margin + p.y * (height * margin), width, height);  
			}
		}
		
	}
}
