package testovizaprvikod;

import static org.junit.Assert.*;

import org.junit.After;

import org.junit.Before;

import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterPorukaTest1 {
	
	private TwitterPoruka t;
	@Before
	public void setUp() throws Exception {
		t = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		t = null;
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikDaLiJeNull() {
		t.setKorisnik(null);
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikDaLiJePrazanString() {
		t.setKorisnik("");
	}
	@Test 
	public void testSetKorisnikSveJeOk() {
		String korisnik = "KorisnikTwittera";
		t.setKorisnik(korisnik);
		assertEquals (korisnik, t.getKorisnik());
	}

	@Test
	public void testSetPorukaSvejeOk() {
		String poruka = "Poruka twiterasa";
		t.setPoruka(poruka);
		assertEquals (poruka, t.getPoruka());
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaDaLiJeNull() {
		t.setPoruka(null);
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaVecaOd140() {
		t.setPoruka ("Poruka veca od 140, ne dozvoljeni unos na twitter mrezi! "
				+ "Proveravam ovaj test unosenjem vise od 140 karaktera, "
				+ "zbog toga pisem ovu recenicu. Moram jos nekoliko reci da ukucam, "
				+ "ocigledno nisam dovoljno pa test ne radi. Sada test radi :)");
	}
	
	@Test
	public void testToString (){
		String korisnik = "Novi";
		String poruka = "Nova";
		t.setKorisnik(korisnik);
		t.setPoruka(poruka);
		assertEquals ("KORISNIK:"+korisnik+"PORUKA:"+poruka, t.toString());
	
	}
}
