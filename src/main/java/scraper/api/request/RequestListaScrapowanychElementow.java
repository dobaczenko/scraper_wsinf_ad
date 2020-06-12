package scraper.api.request;

public class RequestListaScrapowanychElementow {
	private String authKey;

	public RequestListaScrapowanychElementow() {
	}

	public RequestListaScrapowanychElementow(String authKey) {
		this.authKey = authKey;
	}

	public String getAuthKey() {
		return authKey;
	}

	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}


	
	

}
