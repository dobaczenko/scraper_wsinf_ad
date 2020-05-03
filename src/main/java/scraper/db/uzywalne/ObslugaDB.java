package scraper.db.uzywalne;

import java.io.IOException;

import scraper.db.PoleceniaDB;
import scraper.db.PoleceniaMySQL;
import scraper.prop.Prop;

/**
 * zwraca połączenie i metody własciwe dla danej bazy, domyślnie jest to mysql,
 * ale gdyby była potrzeba, pozwala to na łątwą zmianę bazy bez analizy całego
 * kodu
 * 
 * prościej jest użyć hibernate, ale projekt jest na tyle prosty (jeśli chodzi o bazę), że chciałem
 * się odrobinę pobawić
 * 
 * @author adobu
 *
 */
public class ObslugaDB {
	private static final PoleceniaDB poleceniaDB = loadPoleceniaDB();

	private static PoleceniaDB loadPoleceniaDB() {
		Prop prop;
		try {
			prop = new Prop();
			switch (prop.getBazaRodzaj()) {
			case "MySQL":
				return new PoleceniaMySQL();
			default:
				return new PoleceniaMySQL();
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static PoleceniaDB getPoleceniaDB() {
		return poleceniaDB;
	}
}
