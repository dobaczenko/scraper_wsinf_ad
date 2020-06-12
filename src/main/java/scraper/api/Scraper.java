package scraper.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scraper.Scrap;
import scraper.api.err.ERR_INFO;
import scraper.api.request.RequestBuilder;
import scraper.api.request.RequestInfo;
import scraper.api.request.RequestListaScrapowanychElementow;
import scraper.api.request.RequestScraper;
import scraper.api.response.ResponseBuilder;
import scraper.api.response.ResponseError;
import scraper.db.uzywalne.ObslugaDB;
import scraper.entity.UserDane;

/**
 * Servlet implementation class Info
 */
public class Scraper extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(Scraper.class.getName());

	private UserDane user = null;

	/**
	 * Default constructor.
	 */
	public Scraper() {
		this.user = null;
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String pathInfo = request.getPathInfo();
		if (pathInfo == null || pathInfo.equals("/")) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		System.out.println("Scraper Info: " + pathInfo);

		String[] splits = pathInfo.split("/");
		if (splits.length != 2) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		// url wskazuje na wykonanie operacji
		switch (splits[splits.length - 1]) {
		case "scrapuj":
			// metoda info
			if (!apiScrapuj(response, request)) {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			}
			break;
		case "wyniki":
			// metoda info
			if (!apiListaScrapowanychElementow(response, request)) {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			}
			break;

		default:
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
	}

	private boolean apiScrapuj(HttpServletResponse response, HttpServletRequest request) {
		try {

			// odczyt request
			StringBuilder bufor = new StringBuilder();
			BufferedReader bf = request.getReader();
			String line;
			while ((line = bf.readLine()) != null) {
				bufor.append(line);
			}
			RequestScraper in = RequestBuilder.getRequestScraper((bufor.toString()));

			// weryfikacja klucza
			ResponseError respErr = null;
			if (!testAuthKey(in.getAuthKey())) {
				respErr = new ResponseError(ERR_INFO.BAD_KEY);
			}
			String url = in.getUrl();

			Scrap scrap = new Scrap(url, this.user.getUserId());
			scrap.ustawienia_pobierzNaglowki(true);
			boolean wynikScrapowania = scrap.wykonaj();

			// odpowiedź
			response.setContentType("application/json,charset=UTF-8");
			try (PrintWriter out = response.getWriter()) {
				if (respErr != null) {
					out.print(ResponseBuilder.getJson_ResponseError(respErr));
					return true;
				}
				// wygenerowanie odpowiedzi
				out.print(ResponseBuilder
						.getJson_ResponseScraper((wynikScrapowania ? "Operacja wykonana" : "operacja nieudana")));
				// zapis w bazie informacji o zapytaniu
				ObslugaDB.getPoleceniaDB().rejestrZapytan_insert(new Date(), "apiScrapuj", user.getUserId());
			}
			return true;
		} catch (Exception e) {
			LOG.log(Level.SEVERE, null, e);
			return false;
		}
	}

	private boolean apiListaScrapowanychElementow(HttpServletResponse response, HttpServletRequest request) {
		try {

			// odczyt request
			StringBuilder bufor = new StringBuilder();
			BufferedReader bf = request.getReader();
			String line;
			while ((line = bf.readLine()) != null) {
				bufor.append(line);
			}
			RequestListaScrapowanychElementow in = RequestBuilder
					.getRequestListaScrapowanychElementow((bufor.toString()));

			// weryfikacja klucza
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
				// wygenerowanie odpowiedzi
				out.print(ResponseBuilder.getJson_ResponseListaScrapowanychElementow(
						ObslugaDB.getPoleceniaDB().rejestrWynikow_selectAll()));
				// zapis w bazie informacji o zapytaniu
				ObslugaDB.getPoleceniaDB().rejestrZapytan_insert(new Date(), "apiListaScrapowanychElementow",
						user.getUserId());
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

		this.user = ObslugaDB.getPoleceniaDB().userDane_selectKey(key);
		if (this.user != null) {
			return true;
		}
		return false;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

}
