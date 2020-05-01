package scraper.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scraper.api.err.ERR_INFO;
import scraper.api.request.RequestBuilder;
import scraper.api.request.RequestInfo;
import scraper.api.response.ResponseBuilder;
import scraper.api.response.ResponseError;

/**
 * Servlet implementation class Info
 */
public class Info extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(Info.class.getName());

	private static String TEMP_AUTH_KEY = "bf0f6bbeb42167ab5a8a4cb90ec95db6";// PanDaTrzy w md5

	/**
	 * Default constructor.
	 */
	public Info() {
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,
			IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String pathInfo = request.getPathInfo();
		if (pathInfo == null || pathInfo.equals("/")) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		System.out.println("Api Info: " + pathInfo);

		String[] splits = pathInfo.split("/");
		if (splits.length != 2) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		// url wskazuje na wykonanie operacji
		switch (splits[splits.length - 1]) {
		case "abouts":
			// metoda info
			if (apiAbouts(response, request)) {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			}
			break;
		// check_db

		default:
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
	}

	private boolean apiAbouts(HttpServletResponse response, HttpServletRequest request) {
		try {
			// odczyt request
			StringBuilder bufor = new StringBuilder();
			BufferedReader bf = request.getReader();
			String line;
			while ((line = bf.readLine()) != null) {
				bufor.append(line);
			}
			RequestInfo in = RequestBuilder.getRequestInfo(bufor.toString());

			// coś tam na odczytanych danych, w tym mniejscu normalnie byłaby jakaś
			// klasa/metoda operacyjna, ale na razie tak na skróty
			ResponseError respErr = null;
			if (!testAuthKey(in.getAuthKey())) {
				respErr = new ResponseError(ERR_INFO.BAD_KEY);
			}

			// odpowiedź
			response.setContentType("application/json,charset=UTF-8");
			try (PrintWriter out = response.getWriter()) {
				if (respErr != null) {
					out.print(ResponseBuilder.getJson_ResponseError(respErr));
					return true;
				}
				out.print(ResponseBuilder.getJson_ResponseInfo());
			}
			return true;
		} catch (Exception e) {
			LOG.log(Level.SEVERE, null, e);
			return false;
		}
	}

	private boolean testAuthKey(String key) {
		if (key == null) {
			return false;
		}
		if (key.equals(TEMP_AUTH_KEY)) {
			return true;
		}
		return false;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,
			IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,
			IOException {
		processRequest(request, response);
	}

}
