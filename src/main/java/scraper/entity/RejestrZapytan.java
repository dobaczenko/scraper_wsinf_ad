package scraper.entity;

import java.util.Date;

/**
 * CREATE TABLE pp_scraper_wsinf.rejestr_zapytan ( id INT auto_increment NOT
 * NULL, data_zapytania DATETIME NOT NULL, kodzapytania TEXT NULL, CONSTRAINT
 * rejestr_zapytan_pk PRIMARY KEY (id) ) ENGINE=InnoDB DEFAULT CHARSET=utf8
 * COLLATE=utf8_general_ci;
 * 
 * 
 * @author adobu
 *
 */
public class RejestrZapytan {
	private Integer id;
	private Date dataZapytania;
	private String kodZapytania;
	private String userId;

	public RejestrZapytan(Integer id, Date dataZapytania, String kodZapytania,String userId) {
		super();
		this.id = id;
		this.dataZapytania = dataZapytania;
		this.kodZapytania = kodZapytania;
		this.userId=userId;
	}

	public RejestrZapytan() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataZapytania() {
		return dataZapytania;
	}

	public void setDataZapytania(Date dataZapytania) {
		this.dataZapytania = dataZapytania;
	}

	public String getKodZapytania() {
		return kodZapytania;
	}

	public void setKodZapytania(String kodZapytania) {
		this.kodZapytania = kodZapytania;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	

}
