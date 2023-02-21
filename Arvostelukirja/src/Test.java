import java.util.Random;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

public class Test{
    public static void main(String[] args){
        final Random r = new Random();
        
        
        System.out.println("Testataan luokkaa Arvostelukirja...");
        Arvostelukirja ak = new Arvostelukirja("Arto Arvioija");
        
        System.out.println("Olio luotu!");
        
        try {
            Field numero = ak.getClass().getDeclaredField("omistaja");
            boolean numeroPrivate = numero.getModifiers() == 4;
            System.out.println("Omistaja on suojattu (protected): " + numeroPrivate);
        } catch (Exception e) {
            System.out.println("Attribuuttia omistaja ei ole määritelty");
        }
        
        try {
            Field arvosanat = ak.getClass().getDeclaredField("arvosanat");
            boolean asPrivate = arvosanat.getModifiers() == 4;
            System.out.println("Arvosanat on suojattu (protected): " + asPrivate);
            
            ArrayList<Arvosana> as = ak.arvosanat;
            boolean asAlustettu = ak != null;
            System.out.println("Arvosanalista on alustettu: " + asAlustettu);
        } catch (Exception e) {
            System.out.println("Attribuuttia arvosanat ei ole määritelty");
        }
    }
}
class Arvosana {
    private String opiskelija;
    private int arvosana;
    
    public Arvosana(String opiskelija, int arvosana) {
        this.opiskelija = opiskelija;
        this.arvosana = arvosana;
    }

    public String getOpiskelija() {
        return opiskelija;
    }

    public int getArvosana() {
        return arvosana;
    }

}

/*Kirjoita luokka Arvostelukirja, jolla on seuraavat ominaisuudet

Attribuutti omistaja, jonka tyyppi on merkkijono
Attribuutti arvosanat, jonka tyyppi on lista. Listaan tulee voida tallentaa Arvosana-tyyppisiä olioita (luokka löytyy oheisesta ohjelmasta)
Konstruktori, joka saa parametriksi omistajan ja asettaa attribuutin arvon. Lisäksi konstruktori alustaa arvosanalistan.
Attribuuttien tulee olla suojattuja, jotta asiakas ei näe niitä, mutta mahdolliset perivät luokat näkevät. */

class Arvostelukirja {
    protected String omistaja;
    protected ArrayList<Arvosana> arvosanat = new ArrayList<>();

    public Arvostelukirja(String omistaja){
        this.omistaja = omistaja;
        this.arvosanat = new ArrayList<Arvosana>();
    }

}