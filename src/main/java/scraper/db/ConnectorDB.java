package scraper.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;

import scraper.prop.Prop;

public class ConnectorDB extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static DataSource ds = null;

	public ConnectorDB() throws ServletException {
		try {
			InitialContext initialContext = new InitialContext();
			ds = (DataSource) initialContext.lookup(loadDBContext());
			if (ds == null) {
				String message = "DataSource fail";
				System.err.println("**** " + message);
				throw new Exception(message);
			}
		} catch (Exception e) {
			System.out.println("Problem z definicją połączenia " + e.getMessage());
			throw new ServletException(e.getMessage());
		}
	}

	private static String loadDBContext() {
		Prop prop;
		try {
			prop = new Prop();
			switch (prop.getBazaRodzaj()) {
			case "MySQL":
				return "java:/comp/env/jdbc/mysqldb";
			default:
				return "java:/comp/env/jdbc/mysqldb";
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static synchronized Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	public static synchronized void freeConnection(Connection conn) {
		try {
			conn.close();
		} catch (Exception e) {
			System.err.println("Wyjątek przy zamykaniu połączenia: " + e.getMessage());
		}
	}
}
