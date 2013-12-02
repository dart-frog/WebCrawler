import java.io.IOException;
import java.util.TimerTask;

class CrawlTask extends TimerTask {
    public void run() {
    	try {

    		Screen.subcrawl();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	Screen.update();
    	this.cancel();
    }
  }
