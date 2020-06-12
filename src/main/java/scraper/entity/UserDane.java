package scraper.entity;

public class UserDane {
	private String userId;
	private String klucz;

	public UserDane(String userId, String klucz) {
		super();
		this.userId = userId;
		this.klucz = klucz;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getKlucz() {
		return klucz;
	}

	public void setKlucz(String klucz) {
		this.klucz = klucz;
	}

}
