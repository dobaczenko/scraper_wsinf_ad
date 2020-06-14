/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scraper.api.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import scraper.api.response.response_info_obj.RejestrWynikowResp;
import scraper.api.response.response_info_obj.RejestrZapytanResp;
import scraper.entity.RejestrWynikow;
import scraper.entity.RejestrZapytan;
import scraper.prop.Prop;

/**
 *
 * @author adobu
 */
public class ResponseBuilder {

	private static final Logger LOG = Logger.getLogger(ResponseBuilder.class.getName());

	/**
	 * zwraca ResponseInfo w postaci string
	 * 
	 * @return
	 */
	public static String getJson_ResponseInfo() {
		try {
			Prop prop = new Prop();
			ResponseInfo obj = new ResponseInfo();
			obj.setAutor(prop.getAutor());
			obj.setKierunek(prop.getKierunek());
			obj.setUczelnia(prop.getUczelnia());
			obj.setWersja(prop.getVersion());
			
			return budujJsonString(obj);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, null, e);
			return null;
		}
	}
	/**
	 * zwraca ResponseOstatnieWywolania w postaci string
	 * 
	 * @return
	 */
	public static String getJson_ResponseOstatnieWywolania(List<RejestrZapytan> listaZapytan) {
		try {
			ResponseOstatnieWywolania obj = new ResponseOstatnieWywolania();
			List<RejestrZapytanResp> rejestrDlaJSON = new ArrayList<>();
			if (listaZapytan != null) {
				for (RejestrZapytan rz : listaZapytan) {
					rejestrDlaJSON
							.add(new RejestrZapytanResp(rz.getDataZapytania(), rz.getKodZapytania(), rz.getUserId()));
				}
			}

			obj.setRejestrZapytan(rejestrDlaJSON);

			return budujJsonString(obj);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, null, e);
			return null;
		}
	}
	/**
	 * zwraca ResponseScraper w postaci string
	 * 
	 * @return
	 */
	public static String getJson_ResponseClear(boolean podsumowanie) {
		try {
			ResponseClear obj = new ResponseClear();
			obj.setPodsumowanie(podsumowanie?"Skasowano dane":"Wystapił problem");

			return budujJsonString(obj);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, null, e);
			return null;
		}
	}

	/**
	 * zwraca ResponseScraper w postaci string
	 * 
	 * @return
	 */
	public static String getJson_ResponseScraper(String podsumowanie) {
		try {
			ResponseScraper obj = new ResponseScraper();
			obj.setPodsumowanie(podsumowanie);

			return budujJsonString(obj);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, null, e);
			return null;
		}
	}

	/**
	 * zwraca listę scrapowanych elementow w postaci string
	 * 
	 * @return
	 */
	public static String getJson_ResponseListaScrapowanychElementow(List<RejestrWynikow> lista) {
		try {
			ResponseListaScrapowanychElementow obj = new ResponseListaScrapowanychElementow();

			List<RejestrWynikowResp> listaScrapowanych = new ArrayList<>();
			for (RejestrWynikow rw : lista) {
				listaScrapowanych.add(new RejestrWynikowResp(rw.getDataOperacji(), rw.getId(), rw.getTypZawartosci(),
						rw.getUrl(), rw.getZawartosc(), rw.getUserId()));
			}

			obj.setListaelementow(listaScrapowanych);

			return budujJsonString(obj);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, null, e);
			return null;
		}
	}

	public static String getJson_ResponseError(ResponseError obj) {
		try {
			return budujJsonString(obj);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, null, e);
			return null;
		}
	}

	private static String budujJsonString(Object o) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(o);
	}
}
