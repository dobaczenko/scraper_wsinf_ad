package scraper.api.response;

import scraper.api.err.ERR_INFO;

public class ResponseError {
	private String errorId;
	private String errorDescription;

	public ResponseError() {
	}

	public ResponseError(ERR_INFO err) {
		this.errorId = err.getKey();
		this.errorDescription = err.getDesc();
	}

	public String getErrorId() {
		return errorId;
	}

	public void setErrorId(String errorId) {
		this.errorId = errorId;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

}
