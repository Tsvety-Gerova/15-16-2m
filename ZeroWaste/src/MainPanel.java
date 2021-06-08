import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainPanel extends JFrame implements ActionListener {
	
// here we have the tasks as a check box list
// on the right side will be the completed tasks
	
	public MainPanel() {
	
	JFrame frame = new JFrame();
	
	JPanel toDoPanel = new JPanel ();// left panel keeps the to-do tasks
	JPanel donePanel = new JPanel ();// left panel keeps the completed tasks
	toDoPanel.setBorder(BorderFactory.createEmptyBorder());
	toDoPanel.setLayout(new BoxLayout(toDoPanel, BoxLayout.Y_AXIS));
	donePanel.setBorder(BorderFactory.createEmptyBorder());
	donePanel.setLayout(new BoxLayout(donePanel, BoxLayout.Y_AXIS));
	
	
	
	frame.add(toDoPanel, BorderLayout.CENTER); // add panel to the frame
	frame.add(donePanel, BorderLayout.CENTER);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setTitle("Main Panel");
	frame.pack(); 
	frame.setVisible(true); 

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
