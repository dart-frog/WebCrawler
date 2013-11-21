import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class Website {
	URL url;
	HashMap hm;
	public Website(URL url){
		this.url = url;
	}
	public String getWebsite(){
		return url.toString();
	}
	public HashMap getHashMap(){
		return hm;
	}
	public HashMap compile() throws IOException{
		BufferedReader in;
		in = new BufferedReader(new InputStreamReader(url.openStream()));
		String htmlLine;
		StringBuilder massive = new StringBuilder();
		while ((htmlLine = in.readLine()) != null) {
			massive.append(htmlLine);
		}
		in.close();
		String massiveString = massive.toString();
		
		ArrayList<String> fixedText = new ArrayList<String>();
		fixedText = (ArrayList<String>) Splitter.split(massiveString,getWebsite());
		HashMap w = new HashMap();
		w = WordCounter.reader(fixedText, w);
		return w;

	}
}
