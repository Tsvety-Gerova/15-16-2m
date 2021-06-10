import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class MazeSolver {

	// 0 = wall
	// 1 = path
	// 2 = destination

	public static boolean solveMaze(Maze m) {
		Position p = m.start;// first position
		m.path.push(p);// we ad it to the stack

		while (true) {// infinite
			int y = m.path.peek().y;//we find x and y of the previous step 
			int x = m.path.peek().x;

			// we make it 3 so that it is not valid anymore 
			if (m.maze[y][x] != 0) { //we already know that we can't go at 0 
									// but with this step makes sure that we don't start from 0; 
			m.maze[y][x] = 3; // marking the positions I have already been on with zero, so we avoid going in
			}					// circles

			// down
			// we check if the next number is valid 
			if (isValid(y + 1, x, m)) {
				if (m.maze[y + 1][x] == 2) { // we go down so y += 1;
					System.out.println("Moved down");// we have reached the end of the maze
					return true; // the game is over 
				} else if (m.maze[y + 1][x] == 1) { // if not then we keep going
					System.out.println("Moved down");
					m.path.push(new Position(y + 1, x)); // we add the previous position to the stack 
					continue;
				}
			}

			// left
			if (isValid(y, x - 1, m)) {
				if (m.maze[y][x - 1] == 2) {
					System.out.println("Moved left");
					return true;
				} else if (m.maze[y][x - 1] == 1) {
					System.out.println("Moved left");
					m.path.push(new Position(y, x - 1));
					continue;// we go back to the top of the loop without going through the rest of it
				}
			}

			// up
			if (isValid(y - 1, x, m)) {
				if (m.maze[y - 1][x] == 2) {
					System.out.println("Moved up");
					return true;
				} else if (m.maze[y - 1][x] == 1) {
					System.out.println("Moved up");
					m.path.push(new Position(y - 1, x));
					continue;
				}
			}

			// right
			if (isValid(y, x + 1, m)) {
				if (m.maze[y][x + 1] == 2) {
					System.out.println("Moved right");
					return true;
				} else if (m.maze[y][x + 1] == 1) {
					System.out.println("Moved right");
					m.path.push(new Position(y, x + 1));
					continue;
				}
			}

			// if we get to this point there is no other option than to move back 
			m.path.pop(); // going back in case we have reached a dead end
			System.out.println("Moved back");
			if (m.path.size() <= 0) { // nowhere new to go
				return false;
			}
		}
	}
// y cannot be less than 0 and more than the number of columns
	// x cannot be less than 0 and more than the number of rows
	public static boolean isValid(int y, int x, Maze m) {
		if (y < 0 || y >= m.maze.length || x < 0 || x >= m.maze[y].length) {
			return false;
		}
		return true;
	}

}