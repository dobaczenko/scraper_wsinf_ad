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

import scraper.entity.RejestrWynikow;
import scraper.entity.RejestrZapytan;
import scraper.entity.UserDane;

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
					.prepareStatement("SELECT * FROM rejestr_zapytan ORDER BY data_zapytania ASC;");
			ResultSet rs = pstmt.executeQuery();

			// con.commit();

			while (rs.next()) {
				rejestrZapytanL.add(new RejestrZapytan(rs.getInt("id"), rs.getTimestamp("data_zapytania"),
						rs.getString("kod_zapytania"), rs.getString("user_id")));
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
	public boolean rejestrZapytan_insert(Date data, String kod, String userId) {
		Connection con = null;
		try {
			con = ConnectorDB.getConnection();
			con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement(
					"INSERT INTO rejestr_zapytan (data_zapytania, kod_zapytania, user_id) VALUES(?, ?, ?);");
			pstmt.setTimestamp(1, new java.sql.Timestamp(data.getTime()));
			pstmt.setString(2, kod);
			pstmt.setString(3, userId);

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

	@Override
	public UserDane userDane_selectKey(String key) {
		UserDane user = null;

		Connection con = null;
		try {
			con = ConnectorDB.getConnection();
			// con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM user_dane WHERE klucz = ?;");
			pstmt.setString(1, key);
			ResultSet rs = pstmt.executeQuery();

			// con.commit();

			while (rs.next()) {
				user = new UserDane(rs.getString("user_id"), rs.getString("klucz"));
			}
			return user;
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
	public boolean rejestrWynikow_insert(List<RejestrWynikow> rejestrWynikow) {
		Connection con = null;
		try {
			con = ConnectorDB.getConnection();
			con.setAutoCommit(false);
			for (RejestrWynikow rw : rejestrWynikow) {
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO rejestr_wynikow (data_operacji, typ_wartosci, user_id, url, zawartosc) VALUES(?, ?, ?, ?, ?);");
				pstmt.setTimestamp(1, new java.sql.Timestamp(rw.getDataOperacji().getTime()));
				pstmt.setString(2, rw.getTypZawartosci());
				pstmt.setString(3, rw.getUserId());
				pstmt.setString(4, rw.getUrl());
				pstmt.setString(5, rw.getZawartosc());
				pstmt.executeUpdate();
			}

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

	@Override
	public List<RejestrWynikow> rejestrWynikow_selectAll() {
		List<RejestrWynikow> wyniki = new ArrayList<>();

		Connection con = null;
		try {
			con = ConnectorDB.getConnection();
			// con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement(
					"SELECT data_operacji, id, typ_wartosci, user_id, url, zawartosc FROM rejestr_wynikow ORDER BY data_operacji DESC, id ASC;");
			ResultSet rs = pstmt.executeQuery();

			// con.commit();

			while (rs.next()) {
				wyniki.add(new RejestrWynikow(rs.getTimestamp("data_operacji"), rs.getInt("id"),
						rs.getString("typ_wartosci"), rs.getString("url"), rs.getString("zawartosc"),
						rs.getString("user_id")));
			}
			// return user;
			return wyniki;
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
	public boolean rejestrWynikow_czysc() {
		Connection con = null;
		try {
			con = ConnectorDB.getConnection();
			con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement("TRUNCATE table rejestr_wynikow;");
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
