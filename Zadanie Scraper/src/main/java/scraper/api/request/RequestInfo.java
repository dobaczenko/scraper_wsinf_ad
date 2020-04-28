package scraper.api.request;

public class RequestInfo {
	private String authKey;

	public RequestInfo() {
	}

	public RequestInfo(String authKey) {
		this.authKey = authKey;
	}

	public String getAuthKey() {
		return authKey;
	}

	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}

}
