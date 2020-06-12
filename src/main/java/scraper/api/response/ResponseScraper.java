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
public class ResponseScraper {
	private String podsumowanie;

	public ResponseScraper() {
	}

	public ResponseScraper(String podsumowanie) {
		this.podsumowanie = podsumowanie;
	}

	public String getPodsumowanie() {
		return podsumowanie;
	}

	public void setPodsumowanie(String podsumowanie) {
		this.podsumowanie = podsumowanie;
	}

}
