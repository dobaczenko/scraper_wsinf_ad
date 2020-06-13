package scraper.api.request;

public class RequestScraper {
	private String authKey;
	private String url;

	private Boolean pobierzNaglowki;
	private Boolean pobierzLinki;

	public RequestScraper() {
	}

	public RequestScraper(String authKey, String url, Boolean pobierzNaglowki, Boolean pobierzLinki) {
		this.authKey = authKey;
		this.url = url;
		this.pobierzNaglowki = pobierzNaglowki;
		this.pobierzLinki = pobierzLinki;
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

	public Boolean getPobierzNaglowki() {
		return pobierzNaglowki;
	}

	public void setPobierzNaglowki(Boolean pobierzNaglowki) {
		this.pobierzNaglowki = pobierzNaglowki;
	}

	public Boolean getPobierzLinki() {
		return pobierzLinki;
	}

	public void setPobierzLinki(Boolean pobierzLinki) {
		this.pobierzLinki = pobierzLinki;
	}

}
