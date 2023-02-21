import java.util.Random;

public class Test{
    public static void main(String[] args){
        final Random r = new Random();
        
        
        System.out.println("Testataan luokkaa SuojattuYhteys...");
        
        String[] suo = "SHA SSH ABC LTD SMP DDR OY RNO RKK".split(" ");
        String[] salat = "abc123 sala12 salasana sanasala 123456".split(" ");
        
        // Testataan ensin perintä
        Yhteys y = new SuojattuYhteys();
        
        // Konstruktorit
        String suojaus = suo[r.nextInt(suo.length)];
        String sala = salat[r.nextInt(salat.length)];
        int nopeus = r.nextInt(100) + 1;
        
        System.out.println("Luodaan suojattu yhteys parametreilla");
        System.out.println("(" + nopeus + ", " + suojaus + ", " + sala + ")");
        SuojattuYhteys yhteys = new SuojattuYhteys(nopeus, suojaus, sala);
        System.out.println("Nopeus: " + yhteys.getNopeus());
        System.out.println("Suojaus: " + yhteys.getSuojaus());
        System.out.println("Salasana: " + yhteys.getSalasana());
        System.out.println("");
        
        nopeus = r.nextInt(100) + 1;
        System.out.println("Luodaan suojattu yhteys parametreilla");
        System.out.println("(" + nopeus + ")");
        yhteys = new SuojattuYhteys(nopeus);
        System.out.println("Nopeus: " + yhteys.getNopeus());
        System.out.println("Suojaus: " + yhteys.getSuojaus());
        System.out.println("Salasana: " + yhteys.getSalasana());
        System.out.println("");
        
        System.out.println("Luodaan suojattu yhteys parametreilla");
        System.out.println("()");
        yhteys = new SuojattuYhteys();
        System.out.println("Nopeus: " + yhteys.getNopeus());
        System.out.println("Suojaus: " + yhteys.getSuojaus());
        System.out.println("Salasana: " + yhteys.getSalasana());
        System.out.println("");
    }
}
class Yhteys {
    protected int nopeus;
    
    public Yhteys(int nopeus) {
        this.nopeus = nopeus;
    }
    
    public int getNopeus() {
        return nopeus;
    }
}

/*Ohjelmassa on määritelty luokka Yhteys. Kirjoita luokka SuojattuYhteys, joka perii luokan Yhteys.

Luokalla on kaksi uutta merkkijonotyyppistä attribuuttia, suojaus ja salasana. Toteuta näille havainnointimetodit.

Luokalla tulee lisäksi kirjoittaa kolme konstuktoria:

Konstruktori, joka saa parametriksi nopeuden, suojauksen (merkkijono) ja salasanan (myös merkkijono):
Konstruktori asettaa attirbuuttien arvot parametrien mukaisesti.

Konstruktori, joka saa parametrikseen pelkän nopeuden. Konstruktori asettaa nopeus-attribuutin parametrin mukaisesti.
Attribuutin suojaus arvoksi tulee "SHA" ja salasanaksi "abcabc"

Konstruktori, jolla ei ole ollenkaan parametreja. 
Nopeudeksi tulee 100, ja muut attribuutit saavat samat arvot kuin konstuktorin 2 tapauksessa
  */




//Luo luokka SuojattuYhteys, joka perii luokan Yhteys.
class SuojattuYhteys extends Yhteys{
    protected String suojaus;
    protected String salasana;

    public SuojattuYhteys(int nopeus, String suojaus, String salasana){
        super(nopeus);
        this.suojaus = suojaus;
        this.salasana = salasana;
    }


    public SuojattuYhteys(int nopeus){
        super(nopeus);
        this.suojaus = "SHA";
        this.salasana = "abcabc";
    }


    public SuojattuYhteys(){
        super(100);
        this.suojaus = "SHA";
        this.salasana = "abcabc";
    }


    public String getSuojaus(){
        return suojaus;
    }

    public String getSalasana(){
        return salasana;
    }

}