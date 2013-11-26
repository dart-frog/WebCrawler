import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class Children {
	public static ArrayList<URL> x = new ArrayList();
	public static int index=0;
	public static void addChild(String s)throws MalformedURLException{	
		URL c = new URL(s);		
		x.add(c);
	}
	public static URL getChild(){
		index++;
		return x.get(index);
	}
	public static URL getChild(int i){
		return x.get(i);	
	}
	
}
