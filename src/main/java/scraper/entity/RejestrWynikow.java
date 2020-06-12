package scraper.entity;

import java.util.Date;

public class RejestrWynikow {
	private Date dataOperacji;
	private Integer id;
	private String typZawartosci;
	private String url;
	private String zawartosc;
	private String userId;

	public RejestrWynikow(Date dataOperacji, Integer id, String typZawartosci, String url, String zawartosc,
			String userId) {
		super();
		this.dataOperacji = dataOperacji;
		this.id = id;
		this.typZawartosci = typZawartosci;
		this.url = url;
		this.zawartosc = zawartosc;
		this.userId = userId;
	}

	public Date getDataOperacji() {
		return dataOperacji;
	}

	public void setDataOperacji(Date dataOperacji) {
		this.dataOperacji = dataOperacji;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypZawartosci() {
		return typZawartosci;
	}

	public void setTypZawartosci(String typZawartosci) {
		this.typZawartosci = typZawartosci;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getZawartosc() {
		return zawartosc;
	}

	public void setZawartosc(String zawartosc) {
		this.zawartosc = zawartosc;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
