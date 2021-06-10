
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Maze {
	public int[][] maze;// creates the maze table
	public Stack<Position> path = new Stack<Position>(); // allows us to move backwards 
	public Position start;// keeps the first step

	public Maze(String filePath) throws FileNotFoundException {

		Scanner in = new Scanner(new File(filePath));
		int rows = Integer.parseInt(in.nextLine()); // only the rows are created 
		this.maze = new int[rows][]; // for each row we will create the elements later 

		for (int i = 0; i < rows; i++) {
			String line = in.nextLine();// read the new row every time 
			String[] numbers = line.split(", ");// we separate the numbers to find the number of columns
			this.maze[i] = new int[numbers.length];// for every row we create an array that has the length of the string 
			for (int j = 0; j < numbers.length; j++) {
				// we turn the numbers from string to int
				this.maze[i][j] = Integer.parseInt(numbers[j]);//we save the number on each position
			}
		}
// we create the start position 
		this.start = new Position(Integer.parseInt(in.nextLine()), Integer.parseInt(in.nextLine()));
	}
}