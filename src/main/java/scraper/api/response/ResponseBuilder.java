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

import scraper.api.response.response_info_obj.RejestrZapytanResp;
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
	public static String getJson_ResponseInfo(List<RejestrZapytan> listaZapytan) {
		try {
			Prop prop = new Prop();
			ResponseInfo obj = new ResponseInfo();
			obj.setAutor(prop.getAutor());
			obj.setKierunek(prop.getKierunek());
			obj.setUczelnia(prop.getUczelnia());
			obj.setWersja(prop.getVersion());
			List<RejestrZapytanResp> rejestrDlaJSON = new ArrayList<>();
			if (listaZapytan != null) {
				for (RejestrZapytan rz : listaZapytan) {
					rejestrDlaJSON.add(new RejestrZapytanResp(rz.getDataZapytania(), rz.getKodZapytania()));
				}
			}

			obj.setRejestrZapytan(rejestrDlaJSON);

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
