import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
public class Robot {
	public static void compile(URL iurl) throws IOException{
		URL rbt = new URL(iurl + "robots.txt");
		BufferedReader in;
		in = new BufferedReader(new InputStreamReader(rbt.openStream()));
		String htmlLine;
		StringBuilder massive = new StringBuilder();
		while ((htmlLine = in.readLine()) != null) {
			massive.append(htmlLine);
		}
		in.close();
		String massiveString = massive.toString();
		
	}
	
	public static void isRobot(){
		
	}
}
