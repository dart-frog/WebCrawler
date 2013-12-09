import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class Splitter {
	
	/**
	 * Splits a line into words and removes html tags
	 * @param the line of html you would like to split 
	 * @return A list of words with out the html tags
	 * @throws IOException 
	 */
	public static List<String> split (String x,String url) throws IOException{
		String iURL = initalURL(url);
		Robot.compile(iURL);
		List<String> sorted = new ArrayList<String>();
		int d = 0;
		while ( !(x.substring(d, d+4).equals("body"))){
			d++;
		}
		x = x.substring(d+4);
		if (x.charAt(d+5) == '{'){
			String y = x.substring(d+5, x.indexOf('}') +1);
			x = x.replace(y, "");
			
		}
		for (int i = 0; i < x.length(); i++){
			
			if (x.charAt(i) == '<'){
				String y = x.substring(i, x.indexOf('>',i) +1);
				if(y.contains("<a href=\"")){
					getLink(y,url,iURL);
				}
				x = x.replace(y, "");
				i=-1;
			}
		}
		String[] pre = x.split(" ");
		for (int i = 0; i < pre.length; i++){
			sorted.add(format(pre[i].toLowerCase()));
		}
		return sorted;
	}
	public static String format(String rough) {
		rough = rough.replace(" ", "");
		rough = rough.replace("\"", "");
		rough = rough.replace("(", "");
		rough = rough.replace(")", "");
		rough = rough.replace(",", "");
		rough = rough.replace(":", "");
		rough = rough.replace("^", "");
		rough = rough.replace(";", "");
		rough = rough.replaceAll("\t", "");
		rough = rough.replace(".", "");
		return rough;
	}
	public static void getLink(String child, String url, String iURL) throws MalformedURLException{
		child = child.replace("<a href=\"", "");
		if(child.startsWith("http://")){
			Children.addChild(child);
		}
		else if (child.startsWith("/")){
			for(int i = 0; i < child.length(); i++){
				if (child.charAt(i) == '\"'){
					child = child.substring(0, i);
				}
			}
			Children.addChild(iURL + child);
		}
		else if (child.startsWith("#")){
			
		}
		else {
			Children.addChild(url += child); 
		}
		
	}
	public static String initalURL(String url){
		url = url.replace("http://", "");
		for(int i = 0; i < url.length(); i++){
			if (url.charAt(i) == '/'){
				url = url.substring(0, i);
			}
		}
		return "http://" + url;
		
	}
	public static boolean isNotInRobo(String iurl) throws IOException{
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
		
		
		return false;
	}


}
