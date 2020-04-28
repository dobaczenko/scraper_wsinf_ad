/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scraper.api.response;

/**
 *
 * @author adobu
 */
public class ResponseInfo {
    private String autor;
    private String kierunek;
    private String uczelnia;
    private String wersja;

    public ResponseInfo() {
    }

    public ResponseInfo(String autor, String kierunek, String uczelnia, String wersja) {
        this.autor = autor;
        this.kierunek = kierunek;
        this.uczelnia = uczelnia;
        this.wersja = wersja;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getKierunek() {
        return kierunek;
    }

    public void setKierunek(String kierunek) {
        this.kierunek = kierunek;
    }

    public String getUczelnia() {
        return uczelnia;
    }

    public void setUczelnia(String uczelnia) {
        this.uczelnia = uczelnia;
    }

    public String getWersja() {
        return wersja;
    }

    public void setWersja(String wersja) {
        this.wersja = wersja;
    }
    
    
}
