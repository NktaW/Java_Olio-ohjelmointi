import java.util.Random;

public class Test{
    public static void main(String[] args){
        final Random r = new Random();
        
        
        System.out.println("Testataan luokkaa Erityisohjaaja...");
        String[] nimet = {"Eija Erityinen", "Esko Erityis", "Einari Kurkkunen"};
      
        
        for (String nimi : nimet) {
            int ohjaustunnit = r.nextInt(15);
            int ylitunnit = r.nextInt(15);
            int erityistunnit = r.nextInt(15);
          
            Erityisohjaaja ohjaaja = new Erityisohjaaja(nimi, ohjaustunnit, 
                    ylitunnit, erityistunnit);
        
            System.out.println("Olio luotu parametrien arvoilla...");
            System.out.println("Ohjaustunnit: " + ohjaustunnit);
            System.out.println("Ylitunnit: " + ylitunnit);
            System.out.println("Erityistunnit: " + erityistunnit);
            
            System.out.println("Metodi tunnitYhteensa palauttaa " + ohjaaja.tunnitYhteensa());
            
            System.out.println("");
        
        }
    }
}

class Ohjaaja {
    protected String nimi;
    protected int ohjaustunnit;
    protected int ylitunnit;
    
    public Ohjaaja(String nimi, int ohjaustunnit, int ylitunnit) {
        this.nimi = nimi;
        this.ohjaustunnit = ohjaustunnit;
        this.ylitunnit = ylitunnit;
    }
    
    public int tunnitYhteensa() {
        return ohjaustunnit + ylitunnit;
    }
}

/*Ohjelmassa on määritelty luokka Ohjaaja. Kirjoita luokka Erityisohjaaja, joka perii Ohjaaja-luokan.

Luokassa tulee olla konstruktori, joka saa parametriksi tässä järjestyksessä nimen, tunnit, ylitunnit ja uutena parametrina erityistunnit. Myös tämä parametri on kokonaisluku.

Ylikirjoita perivässä luokassa metodi tunnitYhteensa siten, että se laskee yhteistuntimäärään myös erityistunnit mukaan. */

class Erityisohjaaja extends Ohjaaja {
    private int erityistunnit;

    public Erityisohjaaja(String nimi, int ohjaustunnit, int ylitunnit, int erityistunnit){
        super(nimi, ohjaustunnit, ylitunnit);
        this.erityistunnit = erityistunnit;
    }

    public int tunnitYhteensa(){
        return ohjaustunnit + ylitunnit + erityistunnit;
    }
}
