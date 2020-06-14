/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scraper.api.response;

import java.util.List;

import scraper.api.response.response_info_obj.RejestrZapytanResp;

/**
 *
 * @author adobu
 */
public class ResponseOstatnieWywolania {
	private List<RejestrZapytanResp> rejestrZapytan;

	public ResponseOstatnieWywolania() {
	}

	public ResponseOstatnieWywolania(List<RejestrZapytanResp> rejestrZapytan) {
		this.rejestrZapytan = rejestrZapytan;
	}

	public List<RejestrZapytanResp> getRejestrZapytan() {
		return rejestrZapytan;
	}

	public void setRejestrZapytan(List<RejestrZapytanResp> rejestrZapytan) {
		this.rejestrZapytan = rejestrZapytan;
	}

}
