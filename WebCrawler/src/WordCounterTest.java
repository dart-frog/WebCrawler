import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;
import java.util.List;

public class WordCounterTest {

	@Test
	public void test() {
		ArrayList<String> t = new ArrayList<String>();
		HashMap x = new HashMap();
		t.add("the");
		t.add("the");
		t.add("add");
		t.add("and");
		t.add("razor");
		t.add("the");
		assertEquals("verify that you can record the amount of the", 3, WordCounter.reader(t, x).get("the")); 
	}

}
