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

}
