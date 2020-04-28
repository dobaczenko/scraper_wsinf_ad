/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scraper.api.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import scraper.prop.Prop;

/**
 *
 * @author adobu
 */
public class ResponseBuilder {

    private static final Logger LOG = Logger.getLogger(ResponseBuilder.class.getName());

    /**
     * zwraca ResponseInfo w postaci string
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
