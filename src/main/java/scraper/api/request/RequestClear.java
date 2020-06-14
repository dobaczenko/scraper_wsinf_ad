package scraper.api.request;

public class RequestClear {
	private String authKey;

	public RequestClear() {
	}

	public RequestClear(String authKey) {
		this.authKey = authKey;
	}

	public String getAuthKey() {
		return authKey;
	}

	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}

}
