import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UITest {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Test UI");
		JPanel panel = new JPanel();
		JButton button = new JButton("submit");
		
		panel.add(button);
		
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
	}
}
