import java.util.ArrayList;


public class Children {
	public static ArrayList<String> x;
	public static int index=0;
	public static void addChild(String c){
		x.add(c);
	}
	public static String getChild(){
		index++;
		return x.get(index);
	}
	public static String getChild(int i){
		return x.get(i);	
	}
	
}
