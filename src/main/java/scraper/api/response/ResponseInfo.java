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
public class ResponseInfo {
	private String autor;
	private String kierunek;
	private String uczelnia;
	private String wersja;
	private List<RejestrZapytanResp> rejestrZapytan;

	public ResponseInfo() {
	}

	public ResponseInfo(String autor, String kierunek, String uczelnia, String wersja,
			List<RejestrZapytanResp> rejestrZapytan) {
		this.autor = autor;
		this.kierunek = kierunek;
		this.uczelnia = uczelnia;
		this.wersja = wersja;
		this.rejestrZapytan = rejestrZapytan;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getKierunek() {
		return kierunek;
	}

	public void setKierunek(String kierunek) {
		this.kierunek = kierunek;
	}

	public String getUczelnia() {
		return uczelnia;
	}

	public void setUczelnia(String uczelnia) {
		this.uczelnia = uczelnia;
	}

	public String getWersja() {
		return wersja;
	}

	public void setWersja(String wersja) {
		this.wersja = wersja;
	}

	public List<RejestrZapytanResp> getRejestrZapytan() {
		return rejestrZapytan;
	}

	public void setRejestrZapytan(List<RejestrZapytanResp> rejestrZapytan) {
		this.rejestrZapytan = rejestrZapytan;
	}

}
