import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class TestPanel extends JFrame implements ActionListener {

		public TestPanel() {
		
		JFrame frame = new JFrame();
		
		JPanel testPanel = new JPanel ();// shows the test 
		testPanel.setBorder(BorderFactory.createEmptyBorder());
		testPanel.setLayout(new BoxLayout(testPanel, BoxLayout.Y_AXIS));		
		
		JScrollBar scrollBar = new JScrollBar();
		testPanel.add(scrollBar);
		JButton resultButton = new JButton("Results"); // shows the results after the test is completed
		testPanel.add(resultButton);
		
		frame.add(testPanel, BorderLayout.CENTER); // add panel to the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Main Panel");
		frame.pack(); // set the window to match a certain size
		frame.setVisible(true); // set the window to be visible

		}
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub

		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}

	}

