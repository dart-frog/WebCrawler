import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;


public class WebsiteTest {

	@Test
	public void testGet() {
		String adress = "http://en.wikipedia.org/wiki/Benjamin_Britten";
		URL url = null;
		try {
			url = new URL(adress);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} 
		Website net = new Website(url);
		assertEquals("see if it can return a website",adress,net.getWebsite());
	}
	@Test
	public void testCompile(){
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
		assertEquals("see if it can return word count", "7",net.occurrence("gramophone"));
	}

}
