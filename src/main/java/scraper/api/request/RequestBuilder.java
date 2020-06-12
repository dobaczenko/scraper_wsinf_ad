package scraper.api.request;

import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RequestBuilder {
	private static final Logger LOG = Logger.getLogger(RequestBuilder.class.getName());

	public static RequestInfo getRequestInfo(String json) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		RequestInfo ri = mapper.readValue(json, RequestInfo.class);
		return ri;
	}
	public static RequestScraper getRequestScraper(String json) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		RequestScraper ri = mapper.readValue(json, RequestScraper.class);
		return ri;
	}
	public static RequestListaScrapowanychElementow getRequestListaScrapowanychElementow(String json) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		RequestListaScrapowanychElementow ri = mapper.readValue(json, RequestListaScrapowanychElementow.class);
		return ri;
	}

}
