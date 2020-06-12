package scraper.api.response.response_info_obj;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RejestrZapytanResp {
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date data;
	private String operacja;
	private String user;

	public RejestrZapytanResp() {
		super();
	}

	public RejestrZapytanResp(Date data, String operacja, String user) {
		super();
		this.data = data;
		this.operacja = operacja;
		this.user = user;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getOperacja() {
		return operacja;
	}

	public void setOperacja(String operacja) {
		this.operacja = operacja;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
