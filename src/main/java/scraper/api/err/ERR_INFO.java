package scraper.api.err;

public enum ERR_INFO {
	BAD_KEY("INFO01", "Niepoprawny klucz autoryzacyjny"),
	BAD_URL("SCRAPO01", "Niepoprawny adres url");

	private String key;

	private String desc;

	public String getKey() {
		return key;
	}

	public String getDesc() {
		return desc;
	}

	private ERR_INFO(String key, String desc) {
		this.desc = desc;
		this.key = key;
	}
}
