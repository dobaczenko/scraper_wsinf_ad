package scraper.db;

import java.util.Date;
import java.util.List;

import scraper.entity.RejestrZapytan;

public abstract class PoleceniaDB {
	/**
	 * zwraca listę RejestrZapytan (log zapytań do DB) lub null w przypadku błędu
	 * @return
	 */
	public abstract List<RejestrZapytan> rejestrZapytan_selectLista();

	/**
	 * dodaje nowy wpis w logu zapytań
	 * @param data
	 * @param kod
	 * @return
	 */
	public abstract boolean rejestrZapytan_insert(Date data, String kod);
}
