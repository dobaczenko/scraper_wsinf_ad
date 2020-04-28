package scraper.api.response;

public class ResponseError {
	private String errorId;
	private String errorDescription;

	public ResponseError() {
	}

	public ResponseError(String errorId, String errorDescription) {
		this.errorId = errorId;
		this.errorDescription = errorDescription;
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
