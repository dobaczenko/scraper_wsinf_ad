package scraper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import scraper.db.uzywalne.ObslugaDB;
import scraper.entity.RejestrWynikow;

public class Scrap {
	private String link;

	private boolean ustScrapGet_naglowek;
	private boolean ustScrapGet_img;
	
	private String user;

	/**
	 * w konstruktorze przekazujemy link strony do scrapowania
	 * 
	 * @param link
	 */
	public Scrap(String link,String user) {
		this.ustScrapGet_naglowek = false;
		this.ustScrapGet_img = false;
		
		this.link=link;
		
		this.user=user;
	}
	
	
	public void ustawienia_pobierzNaglowki(boolean b) {
		this.ustScrapGet_naglowek=b;
	}
	/*
	public void ustawienia_pobierzObrazki(boolean b) {
		this.ustScrapGet_img=b;
	}
	*/
	
	public boolean wykonaj() {
		Document doc;
		List<RejestrWynikow> rejestr=new ArrayList<>();
        try {
            doc = Jsoup.connect(this.link).get();
 
            if(ustScrapGet_naglowek) {
            	String[] tags= {"h1","h2","h3","h4","h5","h6"};
            	for(String tag:tags) {
            		Elements elements = doc.getElementsByTag(tag);
            		 for (Element el : elements) {
            			 rejestr.add(new RejestrWynikow(new Date(), null, "naglowek", this.link, el.text(), user));
                     }            		
            	}            
            }
            ObslugaDB.getPoleceniaDB().rejestrWynikow_insert(rejestr);
            return true;
        }catch (IOException e) {
            e.printStackTrace();
            return false;
        }
	}
}
