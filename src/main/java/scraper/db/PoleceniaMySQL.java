package scraper.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import scraper.entity.RejestrZapytan;

public class PoleceniaMySQL extends PoleceniaDB {
	private static final Logger LOG = Logger.getLogger(PoleceniaMySQL.class.getName());

	@Override
	public List<RejestrZapytan> rejestrZapytan_selectLista() {
		List<RejestrZapytan> rejestrZapytanL = new ArrayList<>();

		Connection con = null;
		try {
			con = ConnectorDB.getConnection();
			// con.setAutoCommit(false);
			PreparedStatement pstmt = con
					.prepareStatement("SELECT * FROM pp_scraper_wsinf.rejestr_zapytan ORDER BY data_zapytania ASC;");
			ResultSet rs = pstmt.executeQuery();

			// con.commit();

			while (rs.next()) {
				rejestrZapytanL.add(
						new RejestrZapytan(rs.getInt("id"), rs.getTimestamp("data_zapytania"),
								rs.getString("kod_zapytania")));
			}
			return rejestrZapytanL;
		} catch (Exception e) {
			LOG.log(Level.SEVERE, null, e);
			if (con != null) {
				System.err.print("Transakcja wycofana");
				// con.rollback();
			}
			return null;
		} finally {
			if (con != null) {
				try {
					con.setAutoCommit(true);
				} catch (SQLException ex) {
					LOG.log(Level.SEVERE, null, ex);
				}
				ConnectorDB.freeConnection(con);
			}
		}
	}

	@Override
	public boolean rejestrZapytan_insert(Date data, String kod) {
		Connection con = null;
		try {
			con = ConnectorDB.getConnection();
			con.setAutoCommit(false);
			PreparedStatement pstmt = con
					.prepareStatement(
							"INSERT INTO pp_scraper_wsinf.rejestr_zapytan (data_zapytania, kod_zapytania) VALUES(?, ?);");
			pstmt.setTimestamp(1, new java.sql.Timestamp(data.getTime()));
			pstmt.setString(2, kod);

			pstmt.executeUpdate();

			con.commit();

			return true;
		} catch (Exception e) {
			LOG.log(Level.SEVERE, null, e);
			if (con != null) {
				try {
					System.err.print("Transakcja wycofana");
					con.rollback();
				} catch (SQLException excep) {
					LOG.log(Level.SEVERE, null, excep);
				}
			}
			return false;
		} finally {
			if (con != null) {
				try {
					con.setAutoCommit(true);
				} catch (SQLException ex) {
					LOG.log(Level.SEVERE, null, ex);
				}
				ConnectorDB.freeConnection(con);
			}
		}
	}

}
