import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Robot {
	static ArrayList<String> ban = new ArrayList();
	public static void compile(String iURL) throws IOException{
		URL rbt = new URL(iURL + "/robots.txt" + "");
		BufferedReader in;
		in = new BufferedReader(new InputStreamReader(rbt.openStream()));
		String htmlLine;
		while ((htmlLine = in.readLine()) != null) {
			if (htmlLine.startsWith("Disallow: ")){
				htmlLine = htmlLine.replace("Disallow: ", "");
				if (htmlLine.charAt(htmlLine.length() -1) == '/'){
					htmlLine = htmlLine.substring(0, htmlLine.length() -1);
				}
				ban.add(htmlLine);
				System.out.println(htmlLine);
			}
		}
		in.close();
	}
	
	public static boolean isNotRobot(String url){
		for (int i = 0; i < ban.size()- 1; i++){
			if (url == ban.get(i)){
				return false;
			}
		}
		return true;
	}
}
