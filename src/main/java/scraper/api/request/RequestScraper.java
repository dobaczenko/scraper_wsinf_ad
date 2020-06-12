package scraper.api.request;

public class RequestScraper {
	private String authKey;
	private String url;

	public RequestScraper() {
	}

	public RequestScraper(String authKey,String url) {
		this.authKey = authKey;
		this.url=url;
	}

	public String getAuthKey() {
		return authKey;
	}

	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
