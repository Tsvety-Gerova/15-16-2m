
import java.awt.*;

import javax.swing.JFrame;

public class MazeApp { 
	public static void main(String[] args) { 
		JFrame frame = new JFrame();
		frame.setSize(400, 400);
		frame.add(new MazeControll());
		frame.setTitle("Maze");
		frame.setLocationRelativeTo(null); 
		// Center the frame 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setVisible(true);
		
	}
}
