/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scraper.api.response;


/**
 *
 * @author adobu
 */
public class ResponseClear {
	private String podsumowanie;

	public ResponseClear() {
	}

	public ResponseClear(String podsumowanie) {
		this.podsumowanie = podsumowanie;
	}

	public String getPodsumowanie() {
		return podsumowanie;
	}

	public void setPodsumowanie(String podsumowanie) {
		this.podsumowanie = podsumowanie;
	}
}
