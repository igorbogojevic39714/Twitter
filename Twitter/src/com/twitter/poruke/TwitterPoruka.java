package com.twitter.poruke;
/**
 * Klasa koja sadrzi kod u kome se nalaze atributi i odgovarajuce get i set metode.
 * @author Igor
 *
 */
public class TwitterPoruka {
	/**
	 * Atribut korisnik, predstavlja onog ko je uneo poruku.
	 */
	private String korisnik;
	/**
	 * Atribut koji pokazuje koju poruku je otkucao korisnik.
	 */
	private String poruka;
	/**
	 * Get metoda vraca string korisnik.
	 * @return
	 */
	public String getKorisnik() {
	return korisnik;
	}
	/**
	 * Set metoda, prima parametar korisnik i baca gresku ako je unet prazan ili null string.
	 * @param korisnik
	 */
	public void setKorisnik(String korisnik) {
	if (korisnik==null || korisnik == "")
	throw new RuntimeException( "Ime korisnika mora biti uneto");
	this.korisnik = korisnik;
	}
	/**
	 * Get metoda vraca string sa tekstom poruka.
	 * @return
	 */
	public String getPoruka() {
	return poruka;
	}
	/**
	 * Set metoda, prima parametar poruka i baca gresku ako je unet null 
	 * ili string veci od 140.
	 * @param poruka
	 */
	public void setPoruka(String poruka) {
	if (poruka==null || poruka.length()>140)
	throw new RuntimeException( "Poruka mora biti uneta i mora imati najvise 140 znakova");
	this.poruka = poruka;
	}
	/**
	 * Metoda ispisuje na ekranu:
	 * <ul>
	 * <li>KORISNIK: "ime"
	 * <li>PORUKA: "odgovarajuca poruka"
	 * </ul>
	 */
	public String toString(){
	return "KORISNIK:"+korisnik+"PORUKA:"+poruka;
	}
	
}
