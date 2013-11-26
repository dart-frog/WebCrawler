import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;


public class SplitterTest {


	@Test
	public void testSpit() throws MalformedURLException{
		String adress = "http://en.wikipedia.org/wiki/Benjamin_Britten";
		URL url = null;
		try {
			url = new URL(adress);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} 
		
		Website net = new Website(url);
		try {
			net.compile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.print("ahhh");
			e.printStackTrace();
		}
		assertEquals("can get children", new URL("http://en.wikipedia.org/wiki/Wikipedia:Featured_articles"), Children.getChild());
	}

}
