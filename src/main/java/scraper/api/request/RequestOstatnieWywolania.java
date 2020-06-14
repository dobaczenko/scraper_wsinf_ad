package scraper.api.request;

public class RequestOstatnieWywolania {
	private String authKey;

	public RequestOstatnieWywolania() {
	}

	public RequestOstatnieWywolania(String authKey) {
		this.authKey = authKey;
	}

	public String getAuthKey() {
		return authKey;
	}

	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}

}
