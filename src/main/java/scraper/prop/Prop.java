/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scraper.prop;

import java.io.IOException;
import java.util.Properties;

/**
 * klasa udostępnia dane z pliku właściwości
 * 
 * @author adobu
 */
public class Prop {

	private final String version;
	private final String artifactId;
	private final String autor;
	private final String kierunek;
	private final String uczelnia;
	private final String bazaRodzaj;

	public Prop() throws IOException {
		final Properties properties = new Properties();
		properties.load(this.getClass().getClassLoader().getResourceAsStream("project.properties"));
		version = properties.getProperty("version");
		artifactId = properties.getProperty("artifactId");
		autor = properties.getProperty("autor");
		kierunek = properties.getProperty("kierunek");
		uczelnia = properties.getProperty("uczelnia");
		this.bazaRodzaj=properties.getProperty("bazaRodzaj");
	}

	public String getVersion() {
		return version;
	}

	public String getArtifactId() {
		return artifactId;
	}

	public String getAutor() {
		return autor;
	}

	public String getKierunek() {
		return kierunek;
	}

	public String getUczelnia() {
		return uczelnia;
	}

	public String getBazaRodzaj() {
		return bazaRodzaj;
	}
	


}
