import java.net.URL;


public class Website {
	URL url;
	public Website(URL url){
		this.url = url;
	}
	public String getWebsite(){
		return url.toString();
	}
}
