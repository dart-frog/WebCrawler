import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Robot {
	ArrayList<String> ban;
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
		String x = massive.toString();
		for (int i = 0; i < x.length(); i++){
			if (x.substring(i, i + 10) == "Disallow: "){
					
					}
			}
	}
	
	public static void isRobot(){
		
	}
}
