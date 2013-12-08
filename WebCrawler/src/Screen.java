import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import net.miginfocom.swing.MigLayout;

public class Screen {

	public static int MAXCHAR = 10;
	public static URL z = null; 
	private static String URLstring = "";
	JPanel contentPane;
	JPanel inputPane;
	static Timer time;
	static int progress;
	static JProgressBar jPB;
	static JLabel prog;
	private JTextField inputTextField;
	private JTextArea wordFrequencyTextArea;
	private static JFrame frame;
	private  static int LINKSCRAWLED = 2;
	private static ArrayList<Website> webBox;
	/**
	 * creates a input box and a enter button
	 * @throws IOException
	 */
	public void createCards() throws IOException {
		JPanel inputPanel = new JPanel();
		inputTextField = new JTextField();
		inputTextField.setFont(new Font("Serif", Font.ITALIC, 16));
		inputTextField.setColumns(20);
		inputPanel.add(inputTextField);

		JButton enter = new JButton("enter");
		SubmitButtonActionListener v = new SubmitButtonActionListener(this.inputTextField, this);
		enter.addActionListener(v);
		inputPanel.add(enter);
		

		
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(0, 1));
		//MigLayout migOut = new MigLayout("wrap 5");
		//migLay.setLayout(migOut);
		contentPane.add(inputPanel);
		
		
		try{
		}
		catch(Exception e){
			createErrorLabel(e.getMessage());
		}

		// create main pane
		
		
		frame.setContentPane(contentPane);
	}

	public static void main(String[] args) throws Exception {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();
		} catch (InstantiationException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					setUp();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		});

	}
	/**
	 * creates the frame and the components
	 * @throws IOException
	 */
	public static void setUp() throws IOException {
		frame = new JFrame("WebCrawler");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Screen scr = new Screen();
		scr.createCards();
		frame.pack();
		frame.setVisible(true);
	}

	
	/**
	 * takes a string and updates the global url
	 * @param url the url in string form
	 * @throws MalformedURLException
	 */
	public static void setURL(String url) throws MalformedURLException {	
		URLstring = url;
		z = new URL(URLstring);
			
	}
	/**
	 * creates a new buffer reader 
	 * @return buffer reafer
	 * @throws IOException
	 */

	/** 
	 * creates an error label
	 * @param the error message you would like to display
	 */
	public void createErrorLabel(String e){
		JLabel x = new JLabel(e);
		contentPane.add(x);
	}
	/**
	 * Displays the text box with the counted words
	 * @throws IOException 
	 */
	public void action() throws IOException{
		prog = new JLabel("0");
		contentPane = new JPanel();
		jPB = new JProgressBar(0,LINKSCRAWLED);
		jPB.setValue(0);
		jPB.setStringPainted(true);
		contentPane.add(jPB);
		contentPane.add(prog);
		frame.setContentPane(contentPane);
		frame.pack();
		Crawl();
		System.out.print("made it");
	}
	public void display() {
		inputPane = new JPanel();
		inputTextField = new JTextField();
		inputTextField.setFont(new Font("Serif", Font.ITALIC, 16));
		inputTextField.setColumns(20);
		inputPane.add(inputTextField);

		JButton enter = new JButton("enter");
		CombButtonActionListener v = new CombButtonActionListener(this.inputTextField, this);
		enter.addActionListener(v);
		inputPane.add(enter);
		contentPane = new JPanel();
		contentPane.add(inputPane);
		frame.setContentPane(contentPane);
	}
	public static  void Crawl() throws IOException{
		webBox = new ArrayList();
		Website x = new Website(z);
		x.compile();
		webBox.add(x);
		update();
		if (Children.amountOfChildren() < 30){
			LINKSCRAWLED = Children.amountOfChildren(); 	
		}
		time = new Timer();
		for (int i = 1; i < LINKSCRAWLED; i++) {
			time.schedule(new CrawlTask(), i*5000);
		}
				
		
		
	}
	public static void subcrawl() throws IOException{
		Website n = new Website(Children.getChild());
		n.compile();
		webBox.add(n);
	}
	public static void update(){
		progress++;
		prog.setText(Integer.toString(progress));
		jPB.setValue(progress);
		frame.pack();
		System.out.println(progress + " ");
		if (progress > LINKSCRAWLED -1){
			new Screen().display();
			frame.pack();
		}
	}

	public void reply(String keyword) {
		String occur = "";
		for (int i = 0; i < webBox.size(); i++)	{
			Website net = webBox.get(i);
			occur += (net.getWebsite() + " " + net.occurrence(keyword) + "\n");
		}
		contentPane = new JPanel();
		wordFrequencyTextArea = new JTextArea(occur);
		wordFrequencyTextArea.setFont(new Font("Serif", Font.ITALIC, 16));
		wordFrequencyTextArea.setLineWrap(true);
		wordFrequencyTextArea.setWrapStyleWord(true);
		JScrollPane textAreaScrollPane = new JScrollPane(wordFrequencyTextArea);
		textAreaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		textAreaScrollPane.setPreferredSize(new Dimension(400, 600));
		contentPane.add(textAreaScrollPane);
		JPanel fullPane = new JPanel();
		
		MigLayout migOut = new MigLayout("wrap 2");
		fullPane.setLayout(migOut);
		//display();
		fullPane.add(inputPane,"wrap");
		fullPane.add(contentPane);
		
		frame.setContentPane(fullPane);
		frame.pack();
		
	}
	

	
}
