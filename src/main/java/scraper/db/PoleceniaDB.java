package scraper.db;

import java.util.Date;
import java.util.List;

import scraper.entity.RejestrWynikow;
import scraper.entity.RejestrZapytan;
import scraper.entity.UserDane;

public abstract class PoleceniaDB {
	/**
	 * zwraca listę RejestrZapytan (log zapytań do DB) lub null w przypadku błędu
	 * 
	 * @return
	 */
	public abstract List<RejestrZapytan> rejestrZapytan_selectLista();

	/**
	 * dodaje nowy wpis w logu zapytań
	 * 
	 * @param data
	 * @param kod
	 * @param userId
	 * @return
	 */
	public abstract boolean rejestrZapytan_insert(Date data, String kod, String userId);

	/**
	 * znajduje usera przypisanego do wskazanego klucza
	 * 
	 * @param key
	 * @return
	 */
	public abstract UserDane userDane_selectKey(String key);

	/**
	 * pozwala na zapisanie wynikow scrapowania do bazy danych 
	 * 
	 * @param rejestrWynikow
	 * @return
	 */
	public abstract boolean rejestrWynikow_insert(List<RejestrWynikow> rejestrWynikow);
	/**
	 * zwraca wszystkie scrapowane elementy
	 * @return
	 */
	public abstract List<RejestrWynikow> rejestrWynikow_selectAll();
	
	/**
	 * kasuje zapisane elementy strony
	 * @return
	 */
	public abstract boolean rejestrWynikow_czysc();
	
}
