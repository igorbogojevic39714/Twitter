import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;

import org.junit.Before;

import org.junit.Test;

import com.twitter.Twitter;
import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {
	Twitter t;
	TwitterPoruka tp1 = new TwitterPoruka();
	TwitterPoruka tp2 = new TwitterPoruka();
	@Before
	public void setUp() throws Exception {
		t = new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		t= null;
	}

	@Test 
	public void testVratiSvePoruke() {
		t.unesi("Igor", "Nova poruka od Igora");
		t.unesi("Zoran", "Nova poruka od Zorana");
		
		tp1.setKorisnik("Igor");
		tp1.setPoruka("Nova poruka od Igora");
		tp2.setKorisnik("Zoran");
		tp2.setPoruka("Nova poruka od Zorana");
		
		LinkedList<TwitterPoruka> novaLista = new LinkedList<TwitterPoruka>();
		novaLista.addLast(tp1);
		novaLista.addLast(tp2);
		//novaLista = t.vratiSvePoruke();
		assertEquals (  novaLista, t.vratiSvePoruke()  );
		
		
	}
	
	@Test 
	public void testUnesi() {
		t.unesi("Igor", "Nova poruka od Igora");
		
		
		tp1.setKorisnik("Igor");
		tp1.setPoruka("Nova poruka od Igora");
		
		
		LinkedList<TwitterPoruka> novaLista = new LinkedList<TwitterPoruka>();
		novaLista.addLast(tp1);
		
		//novaLista = t.vratiSvePoruke();
		assertEquals ( novaLista, t.vratiSvePoruke()  );
		
	}
	@Test
	public void testVratiSvePorukeNiz (){
		t.unesi("Igor2", "Nova poruka Igor2");
		t.unesi("Igor2", "Tag Nova poruka Igor2");
		TwitterPoruka[] noviNiz = new TwitterPoruka[1];
		tp1.setKorisnik("Igor2");
		tp1.setPoruka("Tag Nova poruka Igor2");
		
		noviNiz[0] = tp1;
		TwitterPoruka[] praviNiz = t.vratiPoruke(1, "Tag");
		assertArrayEquals(noviNiz, praviNiz);
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeLoseee(){
		t.vratiPoruke(1, null);
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukePraznaStringgg(){
		t.vratiPoruke(1, "");
	}
}
