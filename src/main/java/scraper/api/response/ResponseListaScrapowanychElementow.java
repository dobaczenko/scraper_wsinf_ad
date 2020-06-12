/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scraper.api.response;

import java.util.List;

import scraper.api.response.response_info_obj.RejestrWynikowResp;

/**
 *
 * @author adobu
 */
public class ResponseListaScrapowanychElementow {
	private List<RejestrWynikowResp> listaelementow;

	public ResponseListaScrapowanychElementow() {
	}

	public ResponseListaScrapowanychElementow(List<RejestrWynikowResp> listaelementow) {
		this.listaelementow = listaelementow;
	}

	public List<RejestrWynikowResp> getListaelementow() {
		return listaelementow;
	}

	public void setListaelementow(List<RejestrWynikowResp> listaelementow) {
		this.listaelementow = listaelementow;
	}

}
