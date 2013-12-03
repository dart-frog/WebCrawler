import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.JTextArea;
import javax.swing.JTextField;


public class CombButtonActionListener implements ActionListener{
	
	private JTextField inputText;
	private Screen scr;
	
	public CombButtonActionListener(JTextField inputText, Screen scr)
	{
		this.inputText = inputText;
		this.scr = scr;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		scr.reply();
	}
}